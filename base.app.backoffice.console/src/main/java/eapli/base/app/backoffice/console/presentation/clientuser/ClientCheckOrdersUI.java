package eapli.base.app.backoffice.console.presentation.clientuser;

import eapli.base.ordermanagement.application.OrderController;
import eapli.base.ordermanagement.domain.OrderType;
import eapli.base.productmanagement.application.ProductController;
import eapli.base.productmanagement.application.ShoppingCartController;
import eapli.base.productmanagement.domain.product.Product;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.io.util.Console;

import java.util.List;

public class ClientCheckOrdersUI {

    OrderController orderController = new OrderController();
    SystemUser systemUser;
    public ClientCheckOrdersUI(SystemUser systemUser){
        this.systemUser=systemUser;
    }

    public boolean show() {
        System.out.println("[1] - Check Open Orders");
        System.out.println("[0] - Cancel");
        int option = Console.readInteger("Choose option");
        if(option<0 || option >1){
            System.out.println("Invalid option");
            return false;
        }
        switch (option){
            case 1:
                List<OrderType> orders = orderController.getClientOpenOrders(systemUser.username());
                if(orders.isEmpty())
                    System.out.println("You have no open orders");
                else{
                    for (OrderType order:orders) {
                        System.out.println(order.toString());
                    }
                }
                break;
            case 0:
                break;
        }

        return false;
    }


}
