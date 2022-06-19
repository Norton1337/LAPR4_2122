package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.warehouse.UpdateDispatchedOrdersUI;
import eapli.base.app.backoffice.console.questionnaire.CreateQuestionnaireUI;
import eapli.base.app.backoffice.console.questionnaire.QuestionnaireReportsUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class SalesManagerMenu extends Menu {
    private static final String MENU_TITLE = "Sales Clerk Menu";
    private static final int EXIT_OPTION = 0;

    private static final int QUESTIONNAIRES = 1;

    public SalesManagerMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(QUESTIONNAIRES, "Questionnaires Statistics", new QuestionnaireReportsUI()::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

    }
}
