package eapli.base.warehouses.domain.square;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Length implements Comparable<Length>, ValueObject {

    private int lengthNum;

    public Length(int lengthNum){
        //Preconditions.ensure(lengthNum>0);
        this.lengthNum = lengthNum;
    }

    @Deprecated
    public Length() {
    }

    @Override
    public String toString() {
        return "Length{" +
                "lengthNum=" + lengthNum +
                '}';
    }

    public int value(){
        return this.lengthNum;
    }

    @Override
    public int compareTo(Length o) {
        return this.compareTo(o);
    }

    public static Length valueOf(int lengthNum){
        return new Length(lengthNum);
    }
}
