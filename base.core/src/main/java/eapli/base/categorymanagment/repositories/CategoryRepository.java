package eapli.base.categorymanagment.repositories;

import eapli.base.categorymanagment.domain.Category;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface CategoryRepository extends DomainRepository<String, Category> {
    public List<Category> findAll();
}
