package eapli.base.ordermanagement.domain;

import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.IOException;


@Entity
public class OrderType implements AggregateRoot<OrderID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDERID")
    private Long idOfOrder;
    @Embedded
    private OrderID orderID;
    @Embedded
    private OrderBillingAddress orderBillingAddress;
    @Embedded
    private OrderLocation orderLocation;
    @Embedded
    private OrderTotalAmount orderTotalAmount;
    @Embedded
    private OrderPostalAddress orderPostalAddress;
    @Embedded
    private OrderDateTime orderDateTime;
    @Embedded
    private OrderState orderState;

    @OneToOne(mappedBy = "order")
    private Task task;

    public OrderType(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation, OrderTotalAmount orderTotalAmount,
                     OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime, OrderState orderState){

        this.orderID = orderID;
        this.orderBillingAddress = orderBillingAddress;
        this.orderLocation = orderLocation;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPostalAddress = orderPostalAddress;
        this.orderDateTime = orderDateTime;
        this.orderState = orderState;
    }

    protected OrderType() {

    }

    public OrderType(OrderDTO dto) throws IOException {
        this(
                new OrderID(dto.orderID),
                new OrderBillingAddress(dto.orderBillingAddress),
                new OrderLocation(dto.orderLocation),
                new OrderTotalAmount(dto.orderTotalAmount),
                new OrderPostalAddress(dto.orderPostalAddress),
                new OrderDateTime(dto.orderDateTime),
                new OrderState(dto.orderState)
        );
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderBillingAddress=" + orderBillingAddress +
                ", orderLocation=" + orderLocation +
                ", orderTotalAmount=" + orderTotalAmount +
                ", orderPostalAddress=" + orderPostalAddress +
                ", orderDateTime=" + orderDateTime +
                ", orderState=" + orderState +
                '}';
    }

    public static OrderType valueOf(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation,
                                    OrderTotalAmount orderTotalAmount, OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime, OrderState orderState){
        return new OrderType(orderID, orderBillingAddress, orderLocation, orderTotalAmount, orderPostalAddress, orderDateTime, orderState);
    }

    public OrderState getOrderState() {
        return orderState;
    }
    public void changeOrderState(PossibleStates state) {
        this.orderState=new OrderState(state);
    }

    public void setTask(Task task){
        this.task=task;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public OrderID identity() {
        return orderID;
    }

    public OrderDateTime getOrderDateTime(){ return orderDateTime; }
}
