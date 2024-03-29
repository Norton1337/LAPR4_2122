package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;
import java.util.Optional;


public class InMemoryAgvRepository extends InMemoryDomainRepository<AGV, AGVIdentification>
        implements AgvRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<AGV> findAll(){

        return null;
    }

    @Override
    public List<AGV> findAllAvailable() {
        return null;
    }

    @Override
    public List<AGV> findAllAvailableOfWeight(Double weight) {
        return null;
    }

    @Override
    public List<AGV> findBestAvailableForWeight(Double weight) {
        return null;
    }

    @Override
    public List<AGV> findOrderAGV(Task task) {
        return null;
    }
}
