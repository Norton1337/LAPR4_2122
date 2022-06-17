package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class AGVIdentification implements ValueObject, Comparable<AGVIdentification> {
    private String id;

    public AGVIdentification(String id){
        //Preconditions.nonNull(id);
        //Preconditions.ensure(id.length()<=8);
        this.id=id;
    }

    public AGVIdentification(){}

    @Override
    public String toString() {
        return id;
    }

    public static AGVIdentification valueOf(String id){
        return new AGVIdentification(id);
    }

    @Override
    public int compareTo(AGVIdentification o) {
        return 0;
    }
}
