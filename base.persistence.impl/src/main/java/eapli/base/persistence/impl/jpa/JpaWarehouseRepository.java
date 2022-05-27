package eapli.base.persistence.impl.jpa;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;

import javax.persistence.*;
import java.util.List;

public class JpaWarehouseRepository extends BasepaRepositoryBase<Warehouse, WarehouseIdentification, WarehouseIdentification> implements WarehouseRepository {

    JpaWarehouseRepository() {
        super("warehouseAddress");
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("eapli.base");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    @Override
    public Warehouse add(Warehouse warehouse) {
        if (warehouse == null) {
            throw new IllegalArgumentException();
        }
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(warehouse);
        tx.commit();
        em.close();
        System.out.println("TESTTTT");
        return warehouse;
    }

    @Override
    public Warehouse findById(Long id) {

        return getEntityManager().find(Warehouse.class, id);
    }

    //@SuppressWarnings("unchecked")
    @Override
    public List<Warehouse> findAll() {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM Warehouse e");
        List<Warehouse> list = query.getResultList();
        return list;
    }
}
