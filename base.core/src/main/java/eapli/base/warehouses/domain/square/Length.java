package eapli.base.warehouses.domain.square;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Length implements Comparable<Length>, ValueObject {
    private int lengthNum;

    public Length(int lengthNum){
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
