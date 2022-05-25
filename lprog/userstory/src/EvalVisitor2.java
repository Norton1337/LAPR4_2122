package src;

import java.util.HashMap;
import java.util.Map;
public class EvalVisitor2 extends OurGrammarBaseVisitor<Integer> {
    /*** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<>();
    /**
     * ID '=' expr NEWLINE
     */

    /*** expr NEWLINE */
    @Override
    public Integer visitPrintExpr(OurGrammarParser.PrintExprContext ctx) {
        System.out.println(ctx); // print the result
        return 0; // return dummy value
    }

}