/*
 *      Copyright (c) 2017 Stuart Boston
 *
 *      This file is part of the Board Game Geek API Wrapper.
 *
 *      This API wrapper is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API wrapper is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API Wrapper.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.bgg.apibuilder;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Quickly and efficiently assemble URLs which contain both in-URL fields and
 * appended parameters.<p>
 *
 * Parts of the code for this class are from Nabeel Mukhtar's github-java-sdk
 * library.</p>
 *
 * @author Jake Wharton
 */
public class ApiBuilder {

    /**
     * Opening bracket of a field variable.
     */
    protected static final char API_URL_DELIMITER_START = '{';

    /**
     * Closing bracket of a field variable.
     */
    protected static final char API_URL_DELIMITER_END = '}';

    /**
     * The URL format.
     */
    private final String urlFormat;

    /**
     * Map of parameters.
     */
    private final Map<String, String> parametersMap = new HashMap<>();

    /**
     * Map of fields.
     */
    private final Map<String, String> fieldsMap = new HashMap<>();

    /**
     * Creates a new API URL builder.
     *
     * @param urlFormat The URL format.
     */
    public ApiBuilder(String urlFormat) {
        this.urlFormat = urlFormat;
    }

    /**
     * Add a URL parameter value.
     *
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder parameter(String name, String value) {
        return this.parameter(name, value, true);
    }

    /**
     * Add a URL parameter value.
     *
     * @param name Name.
     * @param value Value.
     * @param escape Whether the value needs to be escaped.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder parameter(String name, String value, boolean escape) {
        if (escape) {
            this.parametersMap.put(name, ApiBuilder.encodeUrl(value));
        } else {
            this.parametersMap.put(name, value);
        }

        return this;
    }

    /**
     * Add a URL parameter value.
     *
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder parameter(String name, int value) {
        return this.parameter(name, Integer.toString(value));
    }

    /**
     * Add a URL parameter value.
     *
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder parameter(String name, boolean value) {
        return this.parameter(name, Boolean.toString(value));
    }

    /**
     * Add an empty URL field value.
     *
     * @param name Field name.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder field(String name) {
        this.fieldsMap.put(name, "");
        return this;
    }

    /**
     * Add a URL field value.
     *
     * @param name Field name.
     * @param value Field value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder field(String name, String value) {
        return this.field(name, value, true);
    }

    /**
     * Add a URL field value.
     *
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder field(String name, int value) {
        return this.field(name, Integer.toString(value));
    }

    /**
     * Add a URL field value.
     *
     * @param name Name.
     * @param value Value.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder field(String name, boolean value) {
        return this.field(name, Boolean.toString(value));
    }

    /**
     * Add a URL field value.
     *
     * @param name Field name.
     * @param value Field value.
     * @param escape Whether the value needs to be escaped.
     * @return Current instance for builder pattern.
     */
    protected ApiBuilder field(String name, String value, boolean escape) {
        if (escape) {
            this.fieldsMap.put(name, ApiBuilder.encodeUrl(value));
        } else {
            this.fieldsMap.put(name, value);
        }

        return this;
    }

    /**
     * Test if a parameter key already exists.
     *
     * @param name Name of key.
     * @return True if the key exists in the parameter set.
     */
    protected boolean hasParameter(String name) {
        return this.parametersMap.containsKey(name);
    }

    /**
     * Test if a field key already exists.
     *
     * @param name Name of key.
     * @return True if the key exists in the field set.
     */
    protected boolean hasField(String name) {
        return this.fieldsMap.containsKey(name);
    }

    /**
     * Build the URL.
     *
     * @return String representation of the URL.
     */
    protected URL buildUrl() {
        return this.buildUrl(true);
    }

    /**
     * Build the URL.
     *
     * @param appendAllParameters Whether to append parameters that were not
     * explicitly defined in the URI.
     * @return String representation of the URL.
     */
    protected URL buildUrl(boolean appendAllParameters) {
        StringBuilder urlBuilder = new StringBuilder();
        StringBuilder placeHolderBuilder = new StringBuilder();
        boolean placeHolderFlag = false;
        boolean firstParameter = true;
        List<String> usedParameters = new LinkedList<>();

        for (int i = 0; i < this.urlFormat.length(); i++) {
            if (this.urlFormat.charAt(i) == API_URL_DELIMITER_START) {
                placeHolderBuilder = new StringBuilder();
                placeHolderBuilder.append(API_URL_DELIMITER_START);
                placeHolderFlag = true;
            } else if (placeHolderFlag && (this.urlFormat.charAt(i) == API_URL_DELIMITER_END)) {
                placeHolderBuilder.append(API_URL_DELIMITER_END);
                String placeHolder = placeHolderBuilder.toString();

                if (this.fieldsMap.containsKey(placeHolder)) {
                    urlBuilder.append(this.fieldsMap.get(placeHolder));
                } else if (this.parametersMap.containsKey(placeHolder)) {
                    if (firstParameter) {
                        firstParameter = false;
                        urlBuilder.append("?");
                    } else {
                        urlBuilder.append("&");
                    }

                    urlBuilder.append(placeHolder);
                    urlBuilder.append("=");
                    urlBuilder.append(this.parametersMap.get(placeHolder));

                    usedParameters.add(placeHolder);
                }
                // ELSE: We did not find a binding for the place holder. Skip it.

                placeHolderFlag = false;
            } else if (placeHolderFlag) {
                placeHolderBuilder.append(this.urlFormat.charAt(i));
            } else {
                urlBuilder.append(this.urlFormat.charAt(i));
            }
        }

        //Append all remaining parameters, if desired
        if (appendAllParameters && (this.parametersMap.size() > usedParameters.size())) {
            for (String parameterName : this.parametersMap.keySet()) {
                if (!usedParameters.contains(parameterName)) {
                    if (firstParameter) {
                        firstParameter = false;
                        urlBuilder.append("?");
                    } else {
                        urlBuilder.append("&");
                    }

                    urlBuilder.append(parameterName);
                    urlBuilder.append("=");
                    urlBuilder.append(this.parametersMap.get(parameterName));
                }
            }
        }

        try {
            return new URL(urlBuilder.toString());
        } catch (MalformedURLException ex) {
            return null;
        }

    }

    /**
     * Encode URL content.
     *
     * @param content Content to encode.
     * @return Encoded string.
     */
    protected static String encodeUrl(String content) {
        try {
            return URLEncoder.encode(content, ApiService.CONTENT_ENCODING);
        } catch (UnsupportedEncodingException ex) {
            // should never be here..
            LoggerFactory.getLogger(ApiBuilder.class).warn("Failed to encode content: {}", ex.getMessage(), ex);
            return content;
        }
    }
}
