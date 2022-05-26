// Generated from D:/OneDrive - Instituto Superior de Engenharia do Porto/2º Semestre/EAPLI/lei21_22_s4_2dj_4/lprog/userstory/src\OurGrammar.g4 by ANTLR 4.10.1
package src;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OurGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OurGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(OurGrammarParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(OurGrammarParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#beginning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginning(OurGrammarParser.BeginningContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#title}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTitle(OurGrammarParser.TitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#welcome_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWelcome_message(OurGrammarParser.Welcome_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(OurGrammarParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#questionnaire_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire_section(OurGrammarParser.Questionnaire_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(OurGrammarParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(OurGrammarParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#final_message}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinal_message(OurGrammarParser.Final_messageContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#questions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestions(OurGrammarParser.QuestionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(OurGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OurGrammarParser#possible_answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPossible_answers(OurGrammarParser.Possible_answersContext ctx);
}