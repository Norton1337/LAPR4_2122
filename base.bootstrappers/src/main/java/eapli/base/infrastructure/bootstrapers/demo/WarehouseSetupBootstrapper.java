package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.warehouses.application.WarehouseSetupController;
import eapli.framework.actions.Action;

import java.io.File;
import java.io.IOException;

public class WarehouseSetupBootstrapper implements Action{

    private final WarehouseSetupController warehouseSetupController = new WarehouseSetupController();

    @Override
    public boolean execute() {
        try {
            String userDirectory = new File("").getAbsolutePath();
            warehouseSetupController.setupWarehouse(userDirectory+"/base.core/src/main/resources/jsonFile.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
