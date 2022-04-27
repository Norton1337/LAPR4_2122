package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehouses.dto.WarehouseDTO;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseAddress;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;

public class WarehouseSetupController {

    private Warehouse warehouse;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    public WarehouseSetupController(){}

    public void setupWarehouse(WarehouseDTO dto) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        warehouse = new Warehouse(dto);
        warehouseRepository.save(warehouse);
    }

    public WarehouseAddress getWarehouseAddress(WarehouseDTO dto) throws IOException {
        warehouse= new Warehouse(dto);
        return warehouse.identity();
    }

}
