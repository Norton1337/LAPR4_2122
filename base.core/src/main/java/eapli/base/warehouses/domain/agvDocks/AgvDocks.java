package eapli.base.warehouses.domain.agvDocks;


import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.framework.domain.model.DomainEntity;


import javax.persistence.*;

@Entity
public class AgvDocks implements DomainEntity<AgvDocks> {
    @Id
    @GeneratedValue
    private String id;

    @Version
    private Long version;

    @Embedded
    private Square begin;

    @Embedded
    private Square end;

    @Embedded
    private Square depth;

    @Embedded
    private Accessibility accessibility;


    public AgvDocks(String id, Square begin,Square end,Square depth,Accessibility accessibility){
        this.id = id;
        this.begin=begin;
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
                ", being=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                '}';
    }

    public static AgvDocks valueOf(String id,Square begin, Square end, Square depth, Accessibility accessibility){
        return new AgvDocks(id, begin,end,depth,accessibility);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AgvDocks identity() {
        return null;
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
}
