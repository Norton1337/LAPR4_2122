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
import org.hibernate.criterion.Order;

import java.time.LocalDateTime;
import java.util.List;

public class AGVManagementUI {

    private final OrderController orderController = new OrderController();
    private final AGVController agvController = new AGVController();
    private TaskController taskController = new TaskController();


    public boolean show(){
        System.out.println("");

        List<OrderType> ordersByTimeList = orderController.ordersByTime();

        if(ordersByTimeList.isEmpty()){
            System.out.println("There are no waiting orders");
            return false;
        }
        int i = 0;
        for (OrderType order: ordersByTimeList) {
            System.out.println("["+i+"] "+order.toString());
            i++;
        }

        System.out.println("Would you like to assign tasks to available AGVs?");
        int option3 = Console.readInteger("0-No\n1-Yes\n>");
        if(option3<0 || option3 > 1){
            System.out.println("Invalid option");
            return false;
        }
        if(option3==0)
            return false;

        int j=0;
        for (OrderType order:ordersByTimeList){
            AGV agv = agvController.getBestAvailableAGV(order.getOrderWeight().value());

            if (agv!=null){

                OrderType orderType = ordersByTimeList.get(j);
                Task task = taskController.createTask(order);
                orderController.assignTask(order, task);
                agvController.updateAGV(agv,task);


            }
            else {
                System.out.println("There is no available AGV for order ["+order.identity().value()+"].");
            }

            j++;
        }

        return false;


    }


}
