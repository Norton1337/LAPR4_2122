package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;


@Embeddable
public class WarehouseLength implements ValueObject {
    private Double length;

    public WarehouseLength(Double length){
        Preconditions.ensure(length>0);
        this.length=length;
    }
    public WarehouseLength(){}

    @Override
    public String toString() {
        return "WarehouseLength{" +
                "length=" + length +
                '}';
    }

    public Double value(){
        return this.length;
    }

    public static WarehouseLength valueOf(Double length){
        return new WarehouseLength(length);
    }
}
