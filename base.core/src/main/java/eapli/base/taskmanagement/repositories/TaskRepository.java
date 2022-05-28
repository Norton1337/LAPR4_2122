package eapli.base.taskmanagement.repositories;

import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.OrderID;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface TaskRepository extends DomainRepository<TaskID, Task> {

    public List<Task> findAll();
}
