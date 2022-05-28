package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLocation {

    private String location;
    public OrderLocation(String location){

        this.location=location;
    }
    public OrderLocation(){}

    @Override
    public String toString() {
        return "OrderLocation{" +
                "location=" + location +
                '}';
    }

    public String value(){
        return this.location;
    }

    public static OrderLocation valueOf(String location){
        return new OrderLocation(location);
    }

}
