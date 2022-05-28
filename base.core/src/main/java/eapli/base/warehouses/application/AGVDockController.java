package eapli.base.warehouses.application;


import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.repositories.AgvDockRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


import java.util.List;

public class AGVDockController {
    private AgvDocks agvDocks;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AgvDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();
    public AGVDockController(){}

    public void configureAgvDock(List<AgvDocks> agvDocks) {
        for (AgvDocks agvDock: agvDocks) {
            configureAGVDock(agvDock);
        }

    }
    public void configureAGVDock(AgvDocks agvDock) {
        agvDockRepository.save(agvDock);
    }
    public void configureAGVDock(List<AgvDocks> agvDocks) {
        for (AgvDocks agvDock: agvDocks) {
            configureAGVDock(agvDock);
        }

    }


    public List<AgvDocks> getAGVDocks(){
        return agvDockRepository.findAll();
    }



}
