package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class WarehouseUnit implements ValueObject {
    private String unit;

    public WarehouseUnit(String unit){
        Preconditions.nonNull(unit);
        this.unit=unit;
    }

    public WarehouseUnit(){}

    @Override
    public String toString() {
        return "WarehouseUnit{" +
                "unit='" + unit + '\'' +
                '}';
    }

    public static WarehouseUnit valueOf(String unit){
        return new WarehouseUnit(unit);
    }
}
