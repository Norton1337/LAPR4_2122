package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.base.warehouses.repositories.AgvRepository;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AGVController {

    private AGV agv;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AgvRepository agvRepository = PersistenceContext.repositories().agv();
    private final TaskRepository taskRepository = PersistenceContext.repositories().task();

    private final WarehouseService warehouseService = new WarehouseService();
    public AGVController(){}

    public void configureAGV(List<AGV> agvList) {
        for (AGV agv: agvList) {
            configureAGV(agv);
        }

    }
    public void configureAGV(AGV agv) {
        agvRepository.save(agv);
    }

    public void assignTask(AGV agv, Task task){
        agv.setTask(task);
    }

    public AGVIdentification getAGVIdentification(AgvDTO dto) throws IOException {
        agv= new AGV(dto);
        return agv.identity();
    }

    public List<AGV> getAGVList(){
        return agvRepository.findAll();
    }

    public List<AGV> getAvailableAGVList(){
        return agvRepository.findAllAvailable();
    }
    public List<AGV> getOrderAGV(OrderType orderType){
        List<Task> tasks = taskRepository.findOrderAGV(orderType);
        if(tasks.isEmpty())
            return null;
        return agvRepository.findOrderAGV(tasks.get(0));
    }
    public List<AGV> getAvailableAGVList(Double weight){
        return agvRepository.findAllAvailableOfWeight(weight);
    }
    public AGV getBestAvailableAGV(Double weight){
        List<AGV> agvList = agvRepository.findBestAvailableForWeight(weight);
        if(agvList.isEmpty())
            return null;
        return agvList.get(0);
    }

    public AGV updateAGV(AGV agv, Task task){
        agv.setTask(task);
        agvRepository.save(agv);
        return agv;
    }

    public void configureAGVDTO(AgvDTO agvDTO) {
    }
}
