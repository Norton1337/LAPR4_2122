package eapli.base.productmanagement.domain.product;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductBarCode implements ValueObject, Comparable<ProductBarCode> {

    private String barCode;

    public ProductBarCode() {
    }

    public ProductBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "ProductBarCode{" +
                "barCode='" + barCode + '\'' +
                '}';
    }

    @Override
    public int compareTo(ProductBarCode o) {
        return 0;
    }
}
