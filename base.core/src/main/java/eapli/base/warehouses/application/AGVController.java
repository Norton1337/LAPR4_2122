package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.base.warehouses.repositories.AgvRepository;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class AGVController {

    private AGV agv;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AgvRepository agvRepository = PersistenceContext.repositories().agv();
    private final WarehouseService warehouseService = new WarehouseService();
    public AGVController(){}

    public void configureAGV(List<AgvDTO> agvDTOList) {
        for (AgvDTO agvDto: agvDTOList) {
            configureAGV(agvDto);
        }

    }
    public void configureAGV(AgvDTO agvDTO) {
            agv = new AGV(agvDTO);
            agvRepository.save(agv);
    }

    public AGVIdentification getAGVIdentification(AgvDTO dto) throws IOException {
        agv= new AGV(dto);
        return agv.identity();
    }

    public Set<AgvDocks> getAGVDocks(){
        return warehouseService.getAllAgvDocks();
    }

}
