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

content: (questions)+
;

description: LPARENTH STRING RPARENTH
;

final_message: STRING
;

questions:  STRING QMARK type
| STRING QMARK type
;

type: OPTIONAL '[Multiple Choice]' possible_answers (NEWLINE (STRING|INT) NEWLINE|NEWLINE)
| OPTIONAL '[Numeric]' (NEWLINE INT NEWLINE|NEWLINE)
| OPTIONAL '[Free Text]' (NEWLINE STRING NEWLINE|NEWLINE)
| OBLIGATORY '[Multiple Choice]' possible_answers NEWLINE (STRING|INT) NEWLINE
| OBLIGATORY '[Numeric]' NEWLINE INT NEWLINE
| OBLIGATORY '[Free Text]' NEWLINE STRING NEWLINE
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
