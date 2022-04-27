package eapli.base.customermanagement.domain;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAddress implements ValueObject {
    private String address;

    public CustomerAddress(String address){
        this.address=address;
    }
    public CustomerAddress(){}

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
