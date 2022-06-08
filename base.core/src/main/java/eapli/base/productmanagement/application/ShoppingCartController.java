package eapli.base.productmanagement.application;

import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.shoppingcart.CartItem;
import eapli.base.productmanagement.domain.shoppingcart.ShoppingCart;
import eapli.base.productmanagement.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCartController {
    private ShoppingCart shoppingCart;
    public ShoppingCartController(){
        shoppingCart = new ShoppingCart();
    }



    public void addToCart(Product product, Integer amount){
        this.shoppingCart.addProductToCart(product,amount);
    }


    public List<CartItem> getShoppingCart(){
        return this.shoppingCart.getCartContent();
    }

}
