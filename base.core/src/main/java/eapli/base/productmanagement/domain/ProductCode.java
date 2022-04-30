package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ProductCode implements ValueObject {

    private int productCode;

    public ProductCode() {
    }

    public ProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    @Override
    public String toString() {
        return "ProductCode{" +
                "productCode=" + productCode +
                '}';
    }
}
