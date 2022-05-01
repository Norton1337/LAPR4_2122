package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.warehouses.application.WarehouseSetupController;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.framework.io.util.Console;

import java.io.IOException;

public class WarehouseSetupUI {
    private final WarehouseSetupController warehouseSetupController = new WarehouseSetupController();


    public boolean show() {
        System.out.println("Setup new warehouse plant");
        System.out.println("Insert new json file");
        String jsonFile = Console.readNonEmptyLine("Insert warehouse plant json file:","Case sensitive");
        try {
            warehouseSetupController.setupWarehouse(jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }



}
