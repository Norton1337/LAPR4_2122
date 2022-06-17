package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.DomainFactory;

import java.io.IOException;


public class OrderBuilder implements DomainFactory<OrderType> {

    private OrderType theOrder;

    private OrderID orderID;

    private OrderBillingAddress orderBillingAddress;

    private OrderLocation orderLocation;

    private OrderTotalAmount orderTotalAmount;

    private OrderPostalAddress orderPostalAddress;

    private OrderDateTime orderDateTime;

    private OrderState orderState;

    private OrderWeight orderWeight;


    public OrderBuilder ofID(final OrderID orderID){
        this.orderID = orderID;
        return this;
    }
    public OrderBuilder ofBillingAddress(final OrderBillingAddress orderBillingAddress){
        this.orderBillingAddress=orderBillingAddress;
        return this;
    }
    public OrderBuilder ofLocation(final OrderLocation orderLocation){
        this.orderLocation=orderLocation;
        return this;
    }

    public OrderBuilder ofTotalAmount(final OrderTotalAmount orderTotalAmount){
        this.orderTotalAmount=orderTotalAmount;
        return this;
    }

    public OrderBuilder ofPostalAddress(final OrderPostalAddress orderPostalAddress){
        this.orderPostalAddress=orderPostalAddress;
        return this;
    }

    public OrderBuilder ofDateTime(final OrderDateTime orderDateTime){
        this.orderDateTime=orderDateTime;
        return this;
    }

    public OrderBuilder ofState(final OrderState orderState){
        this.orderState=orderState;
        return this;
    }
    public OrderBuilder ofWeight(final OrderWeight orderWeight){
        this.orderWeight=orderWeight;
        return this;
    }

    private OrderType buildOrThrow() throws IOException {
        if (theOrder != null) {
            return theOrder;
        } else if (orderID != null && orderBillingAddress != null && orderLocation != null && orderTotalAmount != null
                && orderPostalAddress != null && orderDateTime!=null && orderState!=null) {
            theOrder = new OrderType(orderID, orderBillingAddress, orderLocation, orderTotalAmount, orderPostalAddress, orderDateTime, orderState, orderWeight);
            return theOrder;
        } else {
            throw new IllegalStateException();
        }
    }


    @Override
    public OrderType build() {
        final OrderType ret;
        try {
            ret = buildOrThrow();
            theOrder = null;
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
