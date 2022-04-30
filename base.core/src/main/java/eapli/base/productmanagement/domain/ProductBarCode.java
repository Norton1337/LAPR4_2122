package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductBarCode implements ValueObject {

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
}
