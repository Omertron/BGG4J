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
import org.apache.commons.lang3.math.NumberUtils;

public class Rank extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "friendlyname", isAttribute = true)
    private String friendlyName;
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private int value;
    @JacksonXmlProperty(localName = "bayesaverage", isAttribute = true)
    private float bayesAverage;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = NumberUtils.toInt(value, -1);
    }

    public float getBayesAverage() {
        return bayesAverage;
    }

    public void setBayesAverage(String bayesAverage) {
        this.bayesAverage = NumberUtils.toFloat(bayesAverage, -1F);
    }

}
