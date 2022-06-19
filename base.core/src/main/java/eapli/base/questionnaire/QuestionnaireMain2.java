package eapli.base.questionnaire;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class QuestionnaireMain2 {

    public QuestionnaireMain2(){

    }

    public static void main(String[] args) throws IOException {
        String filePath = "Questionarios/QuestionariosUS3501/";
        String fileName= "questionarioTeste";
        FileInputStream fis = new FileInputStream(new File(filePath+fileName+".txt"));
        OurGrammarLexer lexer= new OurGrammarLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OurGrammarParser parser = new OurGrammarParser(tokens);
        ParseTree tree = parser.prog();
        EvalVisitorOurGrammar2 eval = new EvalVisitorOurGrammar2(filePath,fileName);
        eval.visit(tree);
    }

    public static void answerQuestionnaire(String filePath) {
        try{
            FileInputStream fis = new FileInputStream(new File(filePath));
            OurGrammarLexer lexer= new OurGrammarLexer(new ANTLRInputStream(fis));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            OurGrammarParser parser = new OurGrammarParser(tokens);
            ParseTree tree = parser.prog();
            EvalVisitorOurGrammar2 eval = new EvalVisitorOurGrammar2(filePath,filePath);
            eval.visit(tree);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}