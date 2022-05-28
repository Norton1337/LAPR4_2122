package eapli.base.warehouses.domain.rows;

import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rows implements DomainEntity<Rows> {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private Long version;

    private int rowID;

    @Embedded
    private Square begin;

    @Embedded
    private Square end;

    @OneToMany
    private List<Shelves> shelves;

    @ManyToOne
    private Aisles aisle;

    public Rows() {
    }

    public Rows(int rowID, Square begin, Square end, int shelvesAmount){
        Preconditions.noneNull(begin,end);
        Preconditions.ensure(shelvesAmount>0);
        this.rowID=rowID;
        shelves = new ArrayList<>();
        for (int i = 1; i <= shelvesAmount; i++) {
            shelves.add(new Shelves(i));
        }
        this.begin = begin;
        this.end = end;

    }

    @Override
    public String toString() {
        return "Rows{" +
                "id=" + id +
                ", version=" + version +
                ", begin=" + begin +
                ", end=" + end +
                ", shelves=" + shelves +
                '}';
    }

    public static Rows valueOf(int rowID ,Square begin, Square end, int shelvesAmount){
        return new Rows(rowID, begin,end,shelvesAmount);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Rows identity() {
        return null;
    }
}
