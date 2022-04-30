package eapli.base.productmanagement.repositories;

import eapli.base.productmanagement.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
