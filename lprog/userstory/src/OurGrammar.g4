grammar OurGrammar;

prog: stat;

stat: beginning NEWLINE questionnaire
;

beginning: STRING NEWLINE STRING
;

questionnaire: (questions NEWLINE answers NEWLINE)+
;

questions: STRING
;

answers: STRING
;


NEWLINE : [\r\n]+ ;
INT:[0-9]+;
STRING:([a-z]|[A-Z]|' '|','|'.'|INT)+;
