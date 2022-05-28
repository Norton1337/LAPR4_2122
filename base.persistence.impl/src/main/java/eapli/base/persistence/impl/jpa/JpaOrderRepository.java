package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaOrderRepository extends JpaAutoTxRepository<OrderType, OrderID, OrderID>
    implements OrderRepository
{


    public JpaOrderRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "orderID");
    }

    public JpaOrderRepository(TransactionalContext tx) {
        super(tx, "orderID");
    }

    @Override
    public List<OrderType> findAll(){

        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o",
                OrderType.class
        );
        return query.getResultList();
    }
}
