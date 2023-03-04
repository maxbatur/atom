package ru.atom;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * In this assignment you need to implement the following util methods.
 * Note:
 *  throw new UnsupportedOperationException(); - is just a stub
 */
public class Util {



    /**
     * Returns the greatest of {@code int} values.
     *
     * @param values an argument. Assume values.length > 0.
     * @return the largest of values.
     */
    public static int max(int[] values) {
        int maxValue = Arrays.stream(values).max().getAsInt();
        return maxValue;
        //throw new UnsupportedOperationException();
    }

    /**
     * Returns the sum of all {@code int} values.
     *
     * @param values an argument. Assume values.length > 0.
     * @return the sum of all values.
     */
    public static long sum(int[] values) {
        long sumValues = Arrays.stream(values).asLongStream().sum();
        return sumValues;
        //throw new UnsupportedOperationException();
    }


}
