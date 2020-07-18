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

import org.junit.Test;

import org.junit.function.ThrowingRunnable;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class NumberHelperTest {

    @Test
    public void getByteNullSafeTest() {
        Byte var1 = null;
        Byte var2 = 2;
        byte var3 = 2;

        assertEquals(Byte.valueOf(Byte.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Byte.valueOf("2"), NumberHelper.getNullSafe(var2));
        assertEquals(Byte.valueOf("2"), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void getShortNullSafeTest() {
        Short var1 = null;
        Short var2 = 2;
        short var3 = 2;

        assertEquals(Short.valueOf(Short.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Short.valueOf("2"), NumberHelper.getNullSafe(var2));
        assertEquals(Short.valueOf("2"), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void getLongNullSafeTest() {
        Long var1 = null;
        Long var2 = 2L;
        long var3 = 2L;

        assertEquals(Long.valueOf(Long.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Long.valueOf(2L), NumberHelper.getNullSafe(var2));
        assertEquals(Long.valueOf(2L), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void getFloatNullSafeTest() {
        Float var1 = null;
        Float var2 = 2.0f;
        float var3 = 2.0f;

        assertEquals(Float.MIN_VALUE, NumberHelper.getNullSafe(var1), 0.0f);
        assertEquals(2.0f, NumberHelper.getNullSafe(var2), 0.0f);
        assertEquals(2.0f, NumberHelper.getNullSafe(var3), 0.0f);
    }

    @Test
    public void getDoubleNullSafeTest() {
        Double var1 = null;
        Double var2 = 2.0d;
        double var3 = 2.0d;

        assertEquals(Double.MIN_VALUE, NumberHelper.getNullSafe(var1), 0.0d);
        assertEquals(2.0d, NumberHelper.getNullSafe(var2), 0.0d);
        assertEquals(2.0d, NumberHelper.getNullSafe(var3), 0.0d);
    }

    @Test
    public void getIntegerNullSafeTest() {
        Integer var1 = null;
        Integer var2 = 2;
        int var3 = 2;

        assertEquals(Integer.valueOf(Integer.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Integer.valueOf(2), NumberHelper.getNullSafe(var2));
        assertEquals(Integer.valueOf(2), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void isPerfectSquareTest() {
        Arrays.asList(
                0,
                1,
                81,
                100
        ).forEach(num -> assertTrue(NumberHelper.isPerfectSquare(num)));

        Arrays.asList(
                5,
                101,
                250
        ).forEach(num -> assertFalse(NumberHelper.isPerfectSquare(num)));
    }

    @Test
    public void getNumOfDigitsTest() {
        Arrays.asList(
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{2, 10},
                new int[]{2, -10}
        ).forEach(arr -> assertEquals(arr[0], NumberHelper.getNumOfDigits(arr[1])));
    }

    @Test
    public void getUniqueRandomNumbersNegativeNumberExceptionTest() {
        final String errorMessage = "Negative number is not allowed as an argument.";

        Arrays.asList(
                new int[] {-1, -1},
                new int[] {-1, arraySize},
                new int[] {upperBound, -1}
        ).forEach(arr -> assertThrows(
                errorMessage,
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        NumberHelper.getUniqueRandomNumbers(arr[0], arr[1]);
                    }
                }
        ));

        Arrays.asList(
                new int[] {-1, -1, -1},
                new int[] {-1, upperBound, -1},
                new int[] {-1, upperBound, arraySize},
                new int[] {lowerBound, -1, arraySize}
        ).forEach(arr -> assertThrows(
                errorMessage,
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        NumberHelper.getUniqueRandomNumbers(arr[0], arr[1], arr[2]);
                    }
                }
        ));
    }

    @Test
    public void getUniqueRandomNumbersLowerToUpperExceptionTest() {
        assertThrows(
                "Lower Bound cannot be larger than Upper Bound.",
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        NumberHelper.getUniqueRandomNumbers(upperBound, lowerBound, arraySize);
                    }
                }
        );
    }

    @Test
    public void getUniqueRandomNumbersNotEnoughNumbersExceptionTest() {
        assertThrows(
                "Not enough unique numbers available for the array size.",
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        NumberHelper.getUniqueRandomNumbers(lowerBound, arraySize, upperBound);
                    }
                }
        );
    }

    @Test
    public void getUniqueRandomNumbersTest() {
        int [] array1 = NumberHelper.getUniqueRandomNumbers(upperBound, arraySize);
        int [] array2 = NumberHelper.getUniqueRandomNumbers(lowerBound, upperBound, arraySize);

        assertEquals(arraySize, array1.length);
        assertEquals(arraySize, array2.length);

        assertTrue(areUniqueValues(array1));
        assertTrue(areUniqueValues(array2));
    }

    private final int lowerBound = 10;
    private final int upperBound = 81;
    private final int arraySize = 12;

    private boolean areUniqueValues(int [] array) {
        HashSet<Integer> hashSet = new HashSet<>(array.length);

        for (int num : array) {
            if (hashSet.contains(num)) {
                return false;
            }

            hashSet.add(num);
        }

        return true;
    }
}
