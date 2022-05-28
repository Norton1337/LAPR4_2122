package eapli.base.ordermanagement.application;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class OrderController {

    private OrderType order;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final OrderRepository orderRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().order();
    public OrderController(){}


    public void saveOrder(OrderType order){
        orderRepository.save(order);

    }

    public void saveOrder(List<OrderType> orders){
        for (OrderType order: orders) {
            saveOrder(order);
        }


    }

}