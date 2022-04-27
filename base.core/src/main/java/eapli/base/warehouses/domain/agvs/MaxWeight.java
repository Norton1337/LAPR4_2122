package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class MaxWeight implements ValueObject {

    private Double weight;

    public MaxWeight(double weight){
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
