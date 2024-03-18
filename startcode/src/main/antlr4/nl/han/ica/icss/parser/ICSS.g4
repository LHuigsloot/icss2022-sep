grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//Literals
TRUE: 'TRUE';
FALSE: 'FALSE';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;


//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';




//--- PARSER: ---

stylesheet: ( variableAssignment | styleRule )+ | EOF;

//global
colorLiteral: COLOR;
percentageLiteral: PERCENTAGE;
pixelLiteral: PIXELSIZE;
boolLiteral: TRUE | FALSE;
scalarLiteral: SCALAR;
literal: colorLiteral | percentageLiteral | pixelLiteral | boolLiteral | scalarLiteral;
declaration: OPEN_BRACE ( properties | ifClause )+ CLOSE_BRACE;

//Variables
variableAssignment: variableReference ASSIGNMENT_OPERATOR literal SEMICOLON;
variableReference: CAPITAL_IDENT;

//Operations
expression: expression ('*') expression | expression ('+' | '-') expression | (literal | variableReference) | '('expression')';

//CSS Rules
styleRule: selector declaration;
selector: tagSelector | idSelector | classSelector;
tagSelector: LOWER_IDENT;
idSelector: ID_IDENT;
classSelector: CLASS_IDENT;
properties: propertyName COLON ( literal | variableReference | expression ) SEMICOLON;
propertyName: LOWER_IDENT;

//if-statements
ifClause: IF BOX_BRACKET_OPEN (boolLiteral | variableReference) BOX_BRACKET_CLOSE declaration elseClause?;
elseClause: ELSE declaration;