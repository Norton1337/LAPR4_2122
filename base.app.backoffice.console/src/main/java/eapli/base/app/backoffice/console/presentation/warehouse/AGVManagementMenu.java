package eapli.base.app.backoffice.console.presentation.warehouse;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.Actions;

import java.awt.*;

public class AGVManagementMenu extends Menu {

    private static final String MENU_TITLE = "AGV Management";
    private static final int EXIT_OPTION = 0;

    private static final int ASSIGN_TASKS_TO_AGVS = 1;

    public AGVManagementMenu(){
        super(MENU_TITLE);
        buildMenu();
    }

    private void buildMenu(){
        addItem(ASSIGN_TASKS_TO_AGVS, "Assign tasks automatically", new AGVManagementUI()::show);
        addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

    }
}
