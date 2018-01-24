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

    /**
     * Returns a string representation of the first argument in the radix specified by the third argument from the radix
     * specified by the second argument.
     * <br><br>
     * If the radix is smaller than {@link Character#MIN_RADIX} or larger than {@link Character#MAX_RADIX}, then the
     * radix 10 is used instead.
     * <br><br>
     * If the first argument is negative, the first element of the result is the ASCII minus character '<code>-</code>'.
     * If the first argument is not negative, no sign character appears in the result.
     * <br><br>
     * The remaining characters of the result represent the magnitude of the first argument. If the magnitude is zero,
     * it is represented by a single zero character '<code>0</code>'; otherwise, the first character of the
     * representation of the magnitude will not be the zero character. The following ASCII characters are used as digits:
     * <code>0123456789abcdefghijklmnopqrstuvwxyz</code>
     * <br><br>
     * These are '<code>0</code>' through '<code>9</code>' and '<code>a</code>' through '<code>z</code>'. If radix is
     * <em><code>N</code></em>, then the first <em><code>N</code></em> of these characters are used as
     * radix-<em><code>N</code></em> digits in the order shown. Thus, the digits for hexadecimal (radix 16) are
     * <code>0123456789abcdef</code>. If uppercase letters are desired, the {@link String#toUpperCase()} method may be
     * called on the result.
     *
     * @param valueStr a string to be converted to the desired system.
     * @param from the radix to which the string representation is in.
     * @param to the radix to use in the string representation.
     *
     * @return a string representation of the argument in the specified radix.
     *
     * @since 3.1.0
     *
     */
    public static String convert(String valueStr, int from, int to) {
        return Integer.toString(Integer.parseUnsignedInt(valueStr, from), to);
    }

    /**
     * Returns a string representation of the first argument in the radix specified by the third argument from the radix
     * specified by the second argument.
     * <br><br>
     * Convenience method equivalent to <code>convert(Integer.toString(value), 10, to)</code>
     *
     * @see NumeralSystemHelper#convert(String, int, int)
     *
     * @param value an integer to be converted to the desired system.
     * @param to the radix to use in the string representation.
     *
     * @return a string representation of the argument in the specified radix.
     *
     * @since 3.1.0
     *
     */
    public static String convert(int value, int to) {
        return convert(Integer.toString(value), 10, to);
    }

    /**
     * Returns a string representation of the integer argument as an unsigned integer in base 16.
     *
     * @param integer an integer to be converted to a string.
     *
     * @return the string representation of the unsigned integer value represented by the argument in hexadecimal (base
     * 16).
     *
     * @since 3.1.0
     *
     */
    public static String convertDecimalToHexadecimal(int integer) {
        return convert(integer, 16);
    }

    /**
     * Returns a string representation of the integer argument as an unsigned integer in base 2.
     *
     * @param integer an integer to be converted to a string.
     *
     * @return the string representation of the unsigned integer value represented by the argument in binary (base 2).
     *
     * @since 3.1.0
     *
     */
    public static String convertDecimalToBinary(int integer) {
        return convert(integer, 2);
    }

    /**
     * Returns a string representation of the integer argument as an unsigned integer in base 8.
     *
     * @param integer an integer to be converted to a string.
     *
     * @return the string representation of the unsigned integer value represented by the argument in octal (base 8).
     *
     * @since 3.1.0
     *
     */
    public static String convertDecimalToOctal(int integer) {
        return convert(integer, 8);
    }

    /**
     * Returns a string representation of the binary value as an unsigned integer in base 16.
     *
     * @param binaryStr a binary value to be converted to a hexadecimal string.
     *
     * @return the string representation of the binary value in hexadecimal (base 16).
     *
     * @since 3.1.0
     *
     */
    public static String convertBinaryToHexadecimal(String binaryStr) {
        return convert(binaryStr, 2, 16);
    }

    /**
     * Returns a string representation of the binary value as an unsigned integer in base 8.
     *
     * @param binaryStr a binary value to be converted to an octal string.
     *
     * @return the string representation of the binary value in octal (base 8).
     *
     * @since 3.1.0
     *
     */
    public static String convertBinaryToOctal(String binaryStr) {
        return convert(binaryStr, 2, 8);
    }

    /**
     * Returns a string representation of the binary value as an unsigned integer in base 10.
     *
     * @param binaryStr a binary value to be converted to a decimal string.
     *
     * @return the string representation of the binary value in decimal (base 10).
     *
     * @since 3.1.0
     *
     */
    public static String convertBinaryToDecimal(String binaryStr) {
        return convert(binaryStr, 2, 10);
    }

    /**
     * Returns a string representation of the hexadecimal value as an unsigned integer in base 2.
     *
     * @param hexStr a hexadecimal value to be converted to a binary string.
     *
     * @return the string representation of the hexadecimal value in binary (base 2).
     *
     * @since 3.1.0
     *
     */
    public static String convertHexadecimalToBinary(String hexStr) {
        return convert(hexStr, 16, 2);
    }

    /**
     * Returns a string representation of the hexadecimal value as an unsigned integer in base 8.
     *
     * @param hexStr a hexadecimal value to be converted to an octal string.
     *
     * @return the string representation of the hexadecimal value in octal (base 8).
     *
     * @since 3.1.0
     *
     */
    public static String convertHexadecimalToOctal(String hexStr) {
        return convert(hexStr, 16, 8);
    }

    /**
     * Returns a string representation of the hexadecimal value as an unsigned integer in base 10.
     *
     * @param hexStr a hexadecimal value to be converted to a decimal string.
     *
     * @return the string representation of the hexadecimal value in decimal (base 10).
     *
     * @since 3.1.0
     *
     */
    public static String convertHexadecimalToDecimal(String hexStr) {
        return convert(hexStr, 16, 10);
    }

    /**
     * Returns a string representation of the octal value as an unsigned integer in base 2.
     *
     * @param octalStr an octal value to be converted to a binary string.
     *
     * @return the string representation of the octal value in binary (base 2).
     *
     * @since 3.1.0
     *
     */
    public static String convertOctalToBinary(String octalStr) {
        return convert(octalStr, 8, 2);
    }

    /**
     * Returns a string representation of the octal value as an unsigned integer in base 16.
     *
     * @param octalStr an octal value to be converted to a hexadecimal string.
     *
     * @return the string representation of the octal value in hexadecimal (base 16).
     *
     * @since 3.1.0
     *
     */
    public static String convertOctalToHexadecimal(String octalStr) {
        return convert(octalStr, 8, 16);
    }

    /**
     * Returns a string representation of the octal value as an unsigned integer in base 10.
     *
     * @param octalStr an octal value to be converted to a decimal string.
     *
     * @return the string representation of the octal value in decimal (base 10).
     *
     * @since 3.1.0
     *
     */
    public static String convertOctalToDecimal(String octalStr) {
        return convert(octalStr, 8, 10);
    }
}
