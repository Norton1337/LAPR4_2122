package eapli.base.ordermanagement.application;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private OrderType order;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final OrderRepository orderRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().order();

    public OrderController() {
    }

    public void assignTask(OrderType order, Task task){
        order.setTask(task);
        order.changeOrderState(PossibleStates.IN_PROGRESS);
    }
    public void saveOrder(OrderType order) {
        orderRepository.save(order);

    }

    public void saveOrder(List<OrderType> orders) {
        for (OrderType order : orders) {
            saveOrder(order);
        }
    }

    public List<OrderType> getWaitingOrders() {
        List<OrderType> waitingOrderTypeList = new ArrayList<>();
        List<OrderType> allOrderTypeList = orderRepository.findAll();
        for (OrderType order : allOrderTypeList) {
            if (order.getOrderState().value() == PossibleStates.WAITING)
                waitingOrderTypeList.add(order);
        }
        return waitingOrderTypeList;


    }
}