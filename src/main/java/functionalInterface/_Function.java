package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    /*
    Represents a function that accepts one argument and produces a result.
    This is a functional interface whose functional method is apply(Object).
    */

    public static void main(String[] args) {
        // Function takes 1 argument, produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        //apply - applies this function to the given argument
        //andThen - returns a function that first applies this function to its input, and then applies the after function to the result
        //compose - returns a function that first applies the before function to its input, and then applies this function to the result
        //identity - returns a function that always returns its input argument
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(3));

        // BiFunction takes 2 arguments, produces 1 result
        System.out.println(incrementByOneAndMultiply(4, 100));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
        return (number + 1) * numToMultiplyBy;
    }
}
