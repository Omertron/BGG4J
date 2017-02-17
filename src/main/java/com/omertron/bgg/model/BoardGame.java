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
import com.omertron.bgg.enums.LinkType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Omertron
 */
public class BoardGame extends Thing {

    @JacksonXmlProperty(localName = "image")
    private String image;
    @JacksonXmlProperty(localName = "thumbnail")
    private String thumbnail;
    private IdValue boardGameVersion;
    private final Map<LinkType, List<IdValue>> boardGameLinks = new HashMap<>();
    private Float width;
    private Float length;
    private Float depth;
    private Float weight;
    private String productCode;
    private IdValue language;

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

    @JsonSetter("link")
    public void setLink(Link link) {
        if (link.getType().equalsIgnoreCase("language")) {
            this.language = new IdValue(link.getId(), link.getValue());
            return;
        }

        try {
            LinkType linkType = LinkType.fromString(link.getType());
            List<IdValue> results = boardGameLinks.get(linkType);

            if (results == null) {
                results = new ArrayList<>();
            }
            results.add(new IdValue(link.getId(), link.getValue()));

            boardGameLinks.put(linkType, results);
        } catch (IllegalArgumentException ex) {
            LOG.warn("Unknown category '{}' for link", link.getType());
        }
    }

    public List<IdValue> getLink(LinkType linkType) {
        return boardGameLinks.get(linkType);
    }

    public IdValue getBoardGameVersion() {
        return boardGameVersion;
    }

    public Float getWidth() {
        return width;
    }

    @JsonSetter("width")
    public void setWidth(ValueHolder<Float> width) {
        this.width = width.getValue();
    }

    public Float getLength() {
        return length;
    }

    @JsonSetter("length")
    public void setLength(ValueHolder<Float> length) {
        this.length = length.getValue();
    }

    public Float getDepth() {
        return depth;
    }

    @JsonSetter("depth")
    public void setDepth(ValueHolder<Float> depth) {
        this.depth = depth.getValue();
    }

    public Float getWeight() {
        return weight;
    }

    @JsonSetter("weight")
    public void setHeight(ValueHolder<Float> height) {
        this.weight = height.getValue();
    }

    public String getProductCode() {
        return productCode;
    }

    @JsonSetter("productcode")
    public void setProductCode(ValueHolder<String> productCode) {
        this.productCode = productCode.getValue();
    }

    public IdValue getLanguage() {
        return language;
    }

}
