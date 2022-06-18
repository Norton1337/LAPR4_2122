package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.warehouses.domain.aisles.AisleID;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.AisleRepository;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaAisleRepository extends JpaAutoTxRepository<Aisles, AisleID, AisleID>
    implements AisleRepository
{


    public JpaAisleRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "aisleIdentification");
    }

    public JpaAisleRepository(TransactionalContext tx) {
        super(tx, "aisleIdentification");
    }



    @Override
    public List<Aisles> findAll(){

        final TypedQuery<Aisles> query = entityManager().createQuery(
                "SELECT a FROM Aisles a",
                Aisles.class
        );
        return query.getResultList();
    }

    @Override
    public List<Rows> findWithBin(Bin bin) {
        final TypedQuery<Rows> query = entityManager().createQuery(
                "SELECT r FROM Rows r",
                Rows.class
        );
        return query.getResultList();
    }
}
