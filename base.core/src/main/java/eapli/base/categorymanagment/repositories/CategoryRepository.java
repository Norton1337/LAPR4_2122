package eapli.base.categorymanagment.repositories;

import eapli.base.categorymanagment.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
