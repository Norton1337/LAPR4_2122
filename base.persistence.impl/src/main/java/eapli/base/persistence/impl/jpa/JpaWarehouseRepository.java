package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class JpaWarehouseRepository extends JpaAutoTxRepository<Warehouse, WarehouseIdentification, WarehouseIdentification>
    implements WarehouseRepository
{


    public JpaWarehouseRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "warehouse");
    }

    public JpaWarehouseRepository(TransactionalContext tx) {
        super(tx, "warehouse");
    }

    @Override
    public List<Warehouse> findAll(){

        final TypedQuery<Warehouse> query = entityManager().createQuery(
                "SELECT w FROM Warehouse w",
                Warehouse.class
        );
        return query.getResultList();
    }
}
