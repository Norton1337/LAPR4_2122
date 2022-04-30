package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductShortDescription implements ValueObject {

    private String shortDescription;

    public ProductShortDescription() {
    }

    public ProductShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "ProductShortDescription{" +
                "shortDescription='" + shortDescription + '\'' +
                '}';
    }
}
