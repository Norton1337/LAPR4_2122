package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class MaxWeight implements ValueObject {

    private Double weight;

    public MaxWeight(double weight){
        Preconditions.ensure(weight>0);
        this.weight=weight;
    }

    public MaxWeight(){}

    @Override
    public String toString() {
        return "MaxWeight{" +
                "weight=" + weight +
                '}';
    }
    public static MaxWeight valueOf(Double weight){
        return new MaxWeight(weight);
    }
}
