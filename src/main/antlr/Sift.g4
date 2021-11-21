grammar Sift;

@header {
   package com.rchowell.sift.language.antlr;
}

// https://github.com/trinodb/trino/blob/master/core/trino-parser/src/main/antlr4/io/trino/sql/parser/SqlBase.g4

query: relation (PIPE transform)*;

// -----------
//  Relations
// -----------

// TODO identifiers in scans

relation
    :   ID_QUOTED                                                               #relId
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

expr:   expr op=(LT|LTE|EQ|GT|GTE) expr     #boolExpr // unsure how which precedence to choose
    |   expr op=(AND|OR) expr               #boolExpr
    |   expr op=(MULT|DIV|MOD) expr         #boolExpr
    |   expr op=(PLUS|MINUS) expr           #boolExpr
    |   ID LP expr (COMMA expr)* RP         #funcExpr
    |   ID                                  #identExpr
    |   INT                                 #intLitExpr
    |   STRING                              #stringLitExpr
    |   LP expr RP                          #subExpr;

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
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';

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
DIFF: '\\' | 'DIFF' | 'diff';
INTERSECT: '&' | 'INTERSECT' | 'intersect';

ID : [a-zA-Z_\-]+;
ID_QUOTED: '`' ( ~'`' | '``' )* '`';

STRING: '"' [a-zA-Z]+[a-zA-Z0-9]* '"';
INT : [0-9]+;
WS : [ \t\n\r]+ -> channel(HIDDEN);

// Seen in Trino to catch lexing errors
UNRECOGNIZED: . ;