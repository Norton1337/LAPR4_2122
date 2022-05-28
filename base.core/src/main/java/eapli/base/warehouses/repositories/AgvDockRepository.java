package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AgvDockRepository extends DomainRepository<AgvDockIdentification, AgvDocks> {
    public List<AgvDocks> findAll();
}
