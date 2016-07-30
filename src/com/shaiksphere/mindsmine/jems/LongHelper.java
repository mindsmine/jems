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
 * A collection of useful static methods to deal with long.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class LongHelper {
    private LongHelper() {}

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
     *      Long num3 = LongHelper.getNullSafe(num1);
     *
     *      Long num4 = LongHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -2^63
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Long#MIN_VALUE}.
     *
     * @since 1.0
     *
     */
    public static Long getNullSafe(Long value) {
        return (value == null) ? Long.MIN_VALUE : value;
    }
}
