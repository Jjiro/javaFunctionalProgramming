package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    /*
    Represents a supplier of results. There is no requirement that a new or distinct result be returned each time the supplier is invoked.
    This is a functional interface whose functional method is get().
    */

    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlsSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc:mysql://user.chcsf7pbopuv.eu-west-2.rds.amazonaws.com/users";
    }

    //functionally
    static Supplier<List<String>> getDBConnectionUrlsSupplier = ()
            -> List.of(
            "jdbc:mysql://user.chcsf7pbopuv.eu-west-2.rds.amazonaws.com/users",
            "jdbc:mysql://user.chcsf7pbopuv.eu-west-2.rds.amazonaws.com/customers",
            "jdbc:mysql://user.chcsf7pbopuv.eu-west-2.rds.amazonaws.com/products",
            "jdbc:mysql://user.chcsf7pbopuv.eu-west-2.rds.amazonaws.com/suppliers");

}
