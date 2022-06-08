package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class OrderWeight {

    private Double weight;

    public OrderWeight(Double weight){

        this.weight =weight;
    }
    public OrderWeight(){}

    @Override
    public String toString() {
        return "OrderWeight{" +
                "weight=" + weight +
                '}';
    }

    public Double value(){
        return this.weight;
    }

    public static OrderWeight valueOf(Double weight){
        return new OrderWeight(weight);
    }

}
