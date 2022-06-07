package eapli.base.productmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;


public class ProductController {

    private final ProductRepository productRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().product();

    public ProductController(){}

    public void specifyProduct(String productCode, String barCode, String reference, String brandName,
                               String shortDescription, String technicalDescription, String extendedDescription){

    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void createProduct(List<Product> products){
        for (Product product:products) {
            createProduct(product);
        }
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getAllProducts(String string){
        List<Product> products = productRepository.findAll();
        List<Product> newProductList = new ArrayList<>();
        for (Product product: products) {
            if(product.productCode().getProductCode().toLowerCase().contains(string.toLowerCase())){
                newProductList.add(product);
            }
        }
        return newProductList;
    }
}
