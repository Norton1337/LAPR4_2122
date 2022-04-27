package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Status implements ValueObject {
    private String status;

    public Status(String status){
        this.status=status;
    }

    public Status(){}

    @Override
    public String toString() {
        return "Status{" +
                "status='" + status + '\'' +
                '}';
    }

    public static Status valueOf(String status){
        return new Status(status);
    }
}
