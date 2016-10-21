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

public class NumberHelperTest {

    @Test
    public void getShortNullSafeTest() {
        Short var1 = null;
        Short var2 = 2;
        Short var3 = 2;

        assertEquals(Short.valueOf(Short.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Short.valueOf("2"), NumberHelper.getNullSafe(var2));
        assertEquals(Short.valueOf("2"), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void getLongNullSafeTest() {
        Long var1 = null;
        Long var2 = 2L;
        long var3 = 2L;

        assertEquals(Long.valueOf(Long.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Long.valueOf(2L), NumberHelper.getNullSafe(var2));
        assertEquals(Long.valueOf(2L), NumberHelper.getNullSafe(var3));
    }

    @Test
    public void getFloatNullSafeTest() {
        Float var1 = null;
        Float var2 = 2.0f;
        float var3 = 2.0f;

        assertEquals(Float.MIN_VALUE, NumberHelper.getNullSafe(var1), 0.0f);
        assertEquals(2.0f, NumberHelper.getNullSafe(var2), 0.0f);
        assertEquals(2.0f, NumberHelper.getNullSafe(var3), 0.0f);
    }

    @Test
    public void getIntegerNullSafeTest() {
        Integer var1 = null;
        Integer var2 = 2;
        int var3 = 2;

        assertEquals(Integer.valueOf(Integer.MIN_VALUE), NumberHelper.getNullSafe(var1));
        assertEquals(Integer.valueOf(2), NumberHelper.getNullSafe(var2));
        assertEquals(Integer.valueOf(2), NumberHelper.getNullSafe(var3));
    }
}
