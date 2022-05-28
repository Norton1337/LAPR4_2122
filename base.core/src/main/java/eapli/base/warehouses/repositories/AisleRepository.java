package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.aisles.AisleID;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AisleRepository extends DomainRepository<AisleID, Aisles> {

    public Aisles add(Aisles aisle);

    /**
     * reads an entity given its ID
     *
     * @param id
     * @return
     */
    public Aisles findById(Long id);

    /**
     * Returns the List of all entities in the persistence store
     *
     * @return
     */
    public List<Aisles> findAll();
}
