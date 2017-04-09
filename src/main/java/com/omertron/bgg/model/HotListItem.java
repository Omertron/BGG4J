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

/**
 * The list of most active items on the site.
 */
public class HotListItem extends AbstractXmlMapping {

    @JacksonXmlProperty(isAttribute = true)
    private int rank;
    @JacksonXmlProperty(isAttribute = true)
    private int id;
    private String thumbnail;
    private String name;
    private Integer yearPublished;

    public HotListItem() {
        // Default constructor
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @JsonSetter("thumbnail")
    public void setThumbnail(ValueHolder<String> thumbnail) {
        this.thumbnail = thumbnail.getValue();
    }

    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(ValueHolder<String> name) {
        this.name = name.getValue();
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    @JsonSetter("yearpublished")
    public void setYearPublished(ValueHolder<Integer> yearPublished) {
        this.yearPublished = yearPublished.getValue();
    }

}
