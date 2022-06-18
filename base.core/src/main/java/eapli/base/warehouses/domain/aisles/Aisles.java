package eapli.base.warehouses.domain.aisles;


import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aisles implements AggregateRoot<AisleID> {
    @Id
    @GeneratedValue
    @Column(name = "AISLEID")
    private int id;

    @Version
    private Long version;

    @Embedded
    private AisleID aisleIdentification;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aisleSquareBegin", referencedColumnName = "SQUAREID")
    private Square begin;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aisleSquareEnd", referencedColumnName = "SQUAREID")
    private Square end;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aisleSquareDepth", referencedColumnName = "SQUAREID")
    private Square depth;

    @Embedded
    private Accessibility accessibility;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aisle")
    private List<Rows> rows;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAREHOUSEID")
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    protected Aisles() {}

    public Aisles (int aisleID,Square begin, Square end, Square depth, Accessibility accessibility, List<Rows> rows){
/*        Preconditions.ensure(aisleID>=0);
        Preconditions.noneNull(begin,end,depth,accessibility);*/
        this.aisleIdentification =new AisleID(aisleID);
        this.begin=begin;
        this.end=end;
        this.depth=depth;
        this.accessibility=accessibility;
        this.rows=rows;
        for (Rows row:rows) {
            row.setAisle(this);
        }
    }

    @Override
    public String toString() {
        return "Aisles{" +
                "id=" + id +
                ", version=" + version +
                ", being=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                ", rows=" + rows +
                '}';
    }

    public static Aisles valueOf(int aisleID, Square begin, Square end, Square depth, Accessibility accessibility, List<Rows> rows){
        return new Aisles(aisleID,begin,end,depth,accessibility,rows);
    }

    public Square getBegin(){
        return this.begin;
    }
    public Square getEnd(){
        return this.end;
    }
    public Square getDepth(){
        return this.depth;
    }

    public List<Rows> getRows(){
        return this.rows;
    }

    public Accessibility getAccessibility(){
        return this.accessibility;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AisleID identity() {
        return null;
    }
}
