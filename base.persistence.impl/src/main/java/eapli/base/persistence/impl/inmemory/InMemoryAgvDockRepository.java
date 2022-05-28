package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvDockRepository;
import eapli.base.warehouses.repositories.AgvRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;


public class InMemoryAgvDockRepository extends InMemoryDomainRepository<AgvDocks, AgvDockIdentification>
        implements AgvDockRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<AgvDocks> findAll(){

        return null;
    }
}
