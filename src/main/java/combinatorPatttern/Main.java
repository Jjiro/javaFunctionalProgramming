package combinatorPatttern;

import java.time.LocalDate;

import static combinatorPatttern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Belinda Miles",
                "belinda@gmail.com",
                "37278787978",
                LocalDate.of(2005, 1,2)
        );

        //System.out.println(new CustomerValidatorService().isValid(customer));
        /**CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        customerValidatorService.isValid(customer); */

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }


    }
}
