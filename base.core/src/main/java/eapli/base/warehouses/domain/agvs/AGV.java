package eapli.base.warehouses.domain.agvs;

import eapli.base.taskmanagement.domain.Task;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.dto.AgvDTO;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

@Entity
@Table(name = "agvs")
public class AGV implements AggregateRoot<AGVIdentification> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    //agvDock_agvDock_id
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_agvDock_id", referencedColumnName = "AGVDOCKID")
    private AgvDocks agvDock;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_task_id", referencedColumnName = "TASKID")
    private Task task;

    public void setAgvDock(AgvDocks agvDock){
        this.agvDock=agvDock;
    }

    public AGV(AGVIdentification identification, Autonomy autonomy, MaxWeight maxWeight, Model model,
               ShortDescription shortDescription, Status status, AgvDocks agvDock){
        //Preconditions.noneNull(identification,autonomy,maxWeight,model,shortDescription,status,agvDock);

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

    public Task getTask(){
        return this.task;
    }


    public void setTask(Task task){
        this.task=task;
    }
}
