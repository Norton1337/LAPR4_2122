package eapli.base.app.backoffice.console.presentation.clientuser;



import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

public class CLUMenu extends Menu {
    private static final String MENU_TITLE = "Client User Menu";
    private static final int EXIT_OPTION = 0;

    private static final int BUY_PRODUCTS = 1;

    public CLUMenu(SystemUser systemUser){
        super(MENU_TITLE);
        buildMenu(systemUser);
    }

    private void buildMenu(SystemUser systemUser){
        addItem(BUY_PRODUCTS, "Buy some Products", new ClientUI(systemUser)::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

    }
}
