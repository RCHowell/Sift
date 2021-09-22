grammar Sift;

query: relation (PIPE transform)*;

// ===========
//  Relations
// ===========
relation
    :   ID                                                                      #relId
    |   LP query RP                                                             #relSubquery
    |   relation (alias)? (OUTER|LEFT|RIGHT)? JOIN relation (alias)? (ON expr)  #relJoin
    |   relation ('X'|CROSS) relation                                           #relCross
    |   relation ('U'|UNION) relation                                           #relUnion
    |   relation ('-'|DIFF) relation                                            #relDiff
    |   relation ('&'|INTERSECT) relation                                       #relIntersect
    ;

// ============
//  Transforms
// ============
transform
    :   select
    |   project
    |   group
    |   sort
    |   limit
    |   distinct
    ;

select: SELECT expr;

project: PROJECT func (COMMA func)*;

group: GROUP agg (COMMA agg)* (BY ids)?;

sort: SORT (BY ids)? (ASC|DESC)?;

limit: LIMIT INT;

distinct: DISTINCT;

// ===========================
//  Expressions and Functions
// ===========================

expr:   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   INT
    |   ID
    |   SQUOTE WORD SQUOTE
    |   LP expr RP;

func:   ID
    |   expr MAPS ID
    ;

agg: ID LP ID RP (MAPS ID)?; // ID(ID) -> ID

alias: AS ID;

ids: ID (COMMA ID)*;

// ========
//  Tokens
// ========

ID : [a-zA-Z]+;
WORD: [a-zA-Z]+[a-zA-Z0-9]+;
INT : [0-9]+;
WS : [ \t]+ -> skip;

// Symbols
NEWLINE: '\n';
PIPE : '|>';
MAPS : '->';
LP: '(';
RP: ')';
COMMA: ',';
SQUOTE: '\'';

// Transforms
SELECT: 'SELECT';
PROJECT: 'PROJECT';
GROUP: 'GROUP';
SORT: 'SORT';
LIMIT: 'LIMIT';
DISTINCT: 'DISTINCT';

// Keywords
ON: 'ON';
AS: 'AS';
BY: 'BY';
OUTER: 'OUTER';
LEFT: 'LEFT';
RIGHT: 'RIGHT';
ASC: 'ASC';
DESC: 'DESC';
TRUE: 'TRUE';
FALSE: 'FALSE';
AND: 'AND';
OR: 'OR';

// Bag Ops
JOIN: 'JOIN';
CROSS: 'CROSS';
UNION: 'UNION';
DIFF: 'DIFF';
INTERSECT: 'INTERSECT';
