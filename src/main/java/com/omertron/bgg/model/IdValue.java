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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Omertron
 */
public class IdValue extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    private String value;

    protected IdValue() {
        // Default constructor
    }

    public IdValue(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    @JacksonXmlProperty(localName = "publisherid", isAttribute = true)
    public void setPublisherId(int value) {
        this.id = value;
    }

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    public void setValue(String value) {
        this.value = value;
    }

    @JacksonXmlProperty(localName = "name", isAttribute = true)
    public void setName(String name) {
        this.value = name;
    }

}
