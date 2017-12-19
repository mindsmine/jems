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
 * A collection of useful static methods to deal with strings.
 *
 * @see java.lang.String
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class StringHelper {

    private StringHelper() {}

    /**
     * Returns a non-null string, even if the object being passed is a null string.
     * <br><br>
     * If the passed-in object is a non-null string, then it is returned as-is.
     * <br><br>
     * Example usage:
     *
     * <pre>
     *      String str1 = "Hello";
     *      String str2 = null;
     *
     *      String str3 = StringHelper.getNullSafe(str1);
     *
     *      String str4 = StringHelper.getNullSafe(str2);
     *
     *      // str3 now contains the string: "Hello"
     *      // str4 now contains the string: ""
     * </pre>
     *
     * @param string The string to safeguard against <code>null</code>.
     *
     * @return If str is <code>null</code> then <code>""</code> (empty string).
     *
     * @since 1.0
     *
     */
    public static String getNullSafe(String string) {
        return (string == null) ? "" : string;
    }

    /**
     * Returns <code>true</code> if the passed value is an empty string, false otherwise.
     * <br><br>
     * The value is deemed to be an empty string if it is either:
     * <ul>
     *     <li><code>null</code></li>
     *     <li>a zero-length string</li>
     *     <li>comprised of whitespaces as defined by {@link java.lang.Character#isWhitespace(char)}</li>
     * </ul>
     * <br>
     * Example usage:
     *
     * <pre>
     *     StringHelper.isBlank(null)          = true
     *     StringHelper.isBlank("")            = true
     *     StringHelper.isBlank(" ")           = true
     *     StringHelper.isBlank("something ")  = false
     * </pre>
     *
     * @param string The value to test.
     *
     * @return <code>true</code> if the passed value is an empty string, false otherwise.
     *
     * @since 1.0
     *
     */
    public static boolean isBlank(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }

        for (int i = 0; i < string.length(); i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns <code>true</code> if the passed values are equal, ignoring the case, <code>false</code> otherwise.
     * <br><br>
     * Convenience method equivalent to <code>StringHelper.areEqual(string1, string2, true)</code>
     *
     * @see StringHelper#areEqual(String, String, boolean)
     *
     * @param string1 to compare
     * @param string2 to compare
     *
     * @return whether two strings are equal
     *
     * @since 1.0
     *
     */
    public static boolean areEqual(String string1, String string2) {
        return areEqual(string1, string2, true);
    }

    /**
     * Returns <code>true</code> if the passed values are equal, <code>false</code> otherwise.
     * <br><br>
     * <ul>
     *     <li>
     *         When the lenient flag is set to <code>true</code>, the comparison will ignore the case and trim the
     *         strings before comparing; the two strings are considered equal if,
     *         <ul>
     *             <li>Both strings are blank, as defined by {@link StringHelper#isBlank(String)}.</li>
     *             <li>Trimmed versions of both strings, as defined by {@link String#trim()}, are equal.</li>
     *         </ul>
     *     </li>
     *     <li>
     *         When the lenient flag is set to <code>false</code>, the two strings are considered equal if,
     *         <ul>
     *             <li>Both strings are not null</li>
     *             <li>Both strings represent the same sequence of characters</li>
     *         </ul>
     *     </li>
     * </ul>
     * <br>
     * Example usage:
     *
     * <pre>
     *     StringHelper.areEqual(null, null, true)       = true
     *     StringHelper.areEqual(null, "", true)         = true
     *     StringHelper.areEqual("", null, true)         = true
     *     StringHelper.areEqual("", "", true)           = true
     *     StringHelper.areEqual("   ", "", true)        = true
     *     StringHelper.areEqual(" abc", "abc ", true)   = true
     *     StringHelper.areEqual("", "abc", true)        = false
     *     StringHelper.areEqual("ab c", "abc", true)    = false
     *     StringHelper.areEqual("ABC", "abc", true)     = true
     *     StringHelper.areEqual("abc", "abc", true)     = true
     *
     *     StringHelper.areEqual(null, null, false)      = false
     *     StringHelper.areEqual(null, "", false)        = false
     *     StringHelper.areEqual("", null, false)        = false
     *     StringHelper.areEqual("", "", false)          = true
     *     StringHelper.areEqual("   ", "", false)       = false
     *     StringHelper.areEqual(" abc", "abc ", false)  = false
     *     StringHelper.areEqual("", "abc", false)       = false
     *     StringHelper.areEqual("ab c", "abc", false)   = false
     *     StringHelper.areEqual("ABC", "abc", false)    = false
     *     StringHelper.areEqual("abc", "abc", false)    = true
     * </pre>
     *
     * @see java.lang.String#equalsIgnoreCase(String)
     * @see java.lang.String#equals(Object)
     *
     * @param string1 to compare
     * @param string2 to compare
     * @param lenient whether to be lenient or not
     *
     * @return whether two strings are equal
     *
     * @since 2.1.0
     */
    public static boolean areEqual(String string1, String string2, boolean lenient) {
        if (lenient) {
            return  isBlank(string1) &&
                    isBlank(string2) ||
                    !(isBlank(string1) || isBlank(string2)) &&
                    string1.trim().equalsIgnoreCase(string2.trim());
        }

        return string1 != null && string1.equals(string2);
    }

    /**
     * Returns <code>true</code> if the passed string contains only digits, false otherwise.
     * <br><br>
     * Example usage:
     *
     * <pre>
     *     StringHelper.isOnlyDigits(null)          = false
     *     StringHelper.isOnlyDigits("")            = false
     *     StringHelper.isOnlyDigits(" ")           = false
     *     StringHelper.isOnlyDigits("something ")  = false
     *     StringHelper.isOnlyDigits("11.67")       = false
     *     StringHelper.isOnlyDigits("17650")       = true
     * </pre>
     *
     * @see java.lang.String#matches(String)
     *
     * @param string to check
     *
     * @return whether the string contains only digits
     *
     * @since 1.0
     *
     */
    public static boolean isOnlyDigits(String string) {
        return (!isBlank(string) && string.matches("\\d+"));
    }

    /**
     * Returns <code>true</code> if the passed string is a palindrome, ignoring the case, <code>false</code> otherwise.
     * <br><br>
     * Convenience method equivalent to <code>StringHelper.isPalindrome(string, true)</code>
     *
     * @see StringHelper#isPalindrome(String, boolean)
     *
     * @param string to check
     *
     * @return if the string is a Palindrome
     *
     * @since 2.1.0
     */
    public static boolean isPalindrome(String string) {
        return isPalindrome(string, true);
    }

    /**
     * Returns <code>true</code> if the passed string is a palindrome, <code>false</code> otherwise.
     * <br><br>
     * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward,
     * such as madam or kayak.
     * <br><br>
     * Convenience method equivalent to <code>StringHelper.areEqual(string, string.reverse, flag)</code>
     * <br><br>
     * Example usage:
     *
     * <pre>
     *     StringHelper.isPalindrome(null, true)      = true
     *     StringHelper.isPalindrome("", true)        = true
     *     StringHelper.isPalindrome("   ", true)     = true
     *     StringHelper.isPalindrome(" aba", true)    = true
     *     StringHelper.isPalindrome("aba", true)     = true
     *     StringHelper.isPalindrome("mAdAm", true)   = true
     *     StringHelper.isPalindrome("madAm", true)   = true
     *     StringHelper.isPalindrome("madam", true)   = true
     *     StringHelper.isPalindrome("Madam", true)   = true
     *     StringHelper.isPalindrome("hello", true)   = false
     *
     *     StringHelper.isPalindrome(null, false)     = false
     *     StringHelper.isPalindrome("", false)       = true
     *     StringHelper.isPalindrome("   ", false)    = true
     *     StringHelper.isPalindrome(" aba", false)   = false
     *     StringHelper.isPalindrome("aba", false)    = true
     *     StringHelper.isPalindrome("mAdAm", false)  = true
     *     StringHelper.isPalindrome("madAm", false)  = false
     *     StringHelper.isPalindrome("madam", false)  = true
     *     StringHelper.isPalindrome("Madam", false)  = false
     *     StringHelper.isPalindrome("hello", false)  = false
     * </pre>
     *
     * @see StringHelper#areEqual(String, String, boolean)
     * @see <a href="@WIKI_URI@/Palindrome">Palindrome (Wikipedia)</a>
     *
     * @param string to check
     * @param lenient whether to be lenient or not
     *
     * @return if the string is a Palindrome
     *
     * @since 2.1.0
     */
    public static boolean isPalindrome(String string, boolean lenient) {
        return areEqual(string, new StringBuffer(getNullSafe(string)).reverse().toString(), lenient);
    }
}
