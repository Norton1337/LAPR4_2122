package eapli.base.ordermanagement.application;

import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.shoppingcart.CartItem;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
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

    public List<OrderType> orderByTime(List<OrderType> list){

        list.sort(new Comparator<OrderType>() {
            public int compare(OrderType o1, OrderType o2) {
                return o1.getOrderDateTime().value().compareTo(o2.getOrderDateTime().value());
            }
        });
        return list;
    }

    public void createOrder(List<CartItem> cartItems, String billingAddress, String postalAddress, SystemUser systemUser){
        List<OrderItem> orderItemList = new ArrayList<>();
        Double totalPrice = 0.0;
        for (CartItem cartItem:cartItems) {
            OrderItem orderItem = new OrderItem(cartItem.product(), cartItem.amount());
            totalPrice+=orderItem.getTotalPrice();
            orderItemList.add(orderItem);
        }
        OrderType newOrder = new OrderType(new OrderID(orderRepository.findAll().size()+1000L),
                new OrderBillingAddress(billingAddress),
                new OrderLocation("warehouse"),
                new OrderTotalAmount(totalPrice),
                new OrderPostalAddress(postalAddress),
                new OrderDateTime(LocalDateTime.now()),
                new OrderState(PossibleStates.WAITING),
                orderItemList
                );
        for (OrderItem orderItem: orderItemList) {
            orderItem.setOrder(newOrder);
        }
        newOrder.setClient(systemUser);
        saveOrder(newOrder);
    }
}