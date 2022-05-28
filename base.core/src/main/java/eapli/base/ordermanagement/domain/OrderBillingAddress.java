package eapli.base.ordermanagement.domain;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class OrderBillingAddress implements ValueObject {
    private String billingAddres;
    public OrderBillingAddress(String billingAddres){

        this.billingAddres=billingAddres;
    }
    public OrderBillingAddress(){}

    @Override
    public String toString() {
        return "OrderBillingAddres{" +
                "billingAddres=" + billingAddres +
                '}';
    }

    public String value(){
        return this.billingAddres;
    }

    public static OrderBillingAddress valueOf(String billingAddress){
        return new OrderBillingAddress(billingAddress);
    }
}
