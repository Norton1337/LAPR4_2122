package eapli.base.ordermanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class OrderPostalAddress {
    private String postalAddress;
    public OrderPostalAddress(String postalAddress){

        this.postalAddress =postalAddress;
    }
    public OrderPostalAddress(){}

    @Override
    public String toString() {
        return "OrderBillingAddres{" +
                "postalAddress=" + postalAddress +
                '}';
    }

    public String value(){
        return this.postalAddress;
    }

    public static OrderPostalAddress valueOf(String postalAddress){
        return new OrderPostalAddress(postalAddress);
    }

}
