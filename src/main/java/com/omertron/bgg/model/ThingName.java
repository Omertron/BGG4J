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

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.omertron.bgg.enums.PrimaryAlternative;

/**
 *
 * @author Omertron
 */
@SuppressWarnings("unused")
public class ThingName extends AbstractXmlMapping {

    private PrimaryAlternative type = PrimaryAlternative.PRIMARY;
    @JacksonXmlProperty(localName = "sortindex", isAttribute = true)
    private int sortIndex;
    @JacksonXmlText
    private String text;
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private String value;

    public PrimaryAlternative getType() {
        return type;
    }

    @JsonSetter("type")
    public void setType(String type) {
        this.type = PrimaryAlternative.fromString(type);
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This is needed to handle the JacksonXmlText
     *
     * @param text
     */
    public void setText(String text) {
        this.value = text;
    }
}
