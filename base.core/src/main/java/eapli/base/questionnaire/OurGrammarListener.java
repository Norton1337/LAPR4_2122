// Generated from D:/eapli/lei21_22_s4_2dj_4/base.core/src/main/java/eapli/base/questionnaire\OurGrammar.g4 by ANTLR 4.10.1
package eapli.base.questionnaire;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OurGrammarParser}.
 */
public interface OurGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(OurGrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(OurGrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(OurGrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(OurGrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#beginning}.
	 * @param ctx the parse tree
	 */
	void enterBeginning(OurGrammarParser.BeginningContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#beginning}.
	 * @param ctx the parse tree
	 */
	void exitBeginning(OurGrammarParser.BeginningContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(OurGrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(OurGrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void enterWelcome_message(OurGrammarParser.Welcome_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#welcome_message}.
	 * @param ctx the parse tree
	 */
	void exitWelcome_message(OurGrammarParser.Welcome_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(OurGrammarParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(OurGrammarParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#questionnaire_section}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire_section(OurGrammarParser.Questionnaire_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#questionnaire_section}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire_section(OurGrammarParser.Questionnaire_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(OurGrammarParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(OurGrammarParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(OurGrammarParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(OurGrammarParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#final_message}.
	 * @param ctx the parse tree
	 */
	void enterFinal_message(OurGrammarParser.Final_messageContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#final_message}.
	 * @param ctx the parse tree
	 */
	void exitFinal_message(OurGrammarParser.Final_messageContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#questions}.
	 * @param ctx the parse tree
	 */
	void enterQuestions(OurGrammarParser.QuestionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#questions}.
	 * @param ctx the parse tree
	 */
	void exitQuestions(OurGrammarParser.QuestionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(OurGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(OurGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link OurGrammarParser#possible_answers}.
	 * @param ctx the parse tree
	 */
	void enterPossible_answers(OurGrammarParser.Possible_answersContext ctx);
	/**
	 * Exit a parse tree produced by {@link OurGrammarParser#possible_answers}.
	 * @param ctx the parse tree
	 */
	void exitPossible_answers(OurGrammarParser.Possible_answersContext ctx);
}