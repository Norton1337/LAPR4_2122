package eapli.base.productmanagement.domain.product;

import eapli.framework.domain.model.ValueObject;

public class ProductPrice implements ValueObject {

    private Double price;

    public ProductPrice() {
    }

    public ProductPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price='" + price + '\'' +
                '}';
    }
}
