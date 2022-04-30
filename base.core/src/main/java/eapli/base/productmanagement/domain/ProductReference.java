package eapli.base.productmanagement.domain;

public class ProductReference {

    private String reference;

    public ProductReference() {
    }

    public ProductReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "ProductReference{" +
                "reference='" + reference + '\'' +
                '}';
    }
}
