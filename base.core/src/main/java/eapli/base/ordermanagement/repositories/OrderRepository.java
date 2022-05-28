package eapli.base.ordermanagement.repositories;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface OrderRepository extends DomainRepository<OrderID, OrderType> {

    public List<OrderType> findAll();
}
