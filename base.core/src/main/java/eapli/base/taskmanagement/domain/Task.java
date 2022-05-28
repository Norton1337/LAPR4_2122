package eapli.base.taskmanagement.domain;

import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.taskmanagement.dto.TaskDTO;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.IOException;

@Entity
public class Task implements AggregateRoot<TaskID> {
    @Id
    private Long id;
    @Embedded
    private TaskID taskID;
    @Embedded
    private TaskDateTime taskDateTime;
    @OneToOne
    private Order order;

    public Task(TaskID taskID, TaskDateTime taskDateTime, Order order){

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

    public static Task valueOf(TaskID taskID, TaskDateTime taskDateTime, Order order){
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
