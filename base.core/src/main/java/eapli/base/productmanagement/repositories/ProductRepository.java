package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.product.ProductBarCode;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ProductRepository extends DomainRepository<ProductBarCode, Product> {
    public List<Product> findAll();
}
