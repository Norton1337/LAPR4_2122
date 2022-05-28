package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryOrderRepository extends InMemoryDomainRepository<OrderType, OrderID>
        implements OrderRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<OrderType> findAll(){

        return null;
    }

}