package eapli.base.productmanagement.domain;

public class ProductReference {

    private Long reference;

    public ProductReference() {
    }

    public ProductReference(Long reference) {
        this.reference = reference;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "ProductReference{" +
                "reference='" + reference + '\'' +
                '}';
    }
}
