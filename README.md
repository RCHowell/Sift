## Preface

I built this as an exercise while studying [Database Systems: The Complete Book](http://infolab.stanford.edu/~ullman/dscb.html) (DSCB) by Hector Garcia-Molina, Jeff Ullman, and Jennifer Widom. I also wanted to experiment with Apache Arrow, and I found Andy Grove's [KQuery](https://github.com/andygrove/how-query-engines-work); much of this work is modelled after his engine, and I have left notes where I use some of his constructs. This exercise was more about studying the execution of queries, so little effort was put into the parser and planner. There are currently no plan optimizations, and the language is simply syntactic sugar over the operators of Relation Algebra discussed in DSCB. 

## Operations
- Scan
- Selection
- Projection
- Limit
- Grouping/Aggregation
- Distinct
- Sort (TODO)
- Join / Union / Difference / Intersection (TODO)

## Language

> Full details in *sift.lang/README.md*

The purpose of the Sift language is to have a query language that maps near 1:1 to operators of the extended relational algebra discussed in section 5.2 of Garcia-Molina et. al. It is literally an inversion of the query expression tree using the F# (and Elixir) pipe operator to simplify writing nested transformations.

Limitations in the language come from my inability to dedicate time to the parser. Right now, I'm more interested in learning about parser generators. The purpose of the hand-written lexer and parser was to learn some basics.

A query is formed with a relation production followed by transformations. All type data is provided by the **Schema** of a data **Source** which is registered to the query execution environment. The full BNF is at the bottom.

### Relation Productions

Let *R(A, B, C)* and *S(B, C, D)* be two relations. Here are some example relation productions, including subqueries.
```
# simple scan
'R'

# joins
'R' JOIN 'S'
'R' OUTER JOIN 'S'
'R' JOIN 'S' ON A = D

# equivalent to the previous join
'R' X 'S' |> SELECT A = D

# project tuples to same domain prior to union
('R' |> PROJECT B, C) UNION ('S' |> PROJECT B, C)

# Let T(X, Y) and V(X, Y) be two relations
'T' X 'V' # cross
'T' U 'V' # union
'T' \ 'V' # difference
'T' & 'V' # intersection
```

### Examples

```
Q: Select all titles produced by Paramount between 1979 and 1982

'Movies'
  |> SELECT (1979 <= Year && Year <= 1982) && Studio = 'Paramount'
  |> PROJECT Title
```

```
Q: Get the average, min, and max heights of all players by age and position

'Players'
  |> PROJECT Height, Age
  |> GROUP AVG(Height) -> Avg, MIN(Height) -> Shortest, MAX(Height) -> Tallest BY Age, Position
```

## Execution

> Do 'gradle run --console plain' to run the interactive query shell

### Sample Data

The sample data is a collection of some fuzzy friends.

```
┌─────────────┬────────────┬────────────┬────────────┬────────────┬────────────┐
│Name         │Age         │Gender      │Weight      │Type        │Breed       │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Ramona       │2.00        │F           │8.00        │Cat         │Mini Coon   │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Mochi        │2.00        │F           │45.00       │Dog         │Samoyed     │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Cali         │7.00        │F           │30.00       │Dog         │Vizsla      │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Gretchen     │13.00       │F           │50.00       │Dog         │English     │
│             │            │            │            │            │Bulldog     │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Cooper       │6.00        │M           │30.00       │Dog         │Beagle      │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Eleanor      │5.00        │F           │24.00       │Dog         │Cocker      │
│             │            │            │            │            │Spaniel     │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Huckleberry  │7.00        │M           │20.00       │Cat         │Medium Coon │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Madman Mochi │3.00        │M           │14.00       │Cat         │Unknown     │
└─────────────┴────────────┴────────────┴────────────┴────────────┴────────────┘
```

### Selection

> You can see I have a bug in the precedence of parsing, but I don't care much about the parser

```
'Pets' |> SELECT (Type = 'Dog') && (Gender = 'F')

┌─────────────┬────────────┬────────────┬────────────┬────────────┬────────────┐
│Name         │Age         │Gender      │Weight      │Type        │Breed       │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Mochi        │2.00        │F           │45.00       │Dog         │Samoyed     │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Cali         │7.00        │F           │30.00       │Dog         │Vizsla      │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Gretchen     │13.00       │F           │50.00       │Dog         │English     │
│             │            │            │            │            │Bulldog     │
├─────────────┼────────────┼────────────┼────────────┼────────────┼────────────┤
│Eleanor      │5.00        │F           │24.00       │Dog         │Cocker      │
│             │            │            │            │            │Spaniel     │
└─────────────┴────────────┴────────────┴────────────┴────────────┴────────────┘
```

### Projection


```
'Pets'
  |> SELECT Type = 'Cat'
  |> PROJECT Name + ' is a ' + Breed + ' kitty cat' -> Greeting

┌──────────────────────────────────────────────────────────────────────────────┐
│Greeting                                                                      │
├──────────────────────────────────────────────────────────────────────────────┤
│Ramona is a Mini Coon kitty cat                                               │
├──────────────────────────────────────────────────────────────────────────────┤
│Huckleberry is a Medium Coon kitty cat                                        │
├──────────────────────────────────────────────────────────────────────────────┤
│Madman Mochi is a Unknown kitty cat                                           │
└──────────────────────────────────────────────────────────────────────────────┘
```


### Aggregations

```
'Pets' |> GROUP MAX(Weight) -> Thiccest BY Type

┌───────────────────────────────────────┬──────────────────────────────────────┐
│Type                                   │Thiccest                              │
├───────────────────────────────────────┼──────────────────────────────────────┤
│Cat                                    │20.00                                 │
├───────────────────────────────────────┼──────────────────────────────────────┤
│Dog                                    │50.00                                 │
└───────────────────────────────────────┴──────────────────────────────────────┘
```

---

## SiftQL BNF

```
# Tokens
<ID>      ::= [A-Za-z\-_]+  # operators, relation and field identifiers
<STRING>  ::= '[A-Za-z0-9\s]+'
<NUM>     ::= [0-9]+(.[0-9]+)?
<BOOL>    ::= (TRUE|FALSE|UNKOWN)
<NULL>    ::= NULL

<QUERY> ::= <RELATION-PRODUCTION> <TRANSFORMS>

<RELATION-PRODUCTION> ::= <RELATION>
                       |  <JOIN>
                       |  <CROSS>
                       |  <UNION>
                       |  <DIFF>
                       |  <INTERSECT>

<RELATION>  ::= '<ID>'        # quoted identifier
             |  ( <QUERY> )     # sub-query

<JOIN>      ::= <RELATION> (AS <ID>)? (OUTER|LEFT|RIGHT)? JOIN <RELATION> (AS <ID>)? (ON <EXPR>)?
<CROSS>     ::= <RELATION> (X|CROSS) <RELATION>
<UNION>     ::= <RELATION> (U|UNION) <RELATION>
<DIFF>      ::= <RELATION> (\|DIFF) <RELATION>
<INTERSECT> ::= <RELATION> (&|INTERSECT) <RELATION>

<TRANSFORMS> ::= (|> <TRANSFORM>)*
<TRANSFORM>  ::= <SELECT>
              |  <PROJECT>
              |  <GROUP>
              |  <SORT> (BY <IDS>)? (ASC|DESC)
              |  LIMIT <NUM>
              |  DISTINC
              
<SELECT> ::= SELECT <EXPR>

<PROJECT> ::= PROJECT <FUNCS>
<FUNC>    ::= <ID>
           |  <EXPR> -> <ID>
           
<GROUP>    ::= GROUP <AGGS> (BY <IDS>)?
<AGG>      ::= <AGG_FUNC> -> <ID>
<AGG_FUNC> ::= \#<ID>(<ID>)

<EXPR>    ::= <FACTOR>
           |  <FACTOR> <OP> <EXPR>
           |  ( <EXPR> )
<FACTOR>  ::= <ID>            # field reference
           |  \#<ID>(<EXPR>)  # functions
           |  <LITERAL>
<LITERAL> ::= (<STRING>|<NUM>|<BOOL>|<NULL>)
```

## Shell

Try Graal
