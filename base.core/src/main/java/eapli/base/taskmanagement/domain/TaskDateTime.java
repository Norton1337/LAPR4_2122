package eapli.base.taskmanagement.domain;

import eapli.base.ordermanagement.domain.OrderDateTime;

import java.time.LocalDateTime;

public class TaskDateTime {
    private LocalDateTime dateTime;


    public TaskDateTime(LocalDateTime dateTime){
        this.dateTime =dateTime;
    }
    public TaskDateTime(){}

    @Override
    public String toString() {
        return "TaskDateTime{" +
                "dateTime=" + dateTime +
                '}';
    }

    public LocalDateTime value(){
        return this.dateTime;
    }

    public static TaskDateTime valueOf(LocalDateTime dateTime){
        return new TaskDateTime(dateTime);
    }
}
