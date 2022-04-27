package eapli.base.customermanagement.domain;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerName implements ValueObject {
    private String name;

    public CustomerName(String address){
        this.name=name;
    }
    public CustomerName(){}


    @Override
    public String toString() {
        return "CustomerName{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
