package eapli.base.warehouses.repositories;

import eapli.base.taskmanagement.domain.Task;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AgvRepository extends DomainRepository<AGVIdentification, AGV> {
    public List<AGV> findAll();

    public List<AGV> findAllAvailable();

    public List<AGV> findAllAvailableOfWeight(Double weight);

    public List<AGV> findBestAvailableForWeight(Double weight);

    public List<AGV> findOrderAGV(Task task);
}
