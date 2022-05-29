package eapli.base.taskmanagement.application;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskDateTime;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.taskmanagement.repositories.TaskRepository;

import java.time.LocalDateTime;

public class TaskController {
    private final TaskRepository taskRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().task();

    public TaskController(){}

    public Task createTask(OrderType order){
        return new Task(
                new TaskID(order.identity().value()),
                new TaskDateTime(LocalDateTime.now()),
                order);
    }


}
