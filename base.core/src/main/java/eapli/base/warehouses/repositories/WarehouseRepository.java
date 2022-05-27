package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface WarehouseRepository {

    public Warehouse add(Warehouse warehouse);

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public Warehouse findById(Long id);

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    public List<Warehouse> findAll();
}
