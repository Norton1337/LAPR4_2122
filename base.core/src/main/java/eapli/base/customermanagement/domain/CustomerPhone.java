package eapli.base.customermanagement.domain;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerPhone implements ValueObject {
    private String phone;

    public CustomerPhone(String phone){
        this.phone=phone;
    }
    public CustomerPhone(){}


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerPhone{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
