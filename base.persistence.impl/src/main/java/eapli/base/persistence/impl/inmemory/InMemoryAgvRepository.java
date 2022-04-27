package eapli.base.persistence.impl.inmemory;

import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.base.warehouses.repositories.AgvRepository;

import java.util.Optional;


public class InMemoryAgvRepository implements AgvRepository {
    @Override
    public <S extends AGV> S save(S entity) {
        return null;
    }

    @Override
    public Iterable<AGV> findAll() {
        return null;
    }

    @Override
    public Optional<AGV> ofIdentity(AGVIdentification id) {
        return Optional.empty();
    }

    @Override
    public void delete(AGV entity) {

    }

    @Override
    public void deleteOfIdentity(AGVIdentification entityId) {

    }

    @Override
    public long count() {
        return 0;
    }
}
