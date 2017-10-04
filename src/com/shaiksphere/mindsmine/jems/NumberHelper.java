/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.mindsmine.jems;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A collection of useful static methods to deal with numbers.
 *
 * The abstract class {@link Number} is the superclass of platform classes representing numeric values that are
 * convertible to the primitive types <code>byte</code>, <code>double</code>, <code>float</code>, <code>int</code>,
 * <code>long</code>, and <code>short</code>.
 *
 * @see Number
 * @see Byte
 * @see Double
 * @see Float
 * @see Integer
 * @see Long
 * @see Short
 *
 * @author Mohammed Shaik Hussain Ali
 * 
 * @since 2.0.0
 * 
 */
public final class NumberHelper {
    private NumberHelper() {}

    /**
     * Returns a non-null byte, even if the object being passed is a null byte.
     * <br><br>
     * If the passed-in object is a non-null byte, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Byte num1 = 10;
     *      Byte num2 = null;
     *
     *      Byte num3 = NumberHelper.getNullSafe(num1);
     *
     *      Byte num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -128.
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Byte#MIN_VALUE}.
     *
     * @since 3.0.0
     *
     */
    public static Byte getNullSafe(Byte value) {
        return (value == null) ? Byte.MIN_VALUE : value;
    }

    /**
     * Returns a non-null short, even if the object being passed is a null short.
     * <br><br>
     * If the passed-in object is a non-null short, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Short num1 = 10;
     *      Short num2 = null;
     *
     *      Short num3 = NumberHelper.getNullSafe(num1);
     *
     *      Short num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -2^15.
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Short#MIN_VALUE}.
     *
     * @since 2.0.0
     *
     */
    public static Short getNullSafe(Short value) {
        return (value == null) ? Short.MIN_VALUE : value;
    }

    /**
     * Returns a non-null long, even if the object being passed is a null long.
     * <br><br>
     * If the passed-in object is a non-null long, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Long num1 = 10;
     *      Long num2 = null;
     *
     *      Long num3 = NumberHelper.getNullSafe(num1);
     *
     *      Long num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -2^63
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Long#MIN_VALUE}.
     *
     * @since 2.0.0
     *
     */
    public static Long getNullSafe(Long value) {
        return (value == null) ? Long.MIN_VALUE : value;
    }

    /**
     * Returns a non-null float, even if the object being passed is a null float.
     * <br><br>
     * If the passed-in object is a non-null float, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Float num1 = 10.0f;
     *      Float num2 = null;
     *
     *      Float num3 = NumberHelper.getNullSafe(num1);
     *
     *      Float num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: 2^-149
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Float#MIN_VALUE}.
     *
     * @since 2.0.0
     *
     */
    public static Float getNullSafe(Float value) {
        return (value == null) ? Float.MIN_VALUE : value;
    }

    /**
     * Returns a non-null double, even if the object being passed is a null double.
     * <br><br>
     * If the passed-in object is a non-null double, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Double num1 = 10.0d;
     *      Double num2 = null;
     *
     *      Double num3 = NumberHelper.getNullSafe(num1);
     *
     *      Double num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: 2^-149
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Double#MIN_VALUE}.
     *
     * @since 3.0.0
     *
     */
    public static Double getNullSafe(Double value) {
        return (value == null) ? Double.MIN_VALUE : value;
    }

    /**
     * Returns a non-null integer, even if the object being passed is a null integer.
     * <br><br>
     * If the passed-in object is a non-null integer, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Integer num1 = 10;
     *      Integer num2 = null;
     *
     *      Integer num3 = NumberHelper.getNullSafe(num1);
     *
     *      Integer num4 = NumberHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -2^31
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Integer#MIN_VALUE}.
     *
     * @since 1.0
     *
     */
    public static Integer getNullSafe(Integer value) {
        return (value == null) ? Integer.MIN_VALUE : value;
    }


    public static boolean isPerfectSquare(Byte value) {
        return isPerfectSquare(getNullSafe(value).longValue());
    }

    public static boolean isPerfectSquare(Short value) {
        return isPerfectSquare(getNullSafe(value).longValue());
    }

    public static boolean isPerfectSquare(Integer value) {
        return isPerfectSquare(getNullSafe(value).longValue());
    }

    public static boolean isPerfectSquare(Long value) {
        if (getNullSafe(value) < 0) {
            return false;
        }

        long sqrt = (long)Math.sqrt(value);

        return Math.pow(sqrt, 2) == value;
    }

    /**
     * Returns an array of pseudorandom int values between zero (inclusive) and the specified upper bound (exclusive).
     * <br><br>
     * Convenience method equivalent to <code>NumberHelper.getUniqueRandomNumbers(0, upperBound, arraySize)</code>
     *
     * @see NumberHelper#getUniqueRandomNumbers(int, int, int)
     *
     * @param bound the upper bound (exclusive)
     * @param arraySize the number of unique random numbers expected
     *
     * @return an <code>Integer</code> array of pseudorandom int values between zero (inclusive) and the upper bound
     * (exclusive).
     *
     * @throws IllegalArgumentException if any of the arguments are negative integers
     *
     * @throws IllegalArgumentException if lower bound is greater than or equal to upper bound
     *
     * @since 2.1.0
     *
     */
    public static int[] getUniqueRandomNumbers(int bound, int arraySize) {
        return getUniqueRandomNumbers(0, bound, arraySize);
    }

    /**
     * Returns an array of pseudorandom int values between the specified lower bound (inclusive) and the specified upper
     * bound (exclusive).
     *
     * @see ThreadLocalRandom#nextInt(int, int)
     * @see HashSet#stream()
     * @see java.util.stream.Stream#mapToInt(java.util.function.ToIntFunction)
     *
     * @param lowerBound the least value returned
     * @param upperBound the upper bound (exclusive)
     * @param arraySize the number of unique random numbers expected
     *
     * @return an <code>Integer</code> array of pseudorandom int values between the lower bound (inclusive) and the
     * upper bound (exclusive).
     *
     * @throws IllegalArgumentException if any of the arguments are negative integers
     *
     * @throws IllegalArgumentException if lower bound is greater than or equal to upper bound
     *
     * @since 2.1.0
     *
     */
    public static int[] getUniqueRandomNumbers(int lowerBound, int upperBound, int arraySize) {
        if (lowerBound < 0 || upperBound < 0 || arraySize < 0) {
            throw new IllegalArgumentException("Negative number is not allowed as an argument.");
        }

        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower Bound cannot be larger than Upper Bound.");
        }

        if (arraySize > upperBound || arraySize > (upperBound - lowerBound)) {
            throw new IllegalArgumentException("Not enough unique numbers available for the array size.");
        }

        HashSet<Integer> hashSet = new HashSet<>(arraySize);

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        while (hashSet.size() < arraySize) {
            hashSet.add(threadLocalRandom.nextInt(lowerBound, upperBound));
        }

        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Returns the number of digits in the passed in number
     *
     * @param number for which to count the number of digits in
     *
     * @return number of digits
     *
     * @since 2.1.0
     *
     */
    public static int getNumOfDigits(int number) {
        if (number == 0) {
            return 1;
        }

        return (int)Math.log10(Math.abs(number)) + 1;
    }
}
