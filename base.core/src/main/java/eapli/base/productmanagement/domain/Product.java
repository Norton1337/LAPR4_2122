package eapli.base.productmanagement.domain;

import eapli.base.categorymanagment.domain.Category;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Product implements AggregateRoot<ProductBarCode> {

    @Id
    @GeneratedValue
    private int internalCode;

    @Embedded
    private ProductCode productCode;

    @Embedded
    private ProductBarCode barCode;

    @Embedded
    private ProductReference reference;

    @Embedded
    private ProductWeight weight;

    @Embedded
    private ProductBrandName brandName;

    @Embedded
    private ProductPhotos photos;

    @Embedded
    private ProductShortDescription shortDescription;

    @Embedded
    private ProductTechnicalDescription technicalDescription;

    @Embedded
    private ProductExtendedDescription extendedDescription;


    @Embedded
    private ProductPrice price;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "CATEGORYID")
    private Category productCategory;


    protected Product(){}


    public Product(ProductCode productCode, ProductBarCode barCode, ProductReference reference, ProductWeight weight,
                   ProductBrandName brandName, ProductPhotos photos, ProductShortDescription shortDescription,
                   ProductTechnicalDescription technicalDescription, ProductExtendedDescription extendedDescription,
                   ProductPrice price, Category productCategory) {

        this.productCode = productCode;
        this.barCode = barCode;
        this.reference = reference;
        this.weight = weight;
        this.brandName = brandName;
        this.photos = photos;
        this.shortDescription = shortDescription;
        this.technicalDescription = technicalDescription;
        this.price = price;
        this.extendedDescription = extendedDescription;
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "internalCode=" + internalCode +
                ", productCode=" + productCode +
                ", barCode=" + barCode +
                ", reference=" + reference +
                ", brandName=" + brandName +
                ", photos=" + photos +
                ", shortDescription=" + shortDescription +
                ", technicalDescription=" + technicalDescription +
                ", extendedDescription=" + extendedDescription +
                ", productCategory=" + productCategory +
                '}';
    }

    public ProductCode productCode(){return this.productCode;}

    @Override
    public boolean equals(Object other) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ProductBarCode identity() {
        return null;
    }
}


