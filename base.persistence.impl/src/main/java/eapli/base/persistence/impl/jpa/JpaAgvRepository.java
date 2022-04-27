package eapli.base.persistence.impl.jpa;

import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvRepository;


public class JpaAgvRepository extends BasepaRepositoryBase<AGV, AGVIdentification,AGVIdentification> implements AgvRepository {
    JpaAgvRepository() {
        super("AGVIdentification");
    }
}
