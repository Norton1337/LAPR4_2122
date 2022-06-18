package eapli.base.warehouses.repositories;

import eapli.base.warehouses.domain.aisles.AisleID;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.rows.BinID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface BinRepository extends DomainRepository<BinID, Bin> {


    public List<Bin> findAll();
}
