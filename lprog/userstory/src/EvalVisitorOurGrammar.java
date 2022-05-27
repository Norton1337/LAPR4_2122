package src;

import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class EvalVisitorOurGrammar extends OurGrammarBaseVisitor<String>{

    String questionnaireTitle;
    String welcomeMessage;

    @Override public String visitBeginning(OurGrammarParser.BeginningContext ctx) {
        this.questionnaireTitle= String.valueOf(ctx.title().STRING());
        this.welcomeMessage= String.valueOf(ctx.welcome_message().STRING());
        System.out.println(questionnaireTitle);
        System.out.println(welcomeMessage+"\n");
        return visitChildren(ctx);
    }



    @Override public String visitQuestionnaire_section(OurGrammarParser.Questionnaire_sectionContext ctx) {
        String section = ctx.SECTION().getText().replace(":","");
        String sectionDesc = ctx.description().STRING().getText();


        System.out.println("\n"+section + " - " +sectionDesc+"\n");

        return visitChildren(ctx);
    }


    @Override public String visitFinal_message(OurGrammarParser.Final_messageContext ctx) {
        System.out.println(ctx.STRING().getText());
        return visitChildren(ctx);
    }

    @Override public String visitQuestions(OurGrammarParser.QuestionsContext ctx) {

        int questionNumber = Integer.parseInt(ctx.STRING().getText().substring(1,ctx.STRING().getText().indexOf(".")));
        String question = ctx.STRING().getText().substring(4,ctx.STRING().getText().length())+ctx.QMARK();
        System.out.println(questionNumber+". "+question);
        return visitChildren(ctx);
    }

    @Override public String visitType(OurGrammarParser.TypeContext ctx) {


        try {
            if (ctx.STRING() != null) {
                String answer = ctx.STRING().toString().toLowerCase();
                if (ctx.possible_answers() != null) {
                    List<TerminalNode> array = ctx.possible_answers().STRING();
                    List<String> stringList = new ArrayList<>();
                    for (TerminalNode t: array) {
                        stringList.add(t.toString().replace(" ","").toLowerCase());
                    }

                    if(!stringList.contains(answer)){
                        throw new Exception("Provided answer doesn't exist in options");
                    }

                }

                System.out.println(answer + "\n\n");
            }else if(ctx.INT() != null){
                Integer answer = Integer.parseInt(ctx.INT().toString());
                if (ctx.possible_answers() != null) {
                    List<TerminalNode> array = ctx.possible_answers().STRING();
                    List<Integer> intList = new ArrayList<>();
                    for (TerminalNode t: array) {
                        intList.add(Integer.parseInt(t.toString().replace(" ","")));
                    }
                    if(!intList.contains(answer)){
                        throw new Exception("Provided answer doesn't exist in options");
                    }

                }

                System.out.println(answer + "\n\n");
            }
            else{
                System.out.println("- Did not answer -\n");
            }
        }   catch(Exception e){
            e.printStackTrace();
        }
        return visitChildren(ctx);
    }



}
