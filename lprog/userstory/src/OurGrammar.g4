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

questionnaire: (questionnaire_section)+ final_message
;

questionnaire_section: SECTION title description NEWLINE content
;

content: (questions NEWLINE)+
;

description: LPARENTH STRING RPARENTH
;

final_message: STRING
;

questions: OPTIONAL STRING QMARK type
| OBLIGATORY STRING QMARK type
;

type: '[Multiple Choice]' possible_answers NEWLINE STRING
| '[Numeric]' NEWLINE INT
| '[Free Text]' NEWLINE STRING
;

possible_answers: (STRING '|')+
;
SECTION: 'Section' INT ':';
TYPES: LSQRPARENTH ('Multiple Choice'|'Numeric'|'Free Text') RSQRPARENTH;
NEWLINE : [\r\n]+ ;
INT:[0-9]+;
SPACE:' ';
STRING:([a-z]|[A-Z]|','|' '|'.'|'!'|INT)+;
QMARK: '?' SPACE*;
LPARENTH:'(';
RPARENTH:')';
LSQRPARENTH:'[';
RSQRPARENTH:']';
OPTIONAL: '(optional)';
OBLIGATORY: '(obligatory)';
