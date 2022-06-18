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
    @Column(name = "ROWID")
    private int id;

    @Version
    private Long version;

    private int rowIdentification;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rowSquareBegin", referencedColumnName = "SQUAREID")
    private Square begin;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rowSquareEnd", referencedColumnName = "SQUAREID")
    private Square end;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "row")
    private List<Shelves> shelves;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AISLEID")
    private Aisles aisle;

    public Rows() {
    }

    public Rows(int rowID, Square begin, Square end, int shelvesAmount){
/*        Preconditions.noneNull(begin,end);
        Preconditions.ensure(shelvesAmount>0);*/
        this.rowIdentification =rowID;
        shelves = new ArrayList<>();
        for (int i = 1; i <= shelvesAmount; i++) {
            shelves.add(new Shelves(i));
        }
        for (Shelves shelf:this.shelves) {
            shelf.setRow(this);
        }
        this.begin = begin;
        this.end = end;

    }

    public void setAisle(Aisles aisle){
        this.aisle=aisle;
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

    public List<Shelves> getShelves(){
        return this.shelves;
    }

    public Square getBegin(){
        return this.begin;
    }
    public Square getEnd(){
        return this.end;
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
