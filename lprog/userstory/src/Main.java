package src;

import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("lprog/userstory/src/questionarioTeste.txt"));
        OurGrammarLexer lexer= new OurGrammarLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        OurGrammarParser parser = new OurGrammarParser(tokens);
        ParseTree tree = parser.prog(); // parse
        EvalVisitorOurGrammar eval = new EvalVisitorOurGrammar();
        eval.visit(tree);
    }
}