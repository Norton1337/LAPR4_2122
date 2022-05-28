package eapli.base.taskmanagement.dto;

import eapli.base.ordermanagement.domain.Order;
import eapli.base.ordermanagement.domain.PossibleStates;

import java.time.LocalDateTime;

public class TaskDTO {

    public Long taskID;
    public LocalDateTime taskDateTime;
    public Order order;


    public TaskDTO(Long taskID, LocalDateTime taskDateTime, Order order){
        this.taskID = taskID;
        this.taskDateTime = taskDateTime;
        this.order = order;
    }

}
