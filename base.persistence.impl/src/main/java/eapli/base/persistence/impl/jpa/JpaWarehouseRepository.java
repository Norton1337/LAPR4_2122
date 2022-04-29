package eapli.base.persistence.impl.jpa;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, WarehouseIdentification, WarehouseIdentification> implements WarehouseRepository {

    JpaWarehouseRepository() {
        super("warehouseAddress");
    }
}
