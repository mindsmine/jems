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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObjectHelperTest {

    @Test
    public void areEqualTest() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = obj2;

        assertFalse(ObjectHelper.areEqual(obj1, obj2));
        assertTrue(ObjectHelper.areEqual(obj2, obj3));
    }
}
