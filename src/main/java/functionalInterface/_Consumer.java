package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    /*
    Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
    This is a functional interface whose functional method is accept(Object).
    */

    public static void main(String[] args) {
        // Normal java function
        Customer nelly = new Customer("Nelly", "7940079");
        greetCustomer(nelly);
        greetCustomerV2(nelly, false);

        // Consumer Functional interface
        //accept - performs this operation on the given argument
        //andThen - returns a composed Consumer that performs, in sequence, this operation followed by the after operation.
        // If performing either operation throws an exception, it is relayed to the caller of the composed operation.
        // If performing this operation throws an exception, the after operation will not be performed
        greetCustomerConsumer.accept(nelly);

        greetCustomerConsumerV2.accept(nelly, false);
    }

    //showPhoneNumber - display number or not...
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering this phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering this phone number "
                    + customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering this phone number "
                + customer.customerPhoneNumber);
    }

    //normal java way for writing 'greetCustomer' function
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering this phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
