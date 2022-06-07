package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

public class ProductWeight implements ValueObject {

    private Double weight;

    public ProductWeight() {
    }

    public ProductWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ProductWeight{" +
                "weight='" + weight + '\'' +
                '}';
    }
}
