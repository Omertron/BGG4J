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
import com.omertron.bgg.enums.PrimaryAlternative;
import java.util.ArrayList;
import java.util.List;

public class Thing extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    private final List<ThingName> names = new ArrayList<>();
    private Integer yearPublished;

    /**
     * Get the game ID
     *
     * @return The ID
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get all the names associated with the Thing
     *
     * @return List of the names associated with the thing
     */
    public List<ThingName> getNames() {
        return names;
    }

    /**
     * Return the name for the Thing.
     *
     * @return the primary name if available, then default to the first
     * alternative name found. If no names are available, null is returned
     */
    public String getName() {
        String name = getPrimaryName();

        if (name == null) {
            List<String> altNames = getAlternativeNames();
            if (altNames != null && !altNames.isEmpty()) {
                name = altNames.get(0);
            }
        }

        return name;
    }

    /**
     * Get the primary name for the thing
     *
     * @return null if no name found
     */
    public String getPrimaryName() {
        if (names.isEmpty()) {
            return null;
        }

        for (ThingName name : names) {
            if (name.getType() == PrimaryAlternative.PRIMARY) {
                return name.getValue();
            }
        }

        return null;
    }

    /**
     * Get a list of the alternative names
     *
     * @return List of the alternative names for the thing
     */
    public List<String> getAlternativeNames() {
        List<String> results = new ArrayList<>();
        for (ThingName name : names) {
            if (name.getType() == PrimaryAlternative.ALTERNATE) {
                results.add(name.getValue());
            }
        }
        return results;
    }

    @JsonSetter("name")
    public void setName(ThingName name) {
        this.names.add(name);
    }

    /**
     * Get the type of the thing
     *
     * @return String representation of the thing type
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * The year the thing was published
     * @return Year as integer
     */
    public Integer getYearPublished() {
        return yearPublished;
    }

    @JsonSetter("yearpublished")
    public void setYearPublished(ValueHolder<Integer> yearPublished) {
        this.yearPublished = yearPublished.getValue();
    }

}
