package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.warehouses.domain.agvDocks.AgvDockIdentification;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvDockRepository;
import eapli.base.warehouses.repositories.AgvRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaAgvDockRepository extends JpaAutoTxRepository<AgvDocks, AgvDockIdentification, AgvDockIdentification>
        implements AgvDockRepository {

    public JpaAgvDockRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "agvDockIdentification");
    }

    public JpaAgvDockRepository(TransactionalContext tx) {
        super(tx, "agvDockIdentification");
    }

    @Override
    public List<AgvDocks> findAll(){

        final TypedQuery<AgvDocks> query = entityManager().createQuery(
                "SELECT a FROM AgvDocks a",
                AgvDocks.class
        );
        return query.getResultList();
    }

}
