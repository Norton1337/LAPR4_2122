package eapli.base.warehouses.domain.square;
import eapli.base.warehouses.domain.aisles.AisleID;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class Square implements AggregateRoot<SquareID> {
    @Id
    @GeneratedValue
    @Column(name = "SQUAREID")
    private int squareId;

    @Version
    private Long version;

    @Embedded
    private SquareID squareIdentification;
    @Embedded
    private Length length;

    @Embedded
    private Width width;

    public Square(Length length, Width width){
       // Preconditions.noneNull(length,width);

        this.squareIdentification=new SquareID(ThreadLocalRandom.current().nextInt(100000000,999999999+1));
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

    public Length length(){
        return this.length;
    }

    public Width width(){
        return this.width;
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public SquareID identity() {
        return null;
    }
}
