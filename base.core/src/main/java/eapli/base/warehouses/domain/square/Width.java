package eapli.base.warehouses.domain.square;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Width implements Comparable<Width>, ValueObject {
    @Column(name="width", insertable = false, updatable = false)
    private int widthNum;

    public Width(int widthNum){
        Preconditions.ensure(widthNum>0);
        this.widthNum = widthNum;
    }

    @Deprecated
    public Width() {
    }

    @Override
    public String toString() {
        return "Width{" +
                "widthNum=" + widthNum +
                '}';
    }

    public int value(){
        return this.widthNum;
    }

    @Override
    public int compareTo(Width o) {
        return this.compareTo(o);
    }

    public static Width valueOf(int widthNum){
        return new Width(widthNum);
    }
}
