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
package com.omertron.bgg;

import java.net.URL;
import org.yamj.api.common.exception.ApiException;
import org.yamj.api.common.exception.ApiExceptionType;

public class BggException extends ApiException {

    public BggException(ApiExceptionType exceptionType, String response) {
        super(exceptionType, response);
    }

    public BggException(ApiExceptionType exceptionType, String response, URL url) {
        super(exceptionType, response, url);
    }

    public BggException(ApiExceptionType exceptionType, String response, int responseCode, URL url) {
        super(exceptionType, response, responseCode, url);
    }

    public BggException(ApiExceptionType exceptionType, String response, String url) {
        super(exceptionType, response, url);
    }

    public BggException(ApiExceptionType exceptionType, String response, int responseCode, String url) {
        super(exceptionType, response, responseCode, url);
    }

    public BggException(ApiExceptionType exceptionType, String response, URL url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public BggException(ApiExceptionType exceptionType, String response, int responseCode, URL url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }

    public BggException(ApiExceptionType exceptionType, String response, String url, Throwable cause) {
        super(exceptionType, response, url, cause);
    }

    public BggException(ApiExceptionType exceptionType, String response, int responseCode, String url, Throwable cause) {
        super(exceptionType, response, responseCode, url, cause);
    }
}
