package streams;

import imperative.Main;
import jdk.jshell.spi.SPIResolutionException;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import static streams._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Jones", MALE),
                new Person("Mike", MALE),
                new Person("Alice", FEMALE),
                new Person("Edwin", GENDER_NEUTRAL)
        );

        System.out.println("...Convert String to length");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println); // .forEach(name -> System.out.println(name)); - lambda method reference replacement '::'

        System.out.println("...Printing names");
        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("...Printing genders");
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        //code below is same as code above, below is extracted to variable...Shift+Command+V, Shift+CommandN to return to inline variable
        /*
        Function<Person,  String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = x -> System.out.println(x);

        people.stream().map(personStringFunction).mapToInt(length).forEach(println); */


        //Check if the list contains only FEMALES
        System.out.println("...Checking if gender is female only");
         boolean containsOnlyfemale = people.stream().allMatch(person -> FEMALE.equals(person.gender)); //allMatch, anyMatch, noneMatch
        System.out.println(containsOnlyfemale);




    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, GENDER_NEUTRAL
    }
}
