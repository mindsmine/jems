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
 * A collection of useful static methods to deal with booleans.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class BooleanHelper {
    private BooleanHelper() {}

    /**
     * Returns a non-null boolean, even if the object being passed is a null boolean.
     * <br><br>
     * If the passed-in object is a non-null boolean, then it is returned as-is.
     * <br><br>
     * Example usage:
     * <pre>
     *      Boolean bool1 = true;
     *      Boolean bool2 = null;
     *
     *      Boolean bool3 = BooleanHelper.getNullSafe(bool1);
     *
     *      Boolean bool4 = BooleanHelper.getNullSafe(bool2);
     *
     *      // bool3 now contains the boolean: true
     *      // bool4 now contains the boolean: false
     * </pre>
     *
     * @param bool The boolean to safeguard against <code>null</code>.
     *
     * @return If bool is <code>null</code> then <code>Boolean.FALSE</code>.
     *
     * @since 1.0
     *
     */
    public static Boolean getNullSafe(Boolean bool) {
        return (bool == null) ? Boolean.FALSE : bool;
    }
}
