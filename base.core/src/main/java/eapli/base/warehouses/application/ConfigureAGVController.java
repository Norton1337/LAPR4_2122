package eapli.base.warehouses.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.base.warehouses.repositories.AgvRepository;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;

public class ConfigureAGVController {

    private AGV agv;
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AgvRepository agvRepository = PersistenceContext.repositories().agv();

    public ConfigureAGVController(){}

    public void configureAGV(AgvDTO dto) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        agv = new AGV(dto);
        agvRepository.save(agv);
    }

    public AGVIdentification getAGVIdentification(AgvDTO dto) throws IOException {
        agv= new AGV(dto);
        return agv.identity();
    }

}
