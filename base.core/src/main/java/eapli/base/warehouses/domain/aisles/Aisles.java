package eapli.base.warehouses.domain.aisles;


import eapli.base.warehouses.domain.rows.Rows;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.base.warehouses.domain.warehouse.WarehouseIdentification;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntity;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;
import java.util.List;

@Entity
public class Aisles implements AggregateRoot<AisleID> {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private Long version;

    @Embedded
    private AisleID aisleID;

    @Embedded
    private Square begin;

    @Embedded
    private Square end;

    @Embedded
    private Square depth;

    @Embedded
    private Accessibility accessibility;

    @OneToMany
    private List<Rows> rows;

    @ManyToOne
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    protected Aisles() {}

    public Aisles (int aisleID,Square begin, Square end, Square depth, Accessibility accessibility, List<Rows> rows){
        Preconditions.ensure(aisleID>=0);
        Preconditions.noneNull(begin,end,depth,accessibility);
        this.aisleID=new AisleID(aisleID);
        this.begin=begin;
        this.end=end;
        this.depth=depth;
        this.accessibility=accessibility;
        this.rows=rows;
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
