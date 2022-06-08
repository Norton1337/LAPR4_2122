package eapli.base.ordermanagement.domain;

import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.shoppingcart.ShoppingCart;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long orderItemID;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer amount;

    @ManyToOne
    private OrderType order;

    public OrderItem(Product product, Integer amount){
        this.product = product;
        this.amount = amount;
    }

    public OrderItem() {

    }

    public Integer amount(){
        return this.amount;
    }
    public Product product(){
        return this.product;
    }

}
