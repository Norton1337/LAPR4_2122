package eapli.base.ordermanagement.domain;


import javax.persistence.Embeddable;

@Embeddable
public class OrderID implements Comparable<OrderID> {
    private Long id;

    public OrderID(Long id){

        this.id=id;
    }
    public OrderID(){}

    @Override
    public String toString() {
        return "OrderID{" +
                "id=" + id +
                '}';
    }

    public Long value(){
        return this.id;
    }

    public static OrderID valueOf(Long id){
        return new OrderID(id);
    }

    @Override
    public int compareTo(OrderID o) {
        return 0;
    }
}
