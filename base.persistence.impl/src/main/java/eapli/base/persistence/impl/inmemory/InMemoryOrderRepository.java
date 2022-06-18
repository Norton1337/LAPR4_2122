package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
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

    @Override
    public List<OrderType> findWaitingOrders() {
        return null;
    }

    @Override
    public List<OrderType> findOpenOrders(Username username) {
        return null;
    }

    @Override
    public List<OrderType> findPreparedOrders() {
        return null;
    }

    @Override
    public List<OrderType> findOrdersByTime() {
        return null;
    }

    @Override
    public List<OrderType> findDispatchedOrders() {
        return null;
    }
}
