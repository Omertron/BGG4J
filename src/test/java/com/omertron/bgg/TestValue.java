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

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Simple test class to hold associated values during testing
 *
 * @author stuar
 */
public class TestValue {

    private String username;
    private Integer id;
    private final List<String> ignoreList = new ArrayList<>();

    public TestValue() {
        this(null, null);
    }

    public TestValue(String username) {
        this(username, null);
    }

    public TestValue(Integer id) {
        this(null, id);
    }

    public TestValue(String username, Integer id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addIgnore(String ignore) {
        this.ignoreList.add(ignore.toUpperCase());
    }

    public boolean containsIgnore(String ignore) {
        return this.ignoreList.contains(ignore.toUpperCase());
    }

    public List<String> getIgnoreList() {
        return ignoreList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
