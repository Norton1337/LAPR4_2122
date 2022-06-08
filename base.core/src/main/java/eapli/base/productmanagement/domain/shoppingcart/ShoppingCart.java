package eapli.base.productmanagement.domain.shoppingcart;

import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.productmanagement.domain.product.Product;
import eapli.framework.domain.model.ValueObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart implements ValueObject {
    @Id
    @GeneratedValue
    private Long shoppingCartID;

    @OneToMany
    private List<CartItem> cartContent;

    public ShoppingCart(){
        this.cartContent= new ArrayList<>();
    }

    public void addProductToCart(Product product, Integer amount){
        cartContent.add(new CartItem(product,amount));
    }

    public List<CartItem> getCartContent(){
        return this.cartContent;
    }

}
