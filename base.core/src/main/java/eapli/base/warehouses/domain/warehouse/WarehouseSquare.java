package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class WarehouseSquare implements ValueObject {
    private Double square;

    public WarehouseSquare(Double square){
        this.square=square;
    }
    public WarehouseSquare(){}

    @Override
    public String toString() {
        return "WarehouseSquare{" +
                "square=" + square +
                '}';
    }

    public Double value(){
        return this.square;
    }

    public static WarehouseSquare valueOf(Double square){
        return new WarehouseSquare(square);
    }
}
