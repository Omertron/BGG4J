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
import com.omertron.bgg.enums.FamilyType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omertron
 */
public class Family extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private FamilyType familyType;
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "name")
    private ThingName name;
    @JacksonXmlProperty(localName = "image")
    private String image;
    @JacksonXmlProperty(localName = "thumbnail")
    private String thumbnail;
    @JacksonXmlProperty(localName = "description")
    private String description;
    private List<IdValue> links = new ArrayList<>();

    public FamilyType getFamilyType() {
        return familyType;
    }

    public void setFamilyType(FamilyType familyType) {
        this.familyType = familyType;
    }

    @JsonSetter
    public void setFamilyType(String familyType) {
        this.familyType = FamilyType.fromString(familyType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IdValue> getLinks() {
        return links;
    }

    public void setLinks(List<IdValue> links) {
        this.links = links;
    }

    @JsonSetter("link")
    public void setLink(Link link) {
        links.add(new IdValue(link.getId(), link.getValue()));
    }

    public ThingName getName() {
        return name;
    }

    public void setName(ThingName name) {
        this.name = name;
    }
}
