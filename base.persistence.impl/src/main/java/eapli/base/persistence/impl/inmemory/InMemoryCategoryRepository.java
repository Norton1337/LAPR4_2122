package eapli.base.persistence.impl.inmemory;

import eapli.base.categorymanagment.domain.Category;
import eapli.base.categorymanagment.repositories.CategoryRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBarCode;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;


public class InMemoryCategoryRepository extends InMemoryDomainRepository<Category, String>
        implements CategoryRepository {
    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<Category> findAll(){

        return null;
    }
}
