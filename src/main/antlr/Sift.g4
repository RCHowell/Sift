grammar Sift;

@header {
   package com.rchowell.sift.lang.antlr;
}

query: relation (PIPE transform)*;

// ===========
//  Relations
// ===========

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

// ============
//  Transforms
// ============
transform
    :   select      #transformSelect
    |   project     #transformProject
    |   group       #transformGroup
    |   sort        #transformSort
    |   limit       #transformLimit
    |   distinct    #transformDistinct
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

expr:   expr op=(LT|LTE|EQ|GT|GTE) expr     #comparisonExpr
    |   ID                                  #identExpr
    |   INT                                 #intLitExpr
    |   STRING                              #stringLitExpr
    |   LP expr RP                          #quotedExpr;

func:   ID
    |   expr MAPS ID
    ;

agg: ID LP ID RP mapsto?; // ID(ID) (-> ID)?

alias: AS ID;

mapsto: (MAPS ID);

ids: ID (COMMA ID)*;

// ========
//  Tokens
// ========

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

ID : [a-zA-Z]+;
STRING: '"' [a-zA-Z]+[a-zA-Z0-9]* '"';
INT : [0-9]+;
WS : [ \t\n\r]+ -> skip;
