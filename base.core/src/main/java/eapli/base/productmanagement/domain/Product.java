package eapli.base.productmanagement.domain;

import eapli.base.categorymanagment.domain.Category;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
    public class Product {

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
        private Category productCategory;

        protected Product(){}


    public Product(int internalCode, ProductCode productCode, ProductBarCode barCode, ProductReference reference,
                   ProductBrandName brandName, ProductPhotos photos, ProductShortDescription shortDescription,
                   ProductTechnicalDescription technicalDescription, ProductExtendedDescription extendedDescription,
                   Category productCategory) {
        this.internalCode = internalCode;
        this.productCode = productCode;
        this.barCode = barCode;
        this.reference = reference;
        this.brandName = brandName;
        this.photos = photos;
        this.shortDescription = shortDescription;
        this.technicalDescription = technicalDescription;
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
}


