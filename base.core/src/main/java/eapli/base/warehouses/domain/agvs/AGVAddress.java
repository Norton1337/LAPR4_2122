package eapli.base.warehouses.domain.agvs;

import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class AGVAddress {
    @Id
    @GeneratedValue
    @Column(name = "AGVADDRESSID")
    private int id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressSquareBegin", referencedColumnName = "SQUAREID")
    private Square begin;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressSquareEnd", referencedColumnName = "SQUAREID")
    private Square end;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressSquareDepth", referencedColumnName = "SQUAREID")
    private Square depth;

    public AGVAddress() {
    }

    public AGVAddress(Square begin, Square end, Square depth) {
        this.begin = begin;
        this.end = end;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "AGVAddress{" +
                "begin=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                '}';
    }

    public Square getBegin() {
        return begin;
    }

    public void setBegin(Square begin) {
        this.begin = begin;
    }

    public Square getEnd() {
        return end;
    }

    public void setEnd(Square end) {
        this.end = end;
    }

    public Square getDepth() {
        return depth;
    }

    public void setDepth(Square depth) {
        this.depth = depth;
    }

    public static AGVAddress valueOf(Square begin, Square end, Square depth){
        return new AGVAddress(begin,end,depth);
    }
}