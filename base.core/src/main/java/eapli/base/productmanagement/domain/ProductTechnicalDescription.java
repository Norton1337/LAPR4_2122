package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductTechnicalDescription implements ValueObject {

    private String technicalDescription;

    public ProductTechnicalDescription() {
    }

    public ProductTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    public String getTechnicalDescription() {
        return technicalDescription;
    }

    public void setTechnicalDescription(String technicalDescription) {
        this.technicalDescription = technicalDescription;
    }

    @Override
    public String toString() {
        return "ProductTechnicalDescription{" +
                "technicalDescription='" + technicalDescription + '\'' +
                '}';
    }
}
