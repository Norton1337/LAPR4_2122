package eapli.base.app.backoffice.console.presentation;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.base.productmanagement.application.ProductController;


public class SpecifyProductUI {

    private final ProductController specifyProduct = new ProductController();

    protected boolean doShow(){

        final String productCode = Console.readLine("Product Code");
        final String barCode = Console.readLine("Bar Code");
        final String reference = Console.readLine("Reference");
        final String brandName = Console.readLine("Brand Name");
        final String shortDescription = Console.readLine("Short Description");
        final String technicalDescription = Console.readLine("Technical Description");
        final String extendedDescription = Console.readLine("Extended Description");

        try {

            this.specifyProduct.specifyProduct(productCode, barCode, reference, brandName, shortDescription,
                    technicalDescription, extendedDescription);
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e){
            System.out.println("You've entered an invalid Product");
        }
        return false;
    }

    public String headline(){return "Specify Product";}
}
