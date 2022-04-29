package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class WarehouseService {

    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();

    public List<AgvDocks> getAllAgvDocks(){
        final Iterable<Warehouse> warehouse = warehouseRepository.findAll();
        return warehouse.iterator().next().allAGVDocks();
    }

}
