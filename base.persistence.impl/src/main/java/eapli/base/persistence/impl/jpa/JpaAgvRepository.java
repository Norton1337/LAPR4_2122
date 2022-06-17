package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaAgvRepository extends JpaAutoTxRepository<AGV, AGVIdentification, AGVIdentification>
        implements AgvRepository {

    public JpaAgvRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "identification");
    }

    public JpaAgvRepository(TransactionalContext tx) {
        super(tx, "identification");
    }

    @Override
    public List<AGV> findAll(){

        final TypedQuery<AGV> query = entityManager().createQuery(
                "SELECT a FROM AGV a " +
                        "ORDER BY a.maxWeight.weight ASC",
                AGV.class
        );
        return query.getResultList();
    }

    @Override
    public List<AGV> findAllAvailable() {
        final TypedQuery<AGV> query = entityManager().createQuery(
                "SELECT a FROM AGV a WHERE a.task IS NULL" +
                        " ORDER BY a.maxWeight.weight ASC",
                AGV.class
        );
        return query.getResultList();
    }

    @Override
    public List<AGV> findAllAvailableOfWeight(Double weight) {
        final TypedQuery<AGV> query = entityManager().createQuery(
                "SELECT a FROM AGV a WHERE a.task IS NULL" +
                        " AND (a.maxWeight.weight>=:weight)" +
                        " ORDER BY a.maxWeight.weight ASC",
                AGV.class
        ).setParameter("weight",weight);
        return query.getResultList();
    }

    @Override
    public List<AGV> findBestAvailableForWeight(Double weight) {
        final TypedQuery<AGV> query = entityManager().createQuery(
                "SELECT DISTINCT a FROM AGV a WHERE a.task IS NULL" +
                        " AND (a.maxWeight.weight>=:weight)" +
                        " ORDER BY a.maxWeight.weight ASC",
                AGV.class
        ).setParameter("weight",weight);
        return query.getResultList();
    }

}
