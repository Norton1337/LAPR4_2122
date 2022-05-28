package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryOrderRepository extends InMemoryDomainRepository<Order, OrderID>
        implements OrderRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<Order> findAll(){

        return null;
    }

}
