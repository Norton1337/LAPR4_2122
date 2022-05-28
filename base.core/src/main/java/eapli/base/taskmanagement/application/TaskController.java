package eapli.base.taskmanagement.application;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.ordermanagement.domain.PossibleStates;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.warehouses.repositories.WarehouseRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private final TaskRepository taskRepository = eapli.base.infrastructure.persistence.PersistenceContext.repositories().task();

    public TaskController(){}



}
