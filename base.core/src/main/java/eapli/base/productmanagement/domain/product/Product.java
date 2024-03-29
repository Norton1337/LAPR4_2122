package eapli.base.productmanagement.domain.product;

import eapli.base.categorymanagment.domain.Category;
import eapli.base.warehouses.domain.rows.Bin;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Product implements AggregateRoot<ProductBarCode> {

    @Id
    @GeneratedValue
    @Column(name = "PRODUCTID")
    private Long internalCode;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_bin_id", referencedColumnName = "BINID")
    private Bin bin;


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

    public void setBin(Bin bin){
        this.bin=bin;
    }

    public Bin getBin(){
        return this.bin;
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

    public Category productCategory(){return this.productCategory;}
    public ProductPrice productPrice(){return this.price;}

    public ProductWeight productWeight(){return this.weight;}

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


