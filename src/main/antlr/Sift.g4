grammar Sift;

@header {
   package com.rchowell.sift.lang.antlr;
}

query: relation (PIPE transform)*;

// -----------
//  Relations
// -----------

// TODO identifiers in scans

relation
    :   ID                                                                      #relId
    |   LP query RP                                                             #relSubquery
    |   relation (alias)? (OUTER|LEFT|RIGHT)? JOIN relation (alias)? (ON expr)  #relJoin
    |   relation ('X'|CROSS) relation                                           #relCross
    |   relation ('U'|UNION) relation                                           #relUnion
    |   relation ('-'|DIFF) relation                                            #relDiff
    |   relation ('&'|INTERSECT) relation                                       #relIntersect
    ;

// ------------
//  Transforms
// ------------

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

sort: SORT (ids)? order=(ASC|DESC)?;

limit: LIMIT INT;

distinct: DISTINCT;

// ---------------------------
//  Expressions and Functions
// ---------------------------

expr:   expr op=(LT|LTE|EQ|GT|GTE) expr     #comparisonExpr
    |   expr op=(AND|OR) expr               #boolExpr
    |   ID                                  #identExpr
    |   INT                                 #intLitExpr
    |   STRING                              #stringLitExpr
    |   LP expr RP                          #quotedExpr;

func:   expr MAPS ID    #projMap
    |   ID              #projIdent
    ;

agg: op=(MIN|MAX|SUM|AVG|COUNT) LP expr RP (MAPS ID)?; // AGG(expr) (-> ID)?

alias: AS ID;

ids: ID (COMMA ID)*;

// --------
//  Tokens
// --------

// Symbols
PIPE : '|>';
MAPS : '->';
LP: '(';
RP: ')';
COMMA: ',';
SQUOTE: '\'';

// Ops
EQ: '=';
GT: '>';
LT: '<';
GTE: '>=';
LTE: '<=';
AND: '&&';
OR: '||';

// Aggregations
MIN: 'MIN';
MAX: 'MAX';
SUM: 'SUM';
AVG: 'AVG';
COUNT: 'COUNT';

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

// Bag Ops
JOIN: 'JOIN';
CROSS: 'CROSS';
UNION: 'UNION';
DIFF: 'DIFF';
INTERSECT: 'INTERSECT';

ID : [a-zA-Z_\-]+;
STRING: '"' [a-zA-Z]+[a-zA-Z0-9]* '"';
INT : [0-9]+;
WS : [ \t\n\r]+ -> skip;
