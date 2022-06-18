package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.categorymanagment.application.CategoryController;
import eapli.base.categorymanagment.domain.Category;
import eapli.base.categorymanagment.domain.CategoryDescription;
import eapli.base.productmanagement.application.ProductController;
import eapli.base.productmanagement.domain.product.*;
import eapli.base.warehouses.application.WarehouseSetupController;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.framework.actions.Action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class ProductBootstrapper implements Action {

    private final ProductController productController = new ProductController();
    private final WarehouseSetupController warehouseSetupController = new WarehouseSetupController();
    private final CategoryController categoryController = new CategoryController();

    @Override
    public boolean execute() {

        List<Category> categories = createCategories();
        categoryController.defineCategory(categories);
        List<Product> products = createProducts(categories);

        productController.createProduct(products);


        return true;
    }

    private List<Category> createCategories(){
        List<Category> categories = new ArrayList<>();
        Category category1 = new Category("Television",new CategoryDescription("Television"));
        Category category2 = new Category("Washing Machine",new CategoryDescription("Washing Machine"));
        Category category3 = new Category("Gaming Console",new CategoryDescription("Gaming Console"));

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        return categories;
    }
    private List<Product> createProducts(List<Category> categories) {
        List<Product> productList = new ArrayList<>();

        List<Bin> bins = warehouseSetupController.getBins();


        Product product1 = new Product(
                new ProductCode("TV LG OLED48C16LA"),
                new ProductBarCode("3498949197"),
                new ProductReference(7385086L),
                new ProductWeight(18.9),
                new ProductBrandName("LG"),
                new ProductPhotos(),
                new ProductShortDescription("OLED - 48'' - 122 cm - 4K Ultra HD - Smart TV"),
                new ProductTechnicalDescription("Descrição muito tecnica sobre TV LG OLED"),
                new ProductExtendedDescription("Descrição muito extensa sobre TV LG OLED"),
                new ProductPrice(899.99),
                categories.get(0)

        );
        product1.setBin(bins.get(0));
        bins.get(0).setProduct(product1);
        Product product2 = new Product(
                new ProductCode("SAMSUNG WD90T734DBH/S3"),
                new ProductBarCode("0603523154"),
                new ProductReference(7308012L),
                new ProductWeight(68.0),
                new ProductBrandName("SAMSUNG"),
                new ProductPhotos(),
                new ProductShortDescription("Máquina de Lavar e Secar Roupa"),
                new ProductTechnicalDescription("Descrição muito tecnica sobre Máquina de Lavar e Secar Roupa SAMSUNG"),
                new ProductExtendedDescription("Descrição muito extensa sobre Máquina de Lavar e Secar Roupa SAMSUNG"),
                new ProductPrice(859.99),
                categories.get(1)

        );
        product2.setBin(bins.get(1));
        bins.get(1).setProduct(product2);
        Product product3 = new Product(
                new ProductCode("Consola PS5(825GB)"),
                new ProductBarCode("8477934774"),
                new ProductReference(7196053L),
                new ProductWeight(4.5),
                new ProductBrandName("SONY PLAYSTATION"),
                new ProductPhotos(),
                new ProductShortDescription("Consola PS5 com 825GB"),
                new ProductTechnicalDescription("Descrição muito tecnica sobre PS5"),
                new ProductExtendedDescription("Descrição muito extensa sobre PS5"),
                new ProductPrice(499.99),
                categories.get(2)

        );
        product3.setBin(bins.get(2));
        bins.get(2).setProduct(product3);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);


        return productList;
    }
}
