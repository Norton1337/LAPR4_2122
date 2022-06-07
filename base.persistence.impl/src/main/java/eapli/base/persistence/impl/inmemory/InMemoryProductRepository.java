package eapli.base.persistence.impl.inmemory;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBarCode;
import eapli.base.productmanagement.domain.ProductCode;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;


public class InMemoryProductRepository extends InMemoryDomainRepository<Product, ProductBarCode>
        implements ProductRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<Product> findAll(){

        return null;
    }
}
