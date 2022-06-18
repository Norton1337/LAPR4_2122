package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.OrderState;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.OrderBy;
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
                "SELECT o FROM OrderType o " +
                        "ORDER BY o.orderWeight.weight ASC",
                OrderType.class
        );
        return query.getResultList();
    }

    @Override
    public List<OrderType> findWaitingOrders() {
        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o WHERE o.orderState=:waiting" +
                        " ORDER BY o.orderWeight.weight ASC",
                OrderType.class
        ).setParameter("waiting",new OrderState(PossibleStates.WAITING));
        return query.getResultList();
    }

    @Override
    public List<OrderType> findOpenOrders(Username username) {
        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o WHERE o.clientUsername = :user" +
                        " AND o.orderState!=:closed" +
                        " ORDER BY o.orderWeight.weight ASC",
                OrderType.class
        )
                .setParameter("user",username)
                .setParameter("closed",new OrderState(PossibleStates.CLOSED))
                ;
        return query.getResultList();
    }
    @Override
    public List<OrderType> findPreparedOrders() {
        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o WHERE o.orderState=:completed" +
                        " ORDER BY o.orderDateTime.dateTime ASC",
                OrderType.class
        )
                .setParameter("completed",new OrderState(PossibleStates.COMPLETED))
                ;
        return query.getResultList();
    }
    @Override
    public List<OrderType> findOrdersByTime() {
        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o WHERE o.orderState=:waiting" +
                        " ORDER BY o.orderDateTime.dateTime ASC",
                OrderType.class
        ).setParameter("waiting",new OrderState(PossibleStates.WAITING));
        return query.getResultList();
    }

    @Override
    public List<OrderType> findDispatchedOrders() {
        final TypedQuery<OrderType> query = entityManager().createQuery(
                "SELECT o FROM OrderType o WHERE o.orderState=:dispatched" +
                        " ORDER BY o.orderDateTime.dateTime ASC",
                OrderType.class
        ).setParameter("dispatched", new OrderState(PossibleStates.DISPATCHED));
        return query.getResultList();


    }
}
