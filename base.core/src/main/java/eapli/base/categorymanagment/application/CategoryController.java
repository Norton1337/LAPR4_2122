package eapli.base.categorymanagment.application;

import eapli.base.categorymanagment.domain.Category;
import eapli.base.categorymanagment.repositories.CategoryRepository;

import java.util.List;

public class CategoryController {


    private final CategoryRepository categoryRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().category();
    public void defineCategory(Category category){
        categoryRepository.save(category);
    }
    public void defineCategory(List<Category> categories){
        for (Category category: categories) {
            defineCategory(category);
        }
    }
}
