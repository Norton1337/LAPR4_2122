package eapli.base.warehouses.domain.square;


import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;


@Embeddable
public class Accessibility implements ValueObject, DomainEntity<Accessibility> {
    private String accessibility;

    public Accessibility(String accessibility){
        this.accessibility = accessibility;
    }

    @Deprecated
    public Accessibility(){
    }

    @Override
    public String toString() {
        return accessibility;
    }

    public static Accessibility valueOf(String accessibility){
        return new Accessibility(accessibility);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Accessibility identity() {
        return null;
    }
}
