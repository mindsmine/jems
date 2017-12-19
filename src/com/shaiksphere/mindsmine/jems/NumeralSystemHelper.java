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

/**
 * A collection of useful static methods to deal with numeral system.
 *
 * A numeral system is a writing system for expressing numbers; that is, a mathematical notation for representing
 * numbers of a given set, using digits or other symbols in a consistent manner.
 *
 * @see <a href="@WIKI_URI@/Numeral_system">Numeral System (Wikipedia)</a>
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 3.1.0
 *
 */
final public class NumeralSystemHelper {
    private NumeralSystemHelper() {}

    private static String convert(int valueStr, int to) {
        return Integer.toString(Integer.parseUnsignedInt(Integer.toString(valueStr), 10), to);
    }

    private static String convert(String valueStr, int from, int to) {
        return Integer.toString(Integer.parseUnsignedInt(valueStr, from), to);
    }

    public static String convertDecimalToHexadecimal(int integer) {
        return convert(integer, 16);
    }

    public static String convertDecimalToBinary(int integer) {
        return convert(integer, 2);
    }

    public static String convertDecimalToOctal(int integer) {
        return convert(integer, 8);
    }

    public static String convertBinaryToHexadecimal(String binaryStr) {
        return convert(binaryStr, 2, 16);
    }

    public static String convertBinaryToOctal(String binaryStr) {
        return convert(binaryStr, 2, 8);
    }

    public static String convertBinaryToDecimal(String binaryStr) {
        return convert(binaryStr, 2, 10);
    }

    public static String convertHexadecimalToBinary(String hexStr) {
        return convert(hexStr, 16, 2);
    }

    public static String convertHexadecimalToOctal(String hexStr) {
        return convert(hexStr, 16, 8);
    }

    public static String convertHexadecimalToDecimal(String hexStr) {
        return convert(hexStr, 16, 10);
    }

    public static String convertOctalToBinary(String octalStr) {
        return convert(octalStr, 8, 2);
    }

    public static String convertOctalToHexadecimal(String octalStr) {
        return convert(octalStr, 8, 16);
    }

    public static String convertOctalToDecimal(String octalStr) {
        return convert(octalStr, 8, 10);
    }
}
