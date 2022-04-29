package eapli.base.warehouses.domain.square;


import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;


@Embeddable
public class Accessibility implements ValueObject, DomainEntity<Accessibility> {
    private String accessibility;

    public Accessibility(String accessibility){
        Preconditions.ensure(accessibility.length()==2);
        Preconditions.ensure(accessibility.charAt(0)=='w'||accessibility.charAt(0)=='l');
        Preconditions.ensure(accessibility.charAt(1)=='-'||accessibility.charAt(1)=='+');
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
