package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.aisles.AisleID;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface AisleRepository extends DomainRepository<AisleID, Aisles> {

    public List<Aisles> findAll();

    public List<Rows> findWithBin(Bin bin);
}
