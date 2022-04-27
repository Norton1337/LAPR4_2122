package eapli.base.app.backoffice.console.presentation;

import eapli.base.warehouses.application.WarehouseSetupController;

public class WarehouseSetupUI {
    private WarehouseSetupController warehouseSetupController = new WarehouseSetupController();

    public boolean show(){
        System.out.println("Setup new warehouse plant");
        return false;
    }



}
