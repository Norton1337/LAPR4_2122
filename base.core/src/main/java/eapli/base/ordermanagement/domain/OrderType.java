package eapli.base.ordermanagement.domain;

import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;


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
    private OrderWeight orderWeight;
    @Embedded
    private OrderPostalAddress orderPostalAddress;
    @Embedded
    private OrderDateTime orderDateTime;
    @Embedded
    private OrderState orderState;

    @OneToOne(mappedBy = "order")
    private Task task;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItemList;

    @Embedded
    private Username clientUsername;


    public OrderType(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation, OrderTotalAmount orderTotalAmount,
                     OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime, OrderState orderState){

        this.orderID = orderID;
        this.orderBillingAddress = orderBillingAddress;
        this.orderLocation = orderLocation;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPostalAddress = orderPostalAddress;
        this.orderDateTime = orderDateTime;
        this.orderState = orderState;
        this.orderWeight=new OrderWeight(30.0);

    }
    public OrderType(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation, OrderTotalAmount orderTotalAmount,
                     OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime, OrderState orderState, List<OrderItem> orderItems){

        this.orderID = orderID;
        this.orderBillingAddress = orderBillingAddress;
        this.orderLocation = orderLocation;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPostalAddress = orderPostalAddress;
        this.orderDateTime = orderDateTime;
        this.orderState = orderState;
        this.orderItemList = orderItems;
        Double weight=0.0;
        for (OrderItem item:this.orderItemList) {
            weight += item.product().productWeight().getWeight()*item.amount();
        }
        this.orderWeight=new OrderWeight(weight);
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
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return "\nOrderID = " + orderID.value() +
                ",\n orderBillingAddress = " + orderBillingAddress.value() +
                ",\n orderLocation = " + orderLocation.value() +
                ",\n orderTotalAmount = " + df.format(orderTotalAmount.value()) +"€"+
                ",\n orderPostalAddress = " + orderPostalAddress.value() +
                ",\n orderDateTime = " + orderDateTime.value().toLocalDate().toString() +
                ",\n orderState = " + orderState.value();
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

    public void setClient(SystemUser client) {
        this.clientUsername = client.username();
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
