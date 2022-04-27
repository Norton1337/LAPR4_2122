package eapli.base.warehouses.domain.warehouse;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class WarehouseAddress implements ValueObject {
    private String address;

    public WarehouseAddress(String address){
        this.address=address;
    }
    public WarehouseAddress(){}

    @Override
    public String toString() {
        return "WarehouseAddress{" +
                "address='" + address + '\'' +
                '}';
    }

    public static WarehouseAddress valueOf(String address){
        return new WarehouseAddress(address);
    }
}
