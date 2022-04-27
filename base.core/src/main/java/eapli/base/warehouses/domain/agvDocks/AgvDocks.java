package eapli.base.warehouses.domain.agvDocks;

import eapli.base.warehouses.domain.agvs.*;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainEntity;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
public class AgvDocks implements DomainEntity<AgvDocks> {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private Long version;

    @Embedded
    private Square being;

    @Embedded
    private Square end;

    @Embedded
    private Square depth;

    @Embedded
    private Accessibility accessibility;


    public AgvDocks(Square begin,Square end,Square depth,Accessibility accessibility){
        this.being=begin;
        this.end=end;
        this.depth=depth;
        this.accessibility=accessibility;
    }

    protected AgvDocks(){}

    @Override
    public String toString() {
        return "AgvDocks{" +
                "id=" + id +
                ", version=" + version +
                ", being=" + being +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                '}';
    }

    public static AgvDocks valueOf(Square begin, Square end, Square depth, Accessibility accessibility){
        return new AgvDocks(begin,end,depth,accessibility);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AgvDocks identity() {
        return null;
    }
}
