package callbacksANDlambdas;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {

        hola("John", null, value -> {
            System.out.println("No lastName provided for " + value);
        });

        hola2("John", null, () -> System.out.println("No lastName provided"));

    }

    static void hola(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hola2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }

    //JavaScript Callback
    /**function hola(firstName, lastName, callback) {
        console.log(firstName);
        if (lastName) {
            console.log(lastName)
        } else {
            callback();
        }
    }**/
}
