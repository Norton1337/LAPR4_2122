package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class ShortDescription implements ValueObject {
    private String description;

    public ShortDescription(String description){
        Preconditions.ensure(description.length()>0 && description.length()<30);
        this.description=description;
    }
    public ShortDescription(){}

    @Override
    public String toString() {
        return "ShortDescription{" +
                "description='" + description + '\'' +
                '}';
    }

    public static ShortDescription valueOf(String description){
        return new ShortDescription(description);
    }
}
