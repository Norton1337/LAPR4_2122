package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

import java.io.IOException;

public class WarehouseMenu extends Menu {

    private static final String MENU_TITLE = "Warehouse >";

    private static final int EXIT_OPTION = 0;


    private static final int SETUP_WAREHOUSE_OPTION = 1;
    private static final int CONFIGURE_AGV_OPTION = 2;
    private static final int WAITING_ORDERS_OPTION = 3;
    private static final int PREPARED_ORDERS_OPTION = 4;
    public WarehouseMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(SETUP_WAREHOUSE_OPTION, "Setup WarehousePlant", new WarehouseSetupUI()::show);
        addItem(CONFIGURE_AGV_OPTION, "Configure AGV", new ConfigureAGVUI()::show);
        addItem(WAITING_ORDERS_OPTION, "Waiting Orders", new OrdersUI()::show);
        addItem(PREPARED_ORDERS_OPTION, "Prepared Orders", new PreparedOrdersUI()::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
    }
}
