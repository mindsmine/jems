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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortHelperTest {

    @Test
    public void getNullSafeTest() {
        Short var1 = null;
        Short var2 = 2;
        Short var3 = 2;

        assertEquals(Short.valueOf(Short.MIN_VALUE), ShortHelper.getNullSafe(var1));
        assertEquals(Short.valueOf("2"), ShortHelper.getNullSafe(var2));
        assertEquals(Short.valueOf("2"), ShortHelper.getNullSafe(var3));
    }
}
