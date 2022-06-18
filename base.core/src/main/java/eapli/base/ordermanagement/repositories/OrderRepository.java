package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends DomainRepository<OrderID, OrderType> {

    public List<OrderType> findAll();

    public List<OrderType> findWaitingOrders();

    public List<OrderType> findOpenOrders(Username username);

    public List<OrderType> findPreparedOrders();

    public List<OrderType> findOrdersByTime();

    public List<OrderType> findDispatchedOrders();
}
