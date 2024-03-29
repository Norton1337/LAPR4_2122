package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.taskmanagement.application.TaskController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskDateTime;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.io.util.Console;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class OrdersUI {

    private final OrderController orderController = new OrderController();
    private final AGVController agvController = new AGVController();
    private final TaskController taskController = new TaskController();


    public boolean show(){
        System.out.println("");

        List<OrderType> ordersList = orderController.getWaitingOrders();

        if(ordersList.isEmpty()){
            System.out.println("There are no waiting orders");
            return false;
        }
        int i = 0;
        for (OrderType order: ordersList) {
            System.out.println("["+i+"] "+order.toString()+"\n");
            i++;
        }

        System.out.println("Do you wish to force an order?");
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


        List<AGV> agvList = agvController.getAvailableAGVList(order.getOrderWeight().value());

        if(agvList.isEmpty()){
            System.out.println("There are no available AGVs for this order");
            return false;
        }

        i = 0;
        for (AGV agv: agvList) {
            System.out.println("["+i+"] "+agv.toString()+"\n");
            i++;
        }


        int option2 = Console.readInteger("Choose an AGV");
        if(option2<0 || option2 >= agvList.size()){
            System.out.println("AGV não existe");
            return false;
        }

        AGV agv = agvList.get(option2);

        Task task = taskController.createTask(order);


        orderController.assignTask(order,task);


        agvController.updateAGV(agv,task);

        return false;

    }


}
