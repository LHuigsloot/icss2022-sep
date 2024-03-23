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

//Variables
variableAssignment: variableReference SEMICOLON | variableReference ASSIGNMENT_OPERATOR (literal | operation) SEMICOLON;
variableReference: CAPITAL_IDENT;

//Operations
operation: operation multiplyOperation operation |  operation (addOperation | substractOperation) operation  | (literal | variableReference) | '('operation')';
multiplyOperation: MUL ;
addOperation: PLUS ;
substractOperation: MIN ;

//CSS Rules
styleRule: selector OPEN_BRACE (declaration | ifClause | variableAssignment)+ CLOSE_BRACE;
selector: tagSelector | idSelector | classSelector;
tagSelector: LOWER_IDENT;
idSelector: ID_IDENT;
classSelector: CLASS_IDENT;
declaration: propertyName COLON ( literal | variableReference | operation ) SEMICOLON;
propertyName: LOWER_IDENT;

//if-statements
ifClause: IF BOX_BRACKET_OPEN (boolLiteral | variableReference) BOX_BRACKET_CLOSE OPEN_BRACE (declaration | ifClause)+ CLOSE_BRACE elseClause?;
elseClause: ELSE OPEN_BRACE (declaration | ifClause)+ CLOSE_BRACE;