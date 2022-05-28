package eapli.base.warehouses.domain.agvs;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

@Embeddable
public class Model implements ValueObject {
    private String model;

    public Model (String model){
        //Preconditions.ensure(model.length()>0 && model.length()<50);
        this.model=model;
    }

    public Model (){
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                '}';
    }

    public static Model valueOf(String model){
        return new Model(model);
    }
}
