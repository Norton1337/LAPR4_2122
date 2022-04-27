package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseAddress;
import eapli.framework.domain.repositories.DomainRepository;

public interface WarehouseRepository extends DomainRepository<WarehouseAddress,Warehouse> {
}
