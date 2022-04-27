package eapli.base.warehouses.domain.agvs;

import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class AGVAddress implements ValueObject {
    @Embedded
    private Square being;

    @Embedded
    private Square end;

    @Embedded
    private Square depth;

    public AGVAddress() {
    }

    public AGVAddress(Square begin, Square end, Square depth) {
        this.being = begin;
        this.end = end;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "AGVAddress{" +
                "being=" + being +
                ", end=" + end +
                ", depth=" + depth +
                '}';
    }

    public static AGVAddress valueOf(Square begin, Square end, Square depth){
        return new AGVAddress(begin,end,depth);
    }
}