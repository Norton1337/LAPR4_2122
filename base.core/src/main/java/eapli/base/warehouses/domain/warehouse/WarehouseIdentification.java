package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class WarehouseIdentification implements ValueObject, Comparable<WarehouseIdentification> {
    private String address;

    public WarehouseIdentification(String address){
        this.address=address;
    }
    public WarehouseIdentification(){}

    @Override
    public String toString() {
        return "WarehouseAddress{" +
                "address='" + address + '\'' +
                '}';
    }

    public static WarehouseIdentification valueOf(String address){
        return new WarehouseIdentification(address);
    }

    @Override
    public int compareTo(@NotNull WarehouseIdentification o) {
        return 0;
    }
}
