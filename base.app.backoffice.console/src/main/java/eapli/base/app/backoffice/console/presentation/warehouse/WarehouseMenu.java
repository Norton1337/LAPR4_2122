package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;

import java.io.IOException;

public class WarehouseMenu extends Menu {

    private static final String MENU_TITLE = "Warehouse >";

    private static final int EXIT_OPTION = 0;


    private static final int SETUP_WAREHOUSE_OPTION = 1;
    private static final int CONFIGURE_AGV_OPTION = 2;
    public WarehouseMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(SETUP_WAREHOUSE_OPTION, "Setup WarehousePlant", new WarehouseSetupUI()::show);
        addItem(CONFIGURE_AGV_OPTION, "Configure AGV", new ConfigureAGVUI()::show);
        addItem(EXIT_OPTION, "rETURN", Actions.SUCCESS);
    }
}
