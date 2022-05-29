package eapli.base.app.backoffice.console.presentation.warehouse;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.taskmanagement.application.TaskController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskDateTime;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.warehouses.application.AGVController;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.framework.io.util.Console;

import java.time.LocalDateTime;
import java.util.List;

public class AGVManagementUI {

    private OrderController orderController = new OrderController();
    private AGVController agvController = new AGVController();
    private TaskController taskController = new TaskController();


    public boolean show(){
        System.out.println("");

        List<OrderType> ordersByTime = orderController.getWaitingOrders();
        List<OrderType> ordersList = orderController.orderByTime(ordersByTime);

        if(ordersList.isEmpty()){
            System.out.println("There are no waiting orders");
            return false;
        }
        int i = 0;
        for (OrderType order: ordersList) {
            System.out.println("["+i+"] "+order.toString());
            i++;
        }

        System.out.println("Would you like to assign tasks automatically?");
        int option3 = Console.readInteger("0-No\n1-Yes\n>");
        if(option3<0 || option3 >= ordersList.size()){
            System.out.println("Invalid option");
            return false;
        }
        if(option3==0)
            return false;

        List<AGV> agvList = agvController.getAvailableAGVList();

        if(agvList.isEmpty()){
            System.out.println("There are no available AGVs");
            return false;
        }

        int j = 0;
        while (!ordersList.isEmpty()){

            if (!agvList.isEmpty()){

                AGV agv = agvList.get(j);
                OrderType order = ordersList.get(j);
                Task task = taskController.createTask(order);
                orderController.assignTask(order, task);
                j++;

            }
            else {
                System.out.println("No more AGVs available");
            }
        }

        return false;


    }


}
