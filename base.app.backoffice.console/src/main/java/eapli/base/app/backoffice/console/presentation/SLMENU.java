package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.questionnaire.CreateQuestionnaireUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class SLMENU extends Menu {
    private static final String MENU_TITLE = "Sales Clerk Menu";
    private static final int EXIT_OPTION = 0;

    private static final int QUESTIONNAIRES = 1;

    public SLMENU(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(QUESTIONNAIRES, "1 - Questionnaires", new CreateQuestionnaireUI());
        addItem(EXIT_OPTION, "0 - Return", Actions.SUCCESS);

    }
}
