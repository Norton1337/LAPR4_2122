package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductExtendedDescription implements ValueObject {

    private String extendedDescription;

    public ProductExtendedDescription() {
    }

    public ProductExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    @Override
    public String toString() {
        return "ProductExtendedDescription{" +
                "extendedDescription='" + extendedDescription + '\'' +
                '}';
    }
}
