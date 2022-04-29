package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.base.warehouses.repositories.WarehouseRepository;

import java.util.Optional;

public class InMemoryWarehouseRepository implements WarehouseRepository {
    @Override
    public <S extends Warehouse> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<Warehouse> findAll() {
        return null;
    }

    @Override
    public Optional<Warehouse> ofIdentity(WarehouseIdentification id) {
        return Optional.empty();
    }

    @Override
    public void delete(Warehouse entity) {

    }

    @Override
    public void deleteOfIdentity(WarehouseIdentification entityId) {

    }

    @Override
    public long count() {
        return 0;
    }
}
