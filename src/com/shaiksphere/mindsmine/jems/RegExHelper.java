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
 * A collection of useful static methods to deal with regular expressions.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class RegExHelper {
    private RegExHelper() {}

    /**
     * Represents the most generic regex pattern for the Longitude.
     *
     * @since 1.0
     *
     */
    public static final String LONGITUDE = "(^\\+?1[0-7]\\d(\\.\\d+)?$)|(^\\+?([1-9])?\\d(\\.\\d+)?$)|(^-180$)|(^-1[1-7]\\d(\\.\\d+)?$)|(^-[1-9]\\d(\\.\\d+)?$)|(^\\-\\d(\\.\\d+)?$)";

    /**
     * Represents the most generic regex pattern for the Latitude.
     *
     * @since 1.0
     *
     */
    public static final String LATITUDE = "(^\\+?([1-8])?\\d(\\.\\d+)?$)|(^-90$)|(^-(([1-8])?\\d(\\.\\d+)?$))";

    /**
     * Represents a stricter version of the United States (US) phone number.
     * <br><br>
     * Format: (###) ###-####
     * <br><br>
     * Only valid phone numbers are taken into consideration.
     *
     * @see <a href="http://en.wikipedia.org/wiki/Telephone_number">Telephone Number (Wikipedia)</a>
     *
     * @since 1.0
     *
     */
    public static final String US_PHONE_NUMBER = "\\(([2-9][0-9][0-9])\\) ([2-9][0-9]{2})-([0-9]{4})";

    /**
     * Represents the most general form of 24-hour time display format.
     * <br><br>
     * Format: ##:##
     * <br><br>
     * Valid: 00:00 to 23:59
     *
     * @since 1.0
     *
     */
    public static final String TIME_DISPLAY = "(([0-1]*[0-9]|[2][0-3]):([0-5][0-9]))";
}
