# Sift

The purpose of the Sift language is to provide a super simple query language that maps near 1:1 to operators of the extended relational algebra discussed in section 5.2 of Garcia-Molina et. al. It is literally an inversion the query expression tree; with the inversion coming from using functional pipes '|>' rather than nested transformations. The point is to keep it simple, stupid and allows me to interact with the query engine at a lower level than the eventual SQL parser with pre-processor will allow. Much of the book uses typeset expressions of relational algebra, and I wanted to run these expressions literally without translating to SQL. I chose to use the F# (and Elixir) pipe operator to simplify writing nested transformations. Ligatures recommended.

## Usage

TODO

## Grammar

The following shorthand is used 
```
(X)* # 0 or n of X
(X)? # 0 or 1 of X
(X)+ # 1 or n of X

# Comma-separated lists of <X>
<X> = <X> (, <X>)*
```

```bash
<ID>      ::= [A-Za-z\-_]+  # operators, relation and field identifiers
<STRING>  ::= '[A-Za-z0-9\s]+'
<NUM>     ::= [0-9]+(.[0-9]+)?
<BOOL>    ::= (TRUE|FALSE|UNKOWN)
<NULL>    ::= NULL
```

### Query

A query is an initial *relation producing* operation followed by several transformations. Each transformation is an operation from the extended relational algebra. Leaf nodes of the query expression tree must be relations. For sake of simplicity, Sift currently only supports binary joins, so the parent of any given leaf node has at least one and at most two children.

```bash
<QUERY> ::= <RELATION-PRODUCTION> <TRANSFORMS>
```

### Transformations

```bash
<TRANSFORMS> ::= (|> <TRANSFORM>)*
<TRANSFORM>  ::= <SELECT>
              |  <PROJECT>
              |  <GROUP>
              |  <SORT> (BY <IDS>)? (ASC|DESC)
              |  LIMIT <NUM>
              |  DISTINCT
``` 

#### Relations

Relation nesting and precedence might get out of hand.

```bash
<RELATION-PRODUCTION> ::= <RELATION>
                       |  <JOIN>
                       |  <CROSS>
                       |  <UNION>
                       |  <DIFF>
                       |  <INTERSECT>

<RELATION>  ::= '<ID>'        # quoted identifier
             |  (<QUERY>)     # sub-query
             |  <REL-LITERAL> # relation literal

<JOIN>      ::= <RELATION> (AS <ID>)? (OUTER|LEFT|RIGHT)? JOIN <RELATION> (AS <ID>)? (ON <EXPR>)?
<CROSS>     ::= <RELATION> (X|CROSS) <RELATION>
<UNION>     ::= <RELATION> (U|UNION) <RELATION>
<DIFF>      ::= <RELATION> (\|DIFF) <RELATION>
<INTERSECT> ::= <RELATION> (&|INTERSECT) <RELATION>
```

Let *R(A, B, C)* and *S(B, C, D)* be two relations. Here are some example relation productions, including subqueries.
```bash
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

#### Selection

`<EXPR>` must be a predicate ie an expression that evaluates to a boolean

```bash
<SELECT> ::= SELECT <EXPR>
```

#### Projection
```bash
<PROJECT> ::= PROJECT <FUNCS>
<FUNC>    ::= <ID>
           |  <EXPR> -> <ID>
```

#### Group
```bash
<GROUP> ::= GROUP <AGGS> (BY <IDS>)?
<AGG>   ::= <ID>(<ID>) (AS <ID>)?
```

Examples
```
'People'
  |> PROJECT height, age
  |> GROUP AVG(height), MIN(height), MAX(height) BY age
```

### Expressions

```bash
<EXPR>    ::= <EXPR> <OP> <LITERAL>
           | ( <EXPR> )
           | <ID>(<ID>)
           | <ID>
           | <LITERAL>
<LITERAL> ::= (<STRING>|<NUM>|<BOOL>|<NULL>)
<OP>      ::= ()
```

### Examples
```bash
'People'
  |> PROJECT name, age
  |> SELECT name ~ 'H%' && age > 20
```

```bash
'Movies'
  |> SELECT year = 1979 && studioName = 'Paramount'
  |> PROJECT title
```
