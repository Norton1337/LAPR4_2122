package eapli.base.persistence.impl.jpa;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseAddress;
import eapli.base.warehouses.repositories.WarehouseRepository;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, WarehouseAddress,WarehouseAddress> implements WarehouseRepository {

    JpaWarehouseRepository() {
        super("warehouseAddress");
    }
}
