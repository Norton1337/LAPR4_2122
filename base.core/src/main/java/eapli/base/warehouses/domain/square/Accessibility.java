package eapli.base.warehouses.domain.square;

import eapli.base.warehouses.domain.warehouse.WarehouseWidth;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Arrays;

@Embeddable
public class Accessibility implements ValueObject {
    private String accessibility;

    public Accessibility(String accessibility){
        this.accessibility = accessibility;
    }

    @Deprecated
    public Accessibility(){

    }

    @Override
    public String toString() {
        return "Accessibility{" +
                "accessibility=" + accessibility +
                '}';
    }

    public static Accessibility valueOf(String accessibility){
        return new Accessibility(accessibility);
    }


}
