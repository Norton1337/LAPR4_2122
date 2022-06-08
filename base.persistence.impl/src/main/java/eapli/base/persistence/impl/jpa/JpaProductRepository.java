package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.product.ProductBarCode;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;


public class JpaProductRepository extends JpaAutoTxRepository<Product, ProductBarCode, ProductBarCode>
        implements ProductRepository {

    public JpaProductRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "productBarCode");
    }

    public JpaProductRepository(TransactionalContext tx) {
        super(tx, "productBarCode");
    }

    @Override
    public List<Product> findAll(){

        final TypedQuery<Product> query = entityManager().createQuery(
                "SELECT p FROM Product p",
                Product.class
        );
        return query.getResultList();
    }

}
