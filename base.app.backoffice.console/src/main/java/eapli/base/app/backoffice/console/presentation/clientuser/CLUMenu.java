package eapli.base.app.backoffice.console.presentation.clientuser;



import eapli.base.app.backoffice.console.questionnaire.QuestionnaireUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CLUMenu extends Menu {
    private static final String MENU_TITLE = "Client User Menu";
    private static final int EXIT_OPTION = 0;

    private static final int BUY_PRODUCTS = 1;
    private static final int CHECK_ORDERS = 2;
    private static final int CHECK_QUSETIONNAIRES = 3;

    public CLUMenu(SystemUser systemUser){
        super(MENU_TITLE);
        buildMenu(systemUser);
    }

    private void buildMenu(SystemUser systemUser){
        addItem(BUY_PRODUCTS, "Buy some Products", new ClientBuyItemsUI(systemUser)::show);
        addItem(CHECK_ORDERS, "Check my open orders", new ClientCheckOrdersUI(systemUser)::show);
        addItem(CHECK_QUSETIONNAIRES, "Check questionnaires", new QuestionnaireUI()::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

    }
}
