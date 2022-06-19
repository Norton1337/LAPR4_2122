package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.*;
import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class OrderBootstrapper implements Action{

    private final OrderController orderController = new OrderController();
    private final ProductRepository productRepository = PersistenceContext.repositories().product();
    @Override
    public boolean execute() {

        createOrders();
        createPreparedOrders();


        return true;
    }

    private void createOrders() {
        List<OrderType> orderList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();

        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(new OrderItem(productList.get(0),1));
        orderItemList1.add(new OrderItem(productList.get(1),1));
        orderItemList1.add(new OrderItem(productList.get(2),1));
        orderList.add(orderController.createOrderBootstrapp(orderItemList1,"NullBillingAddress1","NullPostalAddress1",null));

        List<OrderItem> orderItemList2 = new ArrayList<>();
        orderItemList2.add(new OrderItem(productList.get(0),2));
        orderItemList2.add(new OrderItem(productList.get(1),2));
        orderItemList2.add(new OrderItem(productList.get(2),2));
        orderList.add(orderController.createOrderBootstrapp(orderItemList2,"NullBillingAddress2","NullPostalAddress2",null));

        List<OrderItem> orderItemList3 = new ArrayList<>();
        orderItemList3.add(new OrderItem(productList.get(2),3));
        orderList.add(orderController.createOrderBootstrapp(orderItemList3,"NullBillingAddress3","NullPostalAddress3",null));

        List<OrderItem> orderItemList4 = new ArrayList<>();
        orderItemList4.add(new OrderItem(productList.get(0),1));
        orderItemList4.add(new OrderItem(productList.get(1),1));
        orderItemList4.add(new OrderItem(productList.get(2),1));
        orderList.add(orderController.createOrderBootstrapp(orderItemList4,"NullBillingAddress4","NullPostalAddress4",null));
        orderController.saveOrder(orderList);
    }

    private void createPreparedOrders() {

        List<OrderType> orderList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();

        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(new OrderItem(productList.get(0),1));
        OrderType order1 = orderController.createOrderBootstrapp(orderItemList1,"NullPreparedBillingAddress1","NullPreparedPostalAddress1",null);
        orderController.markCompleted(order1);
        orderList.add(order1);
        List<OrderItem> orderItemList2 = new ArrayList<>();
        orderItemList2.add(new OrderItem(productList.get(1),2));
        OrderType order2 = orderController.createOrderBootstrapp(orderItemList2,"NullPreparedBillingAddress2","NullPreparedPostalAddress2",null);
        orderController.markCompleted(order2);
        orderList.add(order2);
        orderController.saveOrder(orderList);

    }
}
