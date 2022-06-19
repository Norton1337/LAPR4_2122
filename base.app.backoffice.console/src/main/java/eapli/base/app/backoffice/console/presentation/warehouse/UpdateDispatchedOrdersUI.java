package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.framework.io.util.Console;


import java.util.ArrayList;
import java.util.List;

public class UpdateDispatchedOrdersUI {

    private final OrderController orderController = new OrderController();


    public boolean show(){
        System.out.println("------");


        List<OrderType> dispatchedOrdersList = orderController.getDispatchedOrders();
        List<OrderType> updatedOrders = new ArrayList<>();

        if (dispatchedOrdersList.isEmpty()){
            System.out.println("There are no dispatched orders");
            return false;
        }

        System.out.println("Would you like to change order status to 'being delivered' ?");

        int option = Console.readInteger("0-No\n1-Yes\n>");
        if(option != 1){
            System.out.println("Invalid option");
            return false;
        }

        int i =0;
        boolean flag = true;
        while (flag){
            for (OrderType order : dispatchedOrdersList){

                System.out.println("["+i+"] "+order.toString());
                i++;
            }
            System.out.println("Choose order you would like to update");
            int orderToUp = Console.readInteger("-->");
            OrderType orderToUpdate = dispatchedOrdersList.get(orderToUp);
            if (!updatedOrders.contains(orderToUpdate)){

                orderController.updateOrderToBeingDelivered(orderToUpdate);
                updatedOrders.add(orderToUpdate);
            }
            else {
                System.out.println("Order already updated");
            }
            System.out.println("Would you like to update more orders?");
            int upd = Console.readInteger("0-No\n1-Yes\n>");
            if (upd == 0){
                flag = false;
            }

        }

        return false;
    }
}
