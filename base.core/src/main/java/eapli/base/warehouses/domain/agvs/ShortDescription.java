package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ShortDescription implements ValueObject {
    private String description;

    public ShortDescription(String description){
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
