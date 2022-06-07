package eapli.base.app.backoffice.console.presentation;

import eapli.base.categorymanagment.application.CategoryController;
import eapli.base.categorymanagment.domain.Category;
import eapli.base.categorymanagment.domain.CategoryDescription;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;


public class DefineCategoryUI {

    private final CategoryController defineCategory = new CategoryController();

    protected boolean doShow(){

        final String description = Console.readLine("Description");

        try {
            this.defineCategory.defineCategory(new Category("",new CategoryDescription(description)));
        }catch (@SuppressWarnings("unused") final IntegrityViolationException e){

            System.out.println("You've entered invalid category description");
        }
        return false;
    }

    public String headline(){
        return "Define Category";
    }
}
