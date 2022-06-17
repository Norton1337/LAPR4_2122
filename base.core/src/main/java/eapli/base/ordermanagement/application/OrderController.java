package eapli.base.ordermanagement.application;

import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.shoppingcart.CartItem;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.hibernate.criterion.Order;

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
        return orderRepository.findWaitingOrders();

    }

    public List<OrderType> getClientOpenOrders(Username username) {
        return orderRepository.findOpenOrders(username);
    }

    public List<OrderType> ordersByTime(){

       return orderRepository.findOrdersByTime();
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