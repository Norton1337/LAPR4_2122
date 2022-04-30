package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductBrandName implements ValueObject {

    private String brandName;

    public ProductBrandName() {
    }

    public ProductBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "ProductBrandName{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}
