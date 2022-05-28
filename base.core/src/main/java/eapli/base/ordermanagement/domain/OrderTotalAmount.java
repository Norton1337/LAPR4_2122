package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class OrderTotalAmount {

    private Double totalAmount;

    public OrderTotalAmount(Double totalAmount){

        this.totalAmount=totalAmount;
    }
    public OrderTotalAmount(){}

    @Override
    public String toString() {
        return "OrderTotalAmount{" +
                "totalAmount=" + totalAmount +
                '}';
    }

    public Double value(){
        return this.totalAmount;
    }

    public static OrderTotalAmount valueOf(Double totalAmount){
        return new OrderTotalAmount(totalAmount);
    }

}
