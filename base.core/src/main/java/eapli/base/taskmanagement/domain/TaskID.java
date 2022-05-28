package eapli.base.taskmanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class TaskID implements Comparable<TaskID>{

    private Long id;

    public TaskID(Long id){

        this.id=id;
    }
    public TaskID(){}

    @Override
    public String toString() {
        return "TaskID{" +
                "id=" + id +
                '}';
    }

    public Long value(){
        return this.id;
    }

    public static TaskID valueOf(Long id){
        return new TaskID(id);
    }

    @Override
    public int compareTo(TaskID o) {
        return 0;
    }

}
