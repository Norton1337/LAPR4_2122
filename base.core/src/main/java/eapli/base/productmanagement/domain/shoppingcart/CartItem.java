package eapli.base.productmanagement.domain.shoppingcart;

import eapli.base.productmanagement.domain.product.Product;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "product_internal_code")
    private Product product;
    private Integer amount;

    @ManyToOne
    private ShoppingCart shoppingCart;

    public CartItem(Product product, Integer amount){
        this.product = product;
        this.amount = amount;
    }

    public CartItem() {

    }

    public Integer amount(){
        return this.amount;
    }
    public Product product(){
        return this.product;
    }

}
