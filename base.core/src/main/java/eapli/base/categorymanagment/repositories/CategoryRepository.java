package eapli.base.categorymanagment.repositories;

import eapli.base.categorymanagment.domain.Category;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBarCode;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.domain.repositories.DomainRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends DomainRepository<String, Category> {
    public List<Category> findAll();
}
