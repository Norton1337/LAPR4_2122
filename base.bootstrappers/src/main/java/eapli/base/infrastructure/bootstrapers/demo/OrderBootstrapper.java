package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.*;
import eapli.framework.actions.Action;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderBootstrapper implements Action{

    private final OrderController orderController = new OrderController();

    @Override
    public boolean execute() {

        List<OrderType> orderList =createOrders();
        orderController.saveOrder(orderList);


        return true;
    }

    private List<OrderType> createOrders() {
        List<OrderType> orderList = new ArrayList<>();
        OrderType order1 = new OrderBuilder()
                        .ofID(new OrderID(1000L))
                        .ofBillingAddress(new OrderBillingAddress("BillingAddress1"))
                        .ofLocation(new OrderLocation("Location1"))
                        .ofTotalAmount(new OrderTotalAmount(12.34))
                        .ofPostalAddress(new OrderPostalAddress("PostalAddress1"))
                        .ofDateTime(new OrderDateTime(LocalDateTime.now()))
                        .ofState(new OrderState(PossibleStates.WAITING))
                        .build();
        OrderType order2 = new OrderBuilder()
                        .ofID(new OrderID(1001L))
                        .ofBillingAddress(new OrderBillingAddress("BillingAddress2"))
                        .ofLocation(new OrderLocation("Location2"))
                        .ofTotalAmount(new OrderTotalAmount(12.34))
                        .ofPostalAddress(new OrderPostalAddress("PostalAddress2"))
                        .ofDateTime(new OrderDateTime(LocalDateTime.now()))
                        .ofState(new OrderState(PossibleStates.WAITING))
                        .build();
        OrderType order3 = new OrderBuilder()
                        .ofID(new OrderID(1002L))
                        .ofBillingAddress(new OrderBillingAddress("BillingAddress3"))
                        .ofLocation(new OrderLocation("Location3"))
                        .ofTotalAmount(new OrderTotalAmount(12.34))
                        .ofPostalAddress(new OrderPostalAddress("PostalAddress3"))
                        .ofDateTime(new OrderDateTime(LocalDateTime.now()))
                        .ofState(new OrderState(PossibleStates.WAITING))
                        .build();
        OrderType order4 = new OrderBuilder()
                        .ofID(new OrderID(1003L))
                        .ofBillingAddress(new OrderBillingAddress("BillingAddress4"))
                        .ofLocation(new OrderLocation("Location4"))
                        .ofTotalAmount(new OrderTotalAmount(12.34))
                        .ofPostalAddress(new OrderPostalAddress("PostalAddress4"))
                        .ofDateTime(new OrderDateTime(LocalDateTime.now()))
                        .ofState(new OrderState(PossibleStates.WAITING))
                        .build();

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);

        return orderList;
    }
}
