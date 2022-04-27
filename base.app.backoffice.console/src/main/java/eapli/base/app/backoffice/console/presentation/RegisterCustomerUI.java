package eapli.base.app.backoffice.console.presentation;

import eapli.base.customermanagement.application.RegisterCustomerController;
import eapli.base.customermanagement.domain.Customer;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;


public class RegisterCustomerUI {

        private final RegisterCustomerController theController = new RegisterCustomerController();

        protected boolean doShow() {

            final String name = Console.readLine("Name");
            final String address = Console.readLine("Address");
            final String vat = Console.readLine("VAT");
            final String phone = Console.readLine("Phone");
            final String birth = Console.readLine("Birthdate (dd-mm-yy)");

           // final Customer customer = new Customer();
            try {
                this.theController.registerCustomer(name, address, vat, phone, birth);
            } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
                System.out.println("You tried to enter an invalid Customer.");
            }

            return false;
        }

        public String headline() {
            return "Register Customer";
        }
}



