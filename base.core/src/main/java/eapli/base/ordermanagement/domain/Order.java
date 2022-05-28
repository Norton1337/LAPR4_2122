package eapli.base.ordermanagement.domain;

import eapli.base.ordermanagement.dto.OrderDTO;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.aisles.Aisles;
import eapli.base.warehouses.domain.warehouse.*;
import eapli.base.warehouses.dto.WarehouseDTO;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Entity
public class Order implements AggregateRoot<OrderID> {
    @Id
    private Long id;
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

    public Order(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation,
                 OrderTotalAmount orderTotalAmount, OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime){

        this.orderID = orderID;
        this.orderBillingAddress = orderBillingAddress;
        this.orderLocation = orderLocation;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPostalAddress = orderPostalAddress;
        this.orderDateTime = orderDateTime;
    }

    protected Order() {

    }

    public Order(OrderDTO dto) throws IOException {
        this(
                new OrderID(dto.orderID),
                new OrderBillingAddress(dto.orderBillingAddress),
                new OrderLocation(dto.orderLocation),
                new OrderTotalAmount(dto.orderTotalAmount),
                new OrderPostalAddress(dto.orderPostalAddress),
                new OrderDateTime(dto.orderDateTime)
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
                '}';
    }

    public static Order valueOf(OrderID orderID, OrderBillingAddress orderBillingAddress, OrderLocation orderLocation,
                                OrderTotalAmount orderTotalAmount, OrderPostalAddress orderPostalAddress, OrderDateTime orderDateTime){
        return new Order(orderID, orderBillingAddress, orderLocation, orderTotalAmount, orderPostalAddress, orderDateTime);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public OrderID identity() {
        return orderID;
    }
}
