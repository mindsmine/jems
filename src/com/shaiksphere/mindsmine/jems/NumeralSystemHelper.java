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
 * @see <a href="https://en.wikipedia.org/wiki/Numeral_system">Numeral System (Wikipedia)</a>
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 3.1.0
 *
 */
final public class NumeralSystemHelper {
    private NumeralSystemHelper() {}

    public static String convertDecimalToHexadecimal(int integer) {
        return Integer.toHexString(integer);
    }

    public static String convertDecimalToBinary(int integer) {
        return Integer.toBinaryString(integer);
    }

    public static String convertDecimalToOctal(int integer) {
        return Integer.toOctalString(integer);
    }

    public static String convertBinaryToHexadecimal(String binaryStr) {
        return Integer.toHexString(Integer.parseInt(binaryStr, 2));
    }

    public static String convertBinaryToOctal(String binaryStr) {
        return Integer.toOctalString(Integer.parseInt(binaryStr, 2));
    }

    public static String convertBinaryToDecimal(String binaryStr) {
        return Integer.toString(Integer.parseInt(binaryStr, 2));
    }

    public static String convertHexadecimalToBinary(String hexStr) {
        return Integer.toBinaryString(Integer.parseInt(hexStr, 16));
    }

    public static String convertHexadecimalToOctal(String hexStr) {
        return Integer.toOctalString(Integer.parseInt(hexStr, 16));
    }

    public static String convertHexadecimalToDecimal(String hexStr) {
        return Integer.toString(Integer.parseInt(hexStr, 16));
    }

    public static String convertOctalToBinary(String octalStr) {
        return Integer.toBinaryString(Integer.parseInt(octalStr, 8));
    }

    public static String convertOctalToHexadecimal(String octalStr) {
        return Integer.toHexString(Integer.parseInt(octalStr, 8));
    }

    public static String convertOctalToDecimal(String octalStr) {
        return Integer.toString(Integer.parseInt(octalStr, 8));
    }
}
