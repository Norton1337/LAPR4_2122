grammar OurGrammar;

prog: stat;

stat: beginning NEWLINE questionnaire
;

beginning: title NEWLINE welcome_message
;
title: STRING
;
welcome_message: STRING
;

questionnaire: (questions NEWLINE answers NEWLINE)+
;

questions: STRING QMARK OPTIONALITY possible_answers NEWLINE type
;
type: TYPES
;
possible_answers: (STRING '|')*
;

answers: STRING
;

TYPES: LSQRPARENTH ('Multiple Choice'|'Numeric'|'Free Text') RSQRPARENTH;
NEWLINE : [\r\n]+ ;
INT:[0-9]+;
SPACE:' ';
STRING:([a-z]|[A-Z]|','|' '|'.'|INT)+;
QMARK: '?';
OPTIONALITY: LPARENTH (OPTIONAL|OBLIGATORY) RPARENTH;
LPARENTH:'(';
RPARENTH:')';
LSQRPARENTH:'[';
RSQRPARENTH:']';
OPTIONAL: 'optional';
OBLIGATORY: 'obligatory';
