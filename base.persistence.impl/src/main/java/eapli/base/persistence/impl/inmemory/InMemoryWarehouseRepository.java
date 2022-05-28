package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class InMemoryWarehouseRepository extends InMemoryDomainRepository<Warehouse, WarehouseIdentification>
        implements WarehouseRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<Warehouse> findAll(){

        return null;
    }
    @Override
    public boolean containsOfIdentity(WarehouseIdentification id) {
        return super.containsOfIdentity(id);
    }
}
