package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaOrderRepository extends JpaAutoTxRepository<Order, OrderID, OrderID>
    implements OrderRepository
{


    public JpaOrderRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "orderID");
    }

    public JpaOrderRepository(TransactionalContext tx) {
        super(tx, "orderID");
    }

    @Override
    public List<Order> findAll(){

        final TypedQuery<Order> query = entityManager().createQuery(
                "SELECT o FROM Order o",
                Order.class
        );
        return query.getResultList();
    }
}
