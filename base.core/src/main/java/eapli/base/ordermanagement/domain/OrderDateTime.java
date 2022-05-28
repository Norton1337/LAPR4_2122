package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class OrderDateTime {

    private LocalDateTime dateTime;

    public OrderDateTime(LocalDateTime dateTime){

        this.dateTime =dateTime;
    }
    public OrderDateTime(){}

    @Override
    public String toString() {
        return "OrderDateTime{" +
                "dateTime=" + dateTime +
                '}';
    }

    public LocalDateTime value(){
        return this.dateTime;
    }

    public static OrderDateTime valueOf(LocalDateTime dateTime){
        return new OrderDateTime(dateTime);
    }

}
