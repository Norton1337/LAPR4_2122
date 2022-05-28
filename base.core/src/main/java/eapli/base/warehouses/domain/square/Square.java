package eapli.base.warehouses.domain.square;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.JoinColumn;

@Embeddable
public class Square implements ValueObject, DomainEntity<Square>, Comparable<Square> {
    @Embedded
    private Length length;

    @Embedded
    private Width width;

    public Square(Length length, Width width){
       // Preconditions.noneNull(length,width);

        this.length=length;
        this.width=width;
    }

    @Deprecated
    public Square(){
    }

    @Override
    public String toString() {
        return "Square{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    public static Square valueOf(Length length, Width width){
        return new Square(length,width);
    }

    @Override
    public boolean sameAs(Object other) {
        return this.equals(other);
    }

    public Length length(){
        return this.length;
    }

    public Width width(){
        return this.width;
    }

    @Override
    public int compareTo(Square other) {
        return toString().compareTo(other.toString());
    }

    @Override
    public Square identity() {
        return this;
    }

}
