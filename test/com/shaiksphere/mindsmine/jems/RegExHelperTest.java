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

import java.util.Arrays;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegExHelperTest {
    private final Pattern EMAIL_PATTERN = Pattern.compile(RegExHelper.EMAIL);
    private final Pattern US_PHONE_NUMBER_PATTERN = Pattern.compile(RegExHelper.US_PHONE_NUMBER);

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private boolean isValidPhone(String phone) {
        return US_PHONE_NUMBER_PATTERN.matcher(phone).matches();
    }

    @Test
    public void emailPassTest() {
        Arrays.asList(
                "test@test.com",
                "alice@example.com",
                "alice@example.co.in",
                "alice.bob@example.com",
                "alice_bob@example.com",
                "alice@example.company.in"
        ).forEach(email -> assertTrue(isValidEmail(email)));
    }

    @Test
    public void emailFailTest() {
        Arrays.asList(
                ".alice@example.com",
                "alice@example.com.",
                "alice@example.c",
                "alice@example.companies"
        ).forEach(email -> assertFalse(isValidEmail(email)));
    }

    @Test
    public void phonePassTest() {
        Arrays.asList(
                "(215) 898-1234",
                "(646) 898-1234",
                "(888) 298-1234"
        ).forEach(phone -> assertTrue(isValidPhone(phone)));
    }

    @Test
    public void phoneFailTest() {
        Arrays.asList(
                "(115) 898-1234",
                "(646) 198-1234",
                "(888) 098-1234"
        ).forEach(phone -> assertFalse(isValidPhone(phone)));
    }
}
