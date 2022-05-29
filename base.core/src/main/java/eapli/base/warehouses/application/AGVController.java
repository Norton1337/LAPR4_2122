package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.Task;
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
        List<AGV> agvList = getAGVList();
        List<AGV> availableAgvList = new ArrayList<>();

        for (AGV agv: agvList) {
            if(agv.getTask()==null)
                availableAgvList.add(agv);
        }

        return availableAgvList;
    }

    public AGV updateAGV(AGV agv, Task task){
        agv.setTask(task);
        agvRepository.save(agv);
        return agv;
    }

    public void configureAGVDTO(AgvDTO agvDTO) {
    }
}
