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
 * A collection of useful static methods to deal with short.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class ShortHelper {
    private ShortHelper() {}

    /**
     * Returns a non-null short, even if the object being passed is a null short.
     * <br><br>
     * If the passed-in object is a non-null short, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Short num1 = 10;
     *      Short num2 = null;
     *
     *      Short num3 = ShortHelper.getNullSafe(num1);
     *
     *      Short num4 = ShortHelper.getNullSafe(num2);
     *
     *      // num3 now contains the number: 10
     *      // num4 now contains the number: -2^15.
     * </pre>
     *
     * @param value The number to safeguard against <code>null</code>.
     *
     * @return If value is <code>null</code> then {@link Short#MIN_VALUE}.
     *
     * @since 1.0
     *
     */
    public static Short getNullSafe(Short value) {
        return (value == null) ? Short.MIN_VALUE : value;
    }
}
