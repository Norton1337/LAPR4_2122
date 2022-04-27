package eapli.base.app.backoffice.console.presentation;

import eapli.base.warehouses.application.ConfigureAGVController;

public class ConfigureAGVUI {
    private ConfigureAGVController agvController = new ConfigureAGVController();

    public boolean show(){
        System.out.println("Setup new agv plant");
        return false;
    }
}
