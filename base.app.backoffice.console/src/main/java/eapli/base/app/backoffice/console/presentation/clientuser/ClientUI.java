package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.productmanagement.application.ProductController;
import eapli.base.productmanagement.domain.product.Product;
import eapli.base.productmanagement.domain.shoppingcart.ShoppingCart;
import eapli.framework.io.util.Console;

import java.util.List;

public class ClientUI {

    ProductController productController = new ProductController();
    public ClientUI(){}

    public boolean show() {
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("[1] - Show Available Products");
        System.out.println("[2] - Search Product");
        System.out.println("[0] - Cancel");
        int option = Console.readInteger("Choose option");
        if(option<0 || option >2){
            System.out.println("Invalid option");
            return false;
        }
        switch (option){
            case 1:
                List<Product> products1 = productController.getAllProducts();
                showProducts(products1, shoppingCart);
                break;
            case 2:
                String search = Console.readNonEmptyLine("What do you want to search for: ", "Can't be empty");
                List<Product> products2 = productController.getAllProducts(search);
                showProducts(products2, shoppingCart);
                break;
            case 0:
                break;
        }

        return false;
    }

    public void showProducts(List<Product> products, ShoppingCart shoppingCart){
        int option=0;
        while(option>=0) {
            int i = 0;
            for (Product product : products) {
                System.out.println("[" + i + "] Name:" + product.productCode().getProductCode() + " | Cost:" + product.productPrice().getPrice() + "€");
                i++;
            }
            option = Console.readInteger("Choose product to add to cart (-1 to exit)");
            if (option < 0 || option >= products.size()) {
                if(option==-1)
                    break;
                System.out.println("Invalid option");
            } else {
                int amount = Console.readInteger("How many?");
                shoppingCart.addProductToCart(products.get(option), amount);
                int option2 = Console.readInteger("Do you wish to add more items?\n[0] - No\n[1] - Yes");
                if(option2==0){
                    finalizeCart(shoppingCart);
                    break;
                }else if(option2!=1){
                    System.out.println("Invalid option, continuing anyway");
                }

            }

        }
    }

    public void finalizeCart(ShoppingCart shoppingCart){

    }

}
