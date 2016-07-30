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

public class IntegerHelperTest {

    @Test
    public void getNullSafeTest() {
        Integer var1 = null;
        Integer var2 = 2;
        int var3 = 2;

        assertEquals(Integer.valueOf(Integer.MIN_VALUE), IntegerHelper.getNullSafe(var1));
        assertEquals(Integer.valueOf(2), IntegerHelper.getNullSafe(var2));
        assertEquals(Integer.valueOf(2), IntegerHelper.getNullSafe(var3));
    }
}
