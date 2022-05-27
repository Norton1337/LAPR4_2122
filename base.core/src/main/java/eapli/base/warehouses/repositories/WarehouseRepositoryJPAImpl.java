package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.warehouse.Warehouse;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

public class WarehouseRepositoryJPAImpl implements WarehouseRepository{

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
