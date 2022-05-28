package eapli.base.taskmanagement.domain;

import eapli.base.ordermanagement.domain.*;
import eapli.base.taskmanagement.dto.TaskDTO;
import eapli.base.warehouses.domain.agvs.AGV;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.IOException;

@Entity
public class Task implements AggregateRoot<TaskID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASKID")
    private Long idOfTask;
    @Embedded
    private TaskID taskID;
    @Embedded
    private TaskDateTime taskDateTime;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id", referencedColumnName = "ORDERID")
    private OrderType order;

    @OneToOne(mappedBy = "task")
    private AGV agv;



    public Task(TaskID taskID, TaskDateTime taskDateTime, OrderType order){

        this.taskID = taskID;
        this.taskDateTime = taskDateTime;
        this.order = order;
    }

    protected Task() {

    }

    public Task(TaskDTO dto) throws IOException {
        this(
                new TaskID(dto.taskID),
                new TaskDateTime(dto.taskDateTime),
                dto.order
        );
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskID=" + taskID +
                ", taskDateTime=" + taskDateTime +
                ", order=" + order +
                '}';
    }

    public static Task valueOf(TaskID taskID, TaskDateTime taskDateTime, OrderType order){
        return new Task(taskID, taskDateTime, order);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public TaskID identity() {
        return taskID;
    }

}
