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
 * A collection of useful static methods to deal with objects.
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class ObjectHelper {
    private ObjectHelper() {}

    /**
     * Returns <code>true</code> if the passed values are equal, false otherwise.
     * <br><br>
     * Two objects are considered equal if,
     * <ul>
     *     <li>Both objects are <code>null</code>.</li>
     *     <li>The result of {@link Object#equals(Object)} is true.</li>
     * </ul>
     *
     * @see java.lang.Object#equals(Object)
     *
     * @param object1 to compare
     * @param object2 to compare
     *
     * @return whether two objects are equal
     *
     * @since 1.0
     *
     */
    public static boolean areEqual(Object object1, Object object2) {
        return object1 == null && object2 == null || !(object1 == null || object2 == null) && object1.equals(object2);
    }
}
