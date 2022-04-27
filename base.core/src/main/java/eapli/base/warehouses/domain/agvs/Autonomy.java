package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Autonomy implements ValueObject {
    private Double autonomy;

    public Autonomy(Double autonomy){
        this.autonomy = autonomy;
    }

    @Deprecated
    public Autonomy() {
    }

    @Override
    public String toString() {
        return "Autonomy{" +
                "autonomy=" + autonomy +
                '}';
    }

    public static Autonomy valueOf(Double autonomy){
        return new Autonomy(autonomy);
    }
}
