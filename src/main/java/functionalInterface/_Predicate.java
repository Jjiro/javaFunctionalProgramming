package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    /*
    Represents a predicate (boolean-valued function) of one argument.
    This is a functional interface whose functional method is test(Object).
    */

    public static void main(String[] args) {

        System.out.println("...Without predicate");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("3700000000"));
        System.out.println(isPhoneNumberValid("37209877300"));
        System.out.println(isPhoneNumberValid("3279877300"));

        System.out.println("...With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("3700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("37209877300"));
        System.out.println(isPhoneNumberValidPredicate.test("327987730044"));

        //use 'and' to combine predicates
        //use 'or' to check predicates
        System.out.println("Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("09009877300")
        );

        System.out.println("Is phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("07000033000")
        );

    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("372") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("372")
            && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");

    /*static BiPredicate<String, String> isPhoneNumberValidBiPredicate =
            (phoneNumber, isPhoneNumberValid) -> System.out.println(phoneNumber.startsWith("372") + isPhoneNumberValid("86490713973"));*/

}
