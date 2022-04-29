package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouses.application.WarehouseSetupController;
import eapli.framework.actions.Action;

import java.io.IOException;

public class WarehouseSetupBootstrapper implements Action{

    private final WarehouseSetupController warehouseSetupController = new WarehouseSetupController();

    @Override
    public boolean execute() {
        try {
            warehouseSetupController.setupWarehouse("src/main/resources/jsonFile.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
