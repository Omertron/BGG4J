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
package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omertron
 */
@JsonIgnoreProperties("page")
public class IdValueWrapper {

    @JacksonXmlProperty(localName = "total", isAttribute = true)
    private int total;
    private final List<IdValue> values = new ArrayList<>();

    protected IdValueWrapper() {
        // Default constructor
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @JsonSetter("guild")
    public void setGuild(IdValue value) {
        values.add(value);
    }

    @JsonSetter("buddy")
    public void setBuddy(IdValue value) {
        values.add(value);
    }

    public List<IdValue> getValues() {
        return values;
    }

}
