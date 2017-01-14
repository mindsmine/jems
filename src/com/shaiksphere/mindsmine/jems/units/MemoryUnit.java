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

package com.shaiksphere.mindsmine.jems.units;

/**
 * A collection of useful methods to deal with memory units.
 * <br><br>
 * The <strong>byte</strong> is a unit of digital information that most commonly consists of eight bits. Historically,
 * the byte was the number of bits used to encode a single character of text in a computer and for this reason it is the
 * smallest addressable unit of memory in many computer architectures. The international standard IEC 80000-13 codified
 * this common meaning. The popularity of major commercial computing architectures has aided in the ubiquitous acceptance
 * of the 8-bit size.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Byte">Byte (Wikipedia)</a>
 * @see <a href="https://en.wikipedia.org/wiki/IEC_80000-13">IEC 80000-13 (Wikipedia)</a>
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 2.0.0
 *
 */
public enum MemoryUnit {
    /**
     * The <strong>kibibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>KiB</strong>.
     * <br><br>
     * 1 Kibibyte = 1024 Bytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Kibibyte">Kibibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    KIBI_BYTE(1),

    /**
     * The <strong>mebibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>MiB</strong>.
     * <br><br>
     * 1 Mebibyte = 1024 Kibibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Mebibyte">Mebibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    MEBI_BYTE(2),

    /**
     * The <strong>gibibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>GiB</strong>.
     * <br><br>
     * 1 Gibibyte = 1024 Mebibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Gibibyte">Gibibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    GIBI_BYTE(3),

    /**
     * The <strong>tebibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>TiB</strong>.
     * <br><br>
     * 1 Tebibyte = 1024 Gibibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Tebibyte">Tebibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    TEBI_BYTE(4),

    /**
     * The <strong>pebibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>PiB</strong>.
     * <br><br>
     * 1 Pebibyte = 1024 Tebibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Pebibyte">Pebibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    PEBI_BYTE(5),

    /**
     * The <strong>exbibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>EiB</strong>.
     * <br><br>
     * 1 Exbibyte = 1024 Pebibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Exbibyte">Exbibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    EXBI_BYTE(6),

    /**
     * The <strong>zebibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>ZiB</strong>.
     * <br><br>
     * 1 Zebibyte = 1024 Exbibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Zebibyte">Zebibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    ZEBI_BYTE(7),

    /**
     * The <strong>yobibyte</strong> is a multiple of the unit byte for digital information. It is a member of the set
     * of units with binary prefixes defined by the International Electrotechnical Commission (IEC). Its unit symbol is
     * <strong>YiB</strong>.
     * <br><br>
     * 1 Yobibyte = 1024 Zebibytes
     *
     * @see <a href="https://en.wikipedia.org/wiki/Yobibyte">Yobibyte (Wikipedia)</a>
     *
     * @since 2.0.0
     *
     */
    YOBI_BYTE(8);

    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    private static final int CONVERSION_STANDARD = 1024;

    private final int exponentValue;
    private final double byteValue;

    MemoryUnit(int exponentValue) {
        this.exponentValue = exponentValue;
        this.byteValue = Math.pow(CONVERSION_STANDARD, exponentValue);
    }

    /**
     * Returns the number of bytes in the unit.
     *
     * @return Number of bytes in the unit.
     *
     * @since 2.0.0
     *
     */
    public double getByteValue() {
        return byteValue;
    }

    /**
     * Extracts the closest equivalent in Bytes.
     * <br><br>
     * <strong>Note</strong>: The smallest unit returned is {@link MemoryUnit#KIBI_BYTE}
     *
     * @param value for which the byte equivalent is to be extracted
     *
     * @return Closest byte equivalent of the provided number
     *
     * @throws IllegalArgumentException when a negative number is passed
     *
     * @since 2.0.0
     *
     */
    public static MemoryUnit extract(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Negative number is not allowed as an argument.");
        }

        int exponent = (int) Math.ceil(Math.log(value) / Math.log(CONVERSION_STANDARD));

        if (exponent < 1) {
            return MemoryUnit.KIBI_BYTE;
        }

        for (MemoryUnit memoryUnit : values()) {
            if (memoryUnit.exponentValue == exponent) {
                return memoryUnit;
            }
        }

        return values()[values().length - 1];
    }
}
