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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

final public class NumeralSystemHelperTest {
    final private int integer = 10;
    final private String decimalStr = "10";
    final private String hexStr = "A";
    final private String octStr = "12";
    final private String binaryStr = "1010";

    @Test
    public void convertDecimalToHexadecimalTest() {
        assertTrue(NumeralSystemHelper.convertDecimalToHexadecimal(integer).equalsIgnoreCase(hexStr));
    }

    @Test
    public void convertDecimalToBinaryTest() {
        assertEquals(NumeralSystemHelper.convertDecimalToBinary(integer), binaryStr);
    }

    @Test
    public void convertDecimalToOctalTest() {
        assertEquals(NumeralSystemHelper.convertDecimalToOctal(integer), octStr);
    }

    @Test
    public void convertBinaryToHexadecimalTest() {
        assertTrue(NumeralSystemHelper.convertBinaryToHexadecimal(binaryStr).equalsIgnoreCase(hexStr));
    }

    @Test
    public void convertBinaryToOctalTest() {
        assertEquals(NumeralSystemHelper.convertBinaryToOctal(binaryStr), octStr);
    }

    @Test
    public void convertBinaryToDecimalTest() {
        assertEquals(NumeralSystemHelper.convertBinaryToDecimal(binaryStr), decimalStr);
    }

    @Test
    public void convertHexadecimalToBinaryTest() {
        assertEquals(NumeralSystemHelper.convertHexadecimalToBinary(hexStr), binaryStr);
    }

    @Test
    public void convertHexadecimalToOctalTest() {
        assertEquals(NumeralSystemHelper.convertHexadecimalToOctal(hexStr), octStr);
    }

    @Test
    public void convertHexadecimalToDecimalTest() {
        assertEquals(NumeralSystemHelper.convertHexadecimalToDecimal(hexStr), decimalStr);
    }

    @Test
    public void convertOctalToBinaryTest() {
        assertEquals(NumeralSystemHelper.convertOctalToBinary(octStr), binaryStr);
    }

    @Test
    public void convertOctalToHexadecimalTest() {
        assertTrue(NumeralSystemHelper.convertOctalToHexadecimal(octStr).equalsIgnoreCase(hexStr));
    }

    @Test
    public void convertOctalToDecimalTest() {
        assertEquals(NumeralSystemHelper.convertOctalToDecimal(octStr), decimalStr);
    }
}
