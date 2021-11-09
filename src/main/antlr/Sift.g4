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
    |   relation op=(UNION|CROSS|DIFF|INTERSECT) relation                       #relBagOp
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

distinct: DISTINCT (ids)?;

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
MIN: 'MIN' | 'Min' | 'min';
MAX: 'MAX' | 'Max' | 'max';
SUM: 'SUM' | 'Sum' | 'sum';
AVG: 'AVG' | 'Avg' | 'avg';
COUNT: 'COUNT' | 'Count' | 'count';

// Transforms
SELECT: 'SELECT' | 'Select' | 'select';
PROJECT: 'PROJECT' | 'Project' | 'project';
GROUP: 'GROUP' | 'Group' | 'group';
SORT: 'SORT' | 'Sort'| 'sort';
LIMIT: 'LIMIT' | 'Limit' | 'limit';
DISTINCT: 'DISTINCT' | 'Distinct' | 'distinct';

// Keywords
ON: 'ON' | 'on';
AS: 'AS' | 'as';
BY: 'BY' | 'by';
OUTER: 'OUTER' | 'outer';
LEFT: 'LEFT' | 'left';
RIGHT: 'RIGHT' | 'right';
ASC: 'ASC' | 'asc';
DESC: 'DESC' | 'desc';
TRUE: 'TRUE' | 'true';
FALSE: 'FALSE' | 'false';

// Bag Ops
JOIN: 'JOIN' | 'join';
CROSS: 'X' | 'CROSS' | 'cross';
UNION: 'U' | 'UNION' | 'union';
DIFF: '-' | 'DIFF' | 'diff';
INTERSECT: '&' | 'INTERSECT' | 'intersect';

ID : [a-zA-Z_\-]+;
STRING: '"' [a-zA-Z]+[a-zA-Z0-9]* '"';
INT : [0-9]+;
WS : [ \t\n\r]+ -> skip;
