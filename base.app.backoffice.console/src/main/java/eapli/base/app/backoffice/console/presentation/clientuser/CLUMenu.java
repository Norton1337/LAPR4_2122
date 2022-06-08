package eapli.base.app.backoffice.console.presentation.clientuser;



import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

public class CLUMenu extends Menu {
    private static final String MENU_TITLE = "Client User Menu";
    private static final int EXIT_OPTION = 0;

    private static final int BUY_PRODUCTS = 1;

    public CLUMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(BUY_PRODUCTS, "Buy some Products", new ClientUI()::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

    }
}
