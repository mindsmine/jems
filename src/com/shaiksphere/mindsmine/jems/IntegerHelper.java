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
 * A collection of useful static methods to deal with integers.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class IntegerHelper {
    private IntegerHelper() {}

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
     *      Integer num3 = IntegerHelper.getNullSafe(num1);
     *
     *      Integer num4 = IntegerHelper.getNullSafe(num2);
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
}
