package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.warehouse.UpdateDispatchedOrdersUI;
import eapli.base.app.backoffice.console.questionnaire.CreateQuestionnaireUI;
import eapli.framework.actions.Action;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class SalesClerkMenu extends Menu {
    private static final String MENU_TITLE = "Sales Clerk Menu";
    private static final int EXIT_OPTION = 0;

    private static final int QUESTIONNAIRES = 1;
    private static final int UPDATEDISPORDERS = 2;

    public SalesClerkMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(QUESTIONNAIRES, "1 - Questionnaires", new CreateQuestionnaireUI());
        addItem(UPDATEDISPORDERS, "Update dispatched orders", (Action) new UpdateDispatchedOrdersUI());
        addItem(EXIT_OPTION, "0 - Return", Actions.SUCCESS);

    }
}
