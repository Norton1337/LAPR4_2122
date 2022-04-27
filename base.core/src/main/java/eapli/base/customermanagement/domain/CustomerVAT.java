package eapli.base.customermanagement.domain;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerVAT implements ValueObject {
    private String vat;

    public CustomerVAT(String vat){
        this.vat=vat;
    }
    public CustomerVAT(){}


    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    @Override
    public String toString() {
        return "CustomerVAT{" +
                "vat='" + vat + '\'' +
                '}';
    }
}