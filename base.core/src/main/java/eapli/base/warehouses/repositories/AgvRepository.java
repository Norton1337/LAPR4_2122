package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.framework.domain.repositories.DomainRepository;

public interface AgvRepository extends DomainRepository<AGVIdentification, AGV> {
}
