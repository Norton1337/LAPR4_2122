package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.taskmanagement.application.TaskController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.framework.io.util.Console;

import java.util.List;

public class PreparedOrdersUI {

    private final OrderController orderController = new OrderController();
    private final AGVController agvController = new AGVController();



    public boolean show(){
        System.out.println("");

        List<OrderType> ordersList = orderController.getPreparedOrders();

        if(ordersList.isEmpty()){
            System.out.println("There are no prepared orders");
            return false;
        }
        int i = 0;
        for (OrderType order: ordersList) {
            System.out.println("["+i+"] "+order.toString()+"\n");
            i++;
        }

        System.out.println("Do you wish to dispatch an order?");
        int option3 = Console.readInteger("0-No\n1-Yes\n>");
        if(option3<0 || option3 >= ordersList.size()){
            System.out.println("Invalid option");
            return false;
        }
        if(option3==0)
            return false;


        int option = Console.readInteger("Choose Order");
        if(option<0 || option >= ordersList.size()){
            System.out.println("Order does not exist");
            return false;
        }

        OrderType order = ordersList.get(option);
        order.changeOrderState(PossibleStates.DISPATCHED);
        List<AGV> orderAGV = agvController.getOrderAGV(order);
        if(orderAGV!=null)
            agvController.updateAGV(orderAGV.get(0),null);
        else
            orderController.saveOrder(order);

        return false;

    }


}
