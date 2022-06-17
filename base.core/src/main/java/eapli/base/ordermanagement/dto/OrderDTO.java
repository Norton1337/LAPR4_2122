package eapli.base.ordermanagement.dto;

import eapli.base.ordermanagement.domain.*;
import eapli.base.warehouses.domain.agvDocks.AgvDocks;
import eapli.base.warehouses.domain.aisles.Aisles;

import java.time.LocalDateTime;
import java.util.List;


public class OrderDTO {

    public Long orderID;
    public String orderBillingAddress;
    public String orderLocation;
    public Double orderTotalAmount;
    public String orderPostalAddress;
    public LocalDateTime orderDateTime;

    public PossibleStates orderState;

    public Double orderWeight;


    public OrderDTO(Long orderID, String orderBillingAddress, String orderLocation, Double orderTotalAmount,
                         String orderPostalAddress, LocalDateTime orderDateTime, PossibleStates orderState){
        this.orderID = orderID;
        this.orderBillingAddress = orderBillingAddress;
        this.orderLocation = orderLocation;
        this.orderTotalAmount = orderTotalAmount;
        this.orderPostalAddress = orderPostalAddress;
        this.orderDateTime = orderDateTime;
        this.orderWeight = orderWeight;
    }


}
