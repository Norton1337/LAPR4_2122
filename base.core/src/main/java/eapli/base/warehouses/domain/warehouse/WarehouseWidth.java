package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class WarehouseWidth implements ValueObject{
    private Double width;

    public WarehouseWidth(Double width){
        Preconditions.ensure(width>0);
        this.width=width;
    }
    public WarehouseWidth(){}

    @Override
    public String toString() {
        return "WarehouseWidth{" +
                "width=" + width +
                '}';
    }

    public Double value(){
        return this.width;
    }

    public static WarehouseWidth valueOf(Double width){
        return new WarehouseWidth(width);
    }

}
