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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringHelperTest {

    @Test
    public void getNullSafeTest() {
        assertEquals("", StringHelper.getNullSafe(null));
        assertEquals("hello", StringHelper.getNullSafe("hello"));
    }

    @Test
    public void areEqualLenientTest() {
        assertTrue(StringHelper.areEqual(null, null, true));
        assertTrue(StringHelper.areEqual(null, "", true));
        assertTrue(StringHelper.areEqual("", null, true));

        assertTrue(StringHelper.areEqual("", "", true));

        assertTrue(StringHelper.areEqual("   ", "", true));
        assertTrue(StringHelper.areEqual(" abc", "abc ", true));

        assertFalse(StringHelper.areEqual("", "abc", true));
        assertFalse(StringHelper.areEqual("ab c", "abc", true));

        assertTrue(StringHelper.areEqual("ABC", "abc", true));
        assertTrue(StringHelper.areEqual("abc", "abc", true));
    }

    @Test
    public void areEqualStrictTest() {
        assertFalse(StringHelper.areEqual(null, null, false));
        assertFalse(StringHelper.areEqual(null, "", false));
        assertFalse(StringHelper.areEqual("", null, false));

        assertTrue(StringHelper.areEqual("", "", false));

        assertFalse(StringHelper.areEqual("   ", "", false));
        assertFalse(StringHelper.areEqual(" abc", "abc ", false));

        assertFalse(StringHelper.areEqual("", "abc", false));
        assertFalse(StringHelper.areEqual("ab c", "abc", false));

        assertFalse(StringHelper.areEqual("ABC", "abc", false));
        assertTrue(StringHelper.areEqual("abc", "abc", true));
    }

    @Test
    public void areEqualTest() {
        assertTrue(StringHelper.areEqual(null, null));
        assertTrue(StringHelper.areEqual(null, ""));
        assertTrue(StringHelper.areEqual("", null));

        assertTrue(StringHelper.areEqual("", ""));

        assertTrue(StringHelper.areEqual("   ", ""));
        assertTrue(StringHelper.areEqual(" abc", "abc "));

        assertFalse(StringHelper.areEqual("", "abc"));
        assertFalse(StringHelper.areEqual("ab c", "abc"));

        assertTrue(StringHelper.areEqual("ABC", "abc"));
        assertTrue(StringHelper.areEqual("abc", "abc"));
    }

    @Test
    public void isOnlyDigitsTest() {
        assertFalse(StringHelper.isOnlyDigits(null));
        assertFalse(StringHelper.isOnlyDigits(""));
        assertFalse(StringHelper.isOnlyDigits(" "));
        assertFalse(StringHelper.isOnlyDigits("something "));
        assertFalse(StringHelper.isOnlyDigits("11.67"));

        assertTrue(StringHelper.isOnlyDigits("17650"));
    }

    @Test
    public void isPalindromeLenientTest() {
        assertTrue(StringHelper.isPalindrome(null, true));
        assertTrue(StringHelper.isPalindrome("", true));
        assertTrue(StringHelper.isPalindrome("   ", true));
        assertTrue(StringHelper.isPalindrome(" aba", true));
        assertTrue(StringHelper.isPalindrome("aba", true));
        assertTrue(StringHelper.isPalindrome("mAdAm", true));
        assertTrue(StringHelper.isPalindrome("madAm", true));
        assertTrue(StringHelper.isPalindrome("madam", true));
        assertTrue(StringHelper.isPalindrome("Madam", true));
        assertFalse(StringHelper.isPalindrome("hello", true));
    }

    @Test
    public void isPalindromeStrictTest() {
        assertFalse(StringHelper.isPalindrome(null, false));
        assertTrue(StringHelper.isPalindrome("", false));
        assertTrue(StringHelper.isPalindrome("   ", false));
        assertFalse(StringHelper.isPalindrome(" aba", false));
        assertTrue(StringHelper.isPalindrome("aba", false));
        assertTrue(StringHelper.isPalindrome("mAdAm", false));
        assertFalse(StringHelper.isPalindrome("madAm", false));
        assertTrue(StringHelper.isPalindrome("madam", false));
        assertFalse(StringHelper.isPalindrome("Madam", false));
        assertFalse(StringHelper.isPalindrome("hello", false));
    }
    @Test
    public void isPalindromeTest() {
        assertTrue(StringHelper.isPalindrome(null));
        assertTrue(StringHelper.isPalindrome(""));
        assertTrue(StringHelper.isPalindrome("   "));
        assertTrue(StringHelper.isPalindrome(" aba"));
        assertTrue(StringHelper.isPalindrome("aba"));
        assertTrue(StringHelper.isPalindrome("mAdAm"));
        assertTrue(StringHelper.isPalindrome("madAm"));
        assertTrue(StringHelper.isPalindrome("madam"));
        assertTrue(StringHelper.isPalindrome("Madam"));
        assertFalse(StringHelper.isPalindrome("hello"));
    }
}
