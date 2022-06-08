package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagment.domain.Category;
import eapli.base.categorymanagment.repositories.CategoryRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaCategoryRepository extends JpaAutoTxRepository<Category, String, String>
        implements CategoryRepository {

    public JpaCategoryRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "alphanumericCode");
    }

    public JpaCategoryRepository(TransactionalContext tx) {
        super(tx, "alphanumericCode");
    }

    @Override
    public List<Category> findAll(){

        final TypedQuery<Category> query = entityManager().createQuery(
                "SELECT c FROM Category c",
                Category.class
        );
        return query.getResultList();
    }

}
