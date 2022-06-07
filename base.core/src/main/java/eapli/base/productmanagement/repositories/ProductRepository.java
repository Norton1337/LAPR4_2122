package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBarCode;
import eapli.base.productmanagement.domain.ProductCode;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends DomainRepository<ProductBarCode, Product> {
    public List<Product> findAll();
}
