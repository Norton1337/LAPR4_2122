package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.shoppingcart.ShoppingCart;
import org.hibernate.criterion.Order;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long orderItemID;

    @ManyToOne
    @JoinColumn(name = "PRODUCTID")
    private Product product;
    private Integer amount;
    private Double pricePerItem;
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDERID")
    private OrderType order;

    public OrderItem(Product product, Integer amount){
        this.product = product;
        this.pricePerItem=product.productPrice().getPrice();
        this.amount = amount;
        this.totalPrice=this.pricePerItem*this.amount;
    }

    public OrderItem() {

    }

    public void setOrder(OrderType order){
        this.order=order;
    }

    public Integer amount(){
        return this.amount;
    }
    public Product product(){
        return this.product;
    }
    public Double getTotalPrice(){
        return this.totalPrice;
    }

}
