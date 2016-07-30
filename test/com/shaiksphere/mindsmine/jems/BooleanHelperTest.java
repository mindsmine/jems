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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BooleanHelperTest {

    @Test
    public void getNullSafeTest() {
        Boolean var1 = null;
        Boolean var2 = true;
        boolean var3 = true;

        assertFalse(BooleanHelper.getNullSafe(var1));
        assertTrue(BooleanHelper.getNullSafe(var2));
        assertTrue(BooleanHelper.getNullSafe(var3));
    }
}
