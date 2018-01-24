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

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.ExpectedException;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberHelperTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

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
        assertTrue(NumberHelper.isPerfectSquare(0));
        assertTrue(NumberHelper.isPerfectSquare(1));
        assertTrue(NumberHelper.isPerfectSquare(81));
        assertTrue(NumberHelper.isPerfectSquare(100));

        assertFalse(NumberHelper.isPerfectSquare(5));
        assertFalse(NumberHelper.isPerfectSquare(101));
        assertFalse(NumberHelper.isPerfectSquare(250));
    }

    @Test
    public void getNumOfDigitsTest() {
        assertEquals(1, NumberHelper.getNumOfDigits(0));
        assertEquals(1, NumberHelper.getNumOfDigits(2));
        assertEquals(2, NumberHelper.getNumOfDigits(10));
        assertEquals(2, NumberHelper.getNumOfDigits(-10));
    }

    @Test
    public void getUniqueRandomNumbersNegativeNumberExceptionTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negative number is not allowed as an argument.");
        NumberHelper.getUniqueRandomNumbers(-1, -1);
        NumberHelper.getUniqueRandomNumbers(-1, arraySize);
        NumberHelper.getUniqueRandomNumbers(upperBound, -1);
        NumberHelper.getUniqueRandomNumbers(-1, -1, -1);
        NumberHelper.getUniqueRandomNumbers(-1, upperBound, -1);
        NumberHelper.getUniqueRandomNumbers(-1, upperBound, arraySize);
        NumberHelper.getUniqueRandomNumbers(lowerBound, -1, arraySize);
    }

    @Test
    public void getUniqueRandomNumbersLowerToUpperExceptionTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Lower Bound cannot be larger than Upper Bound.");
        NumberHelper.getUniqueRandomNumbers(upperBound, lowerBound, arraySize);
    }

    @Test
    public void getUniqueRandomNumbersNotEnoughNumbersExceptionTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Not enough unique numbers available for the array size.");
        NumberHelper.getUniqueRandomNumbers(lowerBound, arraySize, upperBound);
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
