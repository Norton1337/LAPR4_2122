package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.application.TaskController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.repositories.AgvRepository;
import eapli.base.warehouses.repositories.WarehouseRepository;
import org.springframework.util.RouteMatcher;

import java.util.ArrayList;
import java.util.List;

public class AGVMovementController {

    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final AgvRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository = PersistenceContext.repositories().order();
    private final TaskRepository taskRepository = PersistenceContext.repositories().task();

    private final AGVController agvController = new AGVController();
    private final OrderController orderController = new OrderController();
    private final TaskController taskController = new TaskController();
    private final RouteService routeService= new RouteService();

    public void run(){
        System.out.println("starting automations");
        List<OrderType> orderList = orderRepository.findAll();
        Warehouse warehouse = warehouseRepository.findAll().get(0);
        assignTasks();
        List<AGV> agvList=new ArrayList<>();
        for (OrderType order:orderList) {
            List<AGV> newAGV = agvController.getOrderAGV(order);
            if(newAGV!=null)
                agvList.add(newAGV.get(0));
        }
        for (AGV agv:agvList) {
            routeService.running(agv,warehouse);
        }
    }

    private void assignTasks(){
        List<OrderType> ordersByTimeList = orderController.ordersByTime();
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
    }


}
