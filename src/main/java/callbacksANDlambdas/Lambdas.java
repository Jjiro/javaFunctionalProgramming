package callbacksANDlambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Integer number = null;
        int counter = 0;

        Function<String, String> upperCaseName = name -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty!");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> lowerCaseName = (name, age) -> {
            int counters = 0;
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be empty!");
            System.out.println(age);
            return name.toLowerCase();
        };

        System.out.println(upperCaseName.apply("Andrew"));
        System.out.println(lowerCaseName.apply("Mandy", null));

    }

}
