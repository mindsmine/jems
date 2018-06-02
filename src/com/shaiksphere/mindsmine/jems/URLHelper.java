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

import java.net.MalformedURLException;
import java.net.URL;

/**
 * A collection of useful static methods to deal with URLs.
 *
 * @see java.net.URL
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 3.5.0
 *
 */
public final class URLHelper {

    private URLHelper() {}

    /**
     * Returns <code>true</code> if the passed string is a valid URL, <code>false</code> otherwise.
     * <br><br>
     * Example Usage:
     *
     * <pre>
     *     URLHelper.isValidURL("http://userid@example.com")       //  true
     *     URLHelper.isValidURL("www.example.com/main.html")       //  false
     * </pre>
     *
     * @param url to check
     *
     * @return if the string is a valid URL
     *
     * @since 3.5.0
     *
     */
    public static boolean isValidURL(String url) {
        if (StringHelper.isBlank(url)) {
            return false;
        }

        try {
            var _url = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }

        return true;
    }

    public static String appendQuery(String url, String param, Object value) {
        if (!isValidURL(url)) {
            throw new IllegalArgumentException("Fatal Error. 'url'. Invalid URL.");
        }

        if (StringHelper.isBlank(param)) {
            throw new IllegalArgumentException("Fatal Error. 'param'. Only non-empty string(s) are allowed as arguments.");
        }

        URL _url = null;

        try {
            _url = new URL(url);
        } catch (MalformedURLException e) {
            // do nothing
        }

        var query = _url.getQuery();

        if (StringHelper.isBlank(query)) {
            query = param + '=' + value;
        } else {
            query += '&' + param + '=' + value;
        }

        var hash = _url.getRef();

        query = '?' + query + ((!StringHelper.isBlank(hash)) ? '#' + hash : "");

        URL _finalURL = null;

        try {
            _finalURL = new URL(_url.getProtocol(), _url.getHost(), _url.getPort(), query);
        } catch (MalformedURLException e) {
            // do nothing
        }

        return _finalURL.toString();
    }
}
