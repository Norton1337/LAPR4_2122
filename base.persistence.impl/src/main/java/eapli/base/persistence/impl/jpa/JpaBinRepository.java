package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.rows.BinID;
import eapli.base.warehouses.repositories.BinRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaBinRepository extends JpaAutoTxRepository<Bin, BinID, BinID>
    implements BinRepository
{


    public JpaBinRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "binID");
    }

    public JpaBinRepository(TransactionalContext tx) {
        super(tx, "binID");
    }

    @Override
    public List<Bin> findAll(){

        final TypedQuery<Bin> query = entityManager().createQuery(
                "SELECT b FROM Bin b",
                Bin.class
        );
        return query.getResultList();
    }


}
