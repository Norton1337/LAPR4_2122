package eapli.base.warehouses.domain.agvDocks;


import eapli.base.warehouses.domain.agvs.AGV;
import eapli.base.warehouses.domain.square.Accessibility;
import eapli.base.warehouses.domain.square.Square;
import eapli.base.warehouses.domain.warehouse.Warehouse;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;


import javax.persistence.*;

@Entity
@Table(name = "agvDocks")
public class AgvDocks implements AggregateRoot<AgvDockIdentification> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AGVDOCKID")
    private Long agvDockID;

    @Embedded
    @Column(name = "agvDockIden")
    private AgvDockIdentification agvDockIdentification;

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

    @OneToOne(mappedBy = "agvDock")
    private AGV agv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAREHOUSEID")
    private Warehouse warehouse;

    public void setAgv(AGV agv){
        this.agv=agv;
    }

    public AgvDocks(AgvDockIdentification agvDockIdentification, Square begin,Square end,Square depth,Accessibility accessibility){
        //Preconditions.noneNull(begin,end,depth,accessibility);
        this.agvDockIdentification = agvDockIdentification;
        this.begin=begin;
        this.end=end;
        this.depth=depth;
        this.accessibility=accessibility;
    }

    protected AgvDocks(){}

    @Override
    public String toString() {
        return "AgvDocks{" +
                "agvDockIdentification=" + agvDockIdentification +
                ", version=" + version +
                ", being=" + begin +
                ", end=" + end +
                ", depth=" + depth +
                ", accessibility=" + accessibility +
                '}';
    }

    public static AgvDocks valueOf(AgvDockIdentification agvDockIdentification,Square begin, Square end, Square depth, Accessibility accessibility){
        return new AgvDocks(agvDockIdentification, begin,end,depth,accessibility);
    }


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AgvDockIdentification identity() {
        return null;
    }

    public void setWarehouse(Warehouse warehouse){
        this.warehouse=warehouse;
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
