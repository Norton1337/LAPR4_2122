package eapli.base.questionnaire;

import eapli.framework.io.util.Console;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EvalVisitorOurGrammar2 extends OurGrammarBaseVisitor<String>{

    String path;
    String name;
    public EvalVisitorOurGrammar2(String path, String name){
        this.path=path;
        this.name=name;
    }

    String questionnaireTitle;
    String welcomeMessage;

    List<Integer> questionNumbers = new ArrayList<>();
    List<String> questionAnswers = new ArrayList<>();

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
        System.out.println(this.questionAnswers);
        System.out.println(this.questionNumbers);
        if(Files.exists(Path.of("Questionarios/Answers/"+ this.name + "Answers.txt"))) {
            try {
                FileWriter fw = new FileWriter("Questionarios/Answers/"+ this.name + "Answers.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int i=0;i<this.questionAnswers.size();i++) {
                    bw.write(questionNumbers.get(i).toString()+","+questionAnswers.get(i)+"\r\n");
                }
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else try {
            String dir = System.getProperty("user.dir");
            PrintWriter pw = new PrintWriter(new File("Questionarios/Answers/"+ this.name+"Answers.txt"));
            StringBuilder sb = new StringBuilder();
            sb.append("question Number");
            sb.append(",");
            sb.append("answer");

            sb.append("\r\n");
            for (int i=0;i<this.questionAnswers.size();i++) {
                sb.append(questionNumbers.get(i).toString());
                sb.append(",");
                sb.append(questionAnswers.get(i));
                sb.append("\r\n");
            }
            pw.write(sb.toString());
            pw.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return visitChildren(ctx);
    }

    @Override public String visitQuestions(OurGrammarParser.QuestionsContext ctx) {

        int questionNumber = Integer.parseInt(ctx.STRING().getText().substring(1,ctx.STRING().getText().indexOf(".")));
        String question = ctx.STRING().getText().substring(4,ctx.STRING().getText().length())+ctx.QMARK();
        System.out.println(questionNumber+". "+question);
        this.questionNumbers.add(questionNumber);
        //this.questionAnswers.add(answerQuestions(questionNumber));
        return visitChildren(ctx);
    }

    @Override public String visitType(OurGrammarParser.TypeContext ctx) {
        if(ctx.possible_answers() != null){
            System.out.println(ctx.possible_answers().STRING());
        }
        boolean valid = true;
        do {
            String answer = Console.readNonEmptyLine("Your answer:", "");
            try {
                if (answer != null) {
                    answer = answer.toLowerCase();
                    if (ctx.possible_answers() != null) {
                        List<TerminalNode> array = ctx.possible_answers().STRING();
                        List<String> stringList = new ArrayList<>();
                        for (TerminalNode t : array) {
                            stringList.add(t.toString().replace(" ", "").toLowerCase());
                        }

                        if (!stringList.contains(answer)) {
                            System.out.println("Provided answer doesn't exist in options");
                            valid = false;
                        }else{
                            valid=true;
                        }

                    }

                    this.questionAnswers.add(answer);
                } else {
                    this.questionAnswers.add("- Did not answer -");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while(!valid);
        return visitChildren(ctx);
    }


}
