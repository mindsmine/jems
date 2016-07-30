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

public class FloatHelperTest {

    @Test
    public void getNullSafeTest() {
        Float var1 = null;
        Float var2 = 2.0f;
        float var3 = 2.0f;

        assertEquals(Float.MIN_VALUE, FloatHelper.getNullSafe(var1), 0.0f);
        assertEquals(2.0f, FloatHelper.getNullSafe(var2), 0.0f);
        assertEquals(2.0f, FloatHelper.getNullSafe(var3), 0.0f);
    }
}
