package ua.kpi.lab4;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Utility class demonstrating the use of Java Generics and Wildcards.
 */
public class GenericUtils {

    /**
     * A generic method that finds the first element in a list matching a given condition.
     * <T> - The type parameter, making this method applicable to any object type.
     * @param list The source list to search through.
     * @param filter A functional interface (Predicate) defining the search criteria.
     * @return An Optional containing the found element, or an empty Optional if no match is found.
     */
    public static <T> Optional<T> findFirst(List<T> list, Predicate<T> filter) {
        for (T item : list) {
            // Check if the current item matches the predicate logic
            if (filter.test(item)) {
                return Optional.of(item);
            }
        }
        // Returns an empty container if the loop finishes without a match
        return Optional.empty();
    }

    /**
     * Demonstrates the use of an Unbounded Wildcard (?).
     * This method can accept a List of any type (List<String>, List<Integer>, etc.).
     * Use this when the method logic only depends on methods provided by the List interface
     * or the Object class (like .size() or .isEmpty()).
     * @param list A list of unknown type.
     */
    public static void printListSize(List<?> list) {
        System.out.println("The list contains " + list.size() + " elements.");
    }
}