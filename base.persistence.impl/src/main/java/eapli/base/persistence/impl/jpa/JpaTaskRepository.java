package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.domain.TaskID;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaTaskRepository extends JpaAutoTxRepository<Task, TaskID, TaskID>
    implements TaskRepository
{


    public JpaTaskRepository(final String persistenceUnitName) {
        super(persistenceUnitName, Application.settings().getExtendedPersistenceProperties(), "taskID");
    }

    public JpaTaskRepository(TransactionalContext tx) {
        super(tx, "taskID");
    }

    @Override
    public List<Task> findAll(){

        final TypedQuery<Task> query = entityManager().createQuery(
                "SELECT t FROM Task t",
                Task.class
        );
        return query.getResultList();
    }
}
