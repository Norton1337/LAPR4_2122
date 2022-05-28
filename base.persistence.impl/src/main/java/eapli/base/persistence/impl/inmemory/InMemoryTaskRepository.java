package eapli.base.persistence.impl.inmemory;

import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryTaskRepository extends InMemoryDomainRepository<Task, TaskID>
        implements TaskRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public List<Task> findAll(){

        return null;
    }

}
