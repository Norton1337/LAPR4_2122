package eapli.base.warehouses.domain.agvDocks;

import eapli.base.warehouses.domain.agvs.AGVIdentification;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class AgvDockIdentification implements ValueObject, Comparable<AgvDockIdentification> {

    private String id;

    public AgvDockIdentification(String id){
        Preconditions.nonNull(id);
        Preconditions.ensure(id.length()<=8);
        this.id=id;
    }

    public AgvDockIdentification(){}

    @Override
    public String toString() {
        return "AgvDockIdentification{" +
                "id='" + id + '\'' +
                '}';
    }

    public static AgvDockIdentification valueOf(String id){
        return new AgvDockIdentification(id);
    }

    @Override
    public int compareTo(AgvDockIdentification o) {
        return 0;
    }

}
