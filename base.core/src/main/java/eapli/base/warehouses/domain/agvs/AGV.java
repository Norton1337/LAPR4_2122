package eapli.base.warehouses.domain.agvs;

import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
public class AGV implements AggregateRoot<AGVIdentification> {
    @Id
    @Column(insertable = false, updatable = false)
    private int agvId;

    @Version
    private Long version;

    @Embedded
    private AGVIdentification identification;

    @Embedded
    private Autonomy autonomy;

    @Embedded
    private MaxWeight maxWeight;

    @Embedded
    private Model model;

    @Embedded
    private ShortDescription shortDescription;

    @Embedded
    private Status status;

    @OneToOne
    private AgvDocks agvDock;



    public AGV(AGVIdentification identification, Autonomy autonomy, MaxWeight maxWeight, Model model,
               ShortDescription shortDescription, Status status, AgvDocks agvDock){
        Preconditions.noneNull(identification,autonomy,maxWeight,model,shortDescription,status,agvDock);

        this.identification = identification;
        this.autonomy = autonomy;
        this.maxWeight = maxWeight;
        this.model = model;
        this.shortDescription = shortDescription;
        this.status = status;
        this.agvDock = agvDock;
    }

    public AGV(AgvDTO dto) {
        this(
                new AGVIdentification(dto.identification),
                new Autonomy(dto.autonomy),
                new MaxWeight(dto.maxWeight),
                new Model(dto.model),
                new ShortDescription(dto.shortDescription),
                new Status(dto.status),
                dto.agvDock
        );
    }
    @Deprecated
    public AGV(){}

    @Override
    public String toString() {
        return "AGV{" +
                "id=" + identification +
                ", version=" + version +
                ", autonomy=" + autonomy +
                ", maxWeight=" + maxWeight +
                ", model=" + model +
                ", shortDescription=" + shortDescription +
                ", status=" + status +
                ", agvDock=" + agvDock +
                '}';
    }

    public static AGV valueOf(AGVIdentification identification, Autonomy autonomy, MaxWeight maxWeight, Model model, ShortDescription shortDescription, Status status, AgvDocks agvDock){
        return new AGV(identification, autonomy,maxWeight,model,shortDescription,status,agvDock);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public AGVIdentification identity() {
        return this.identification;
    }
}
