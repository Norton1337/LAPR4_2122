package eapli.base.taskmanagement.dto;

import eapli.base.ordermanagement.domain.OrderType;

import java.time.LocalDateTime;

public class TaskDTO {

    public Long taskID;
    public LocalDateTime taskDateTime;
    public OrderType order;


    public TaskDTO(Long taskID, LocalDateTime taskDateTime, OrderType order){
        this.taskID = taskID;
        this.taskDateTime = taskDateTime;
        this.order = order;
    }

}
