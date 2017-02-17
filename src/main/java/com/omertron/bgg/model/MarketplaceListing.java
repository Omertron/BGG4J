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
public class MarketplaceListing extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "listdate")
    private String listDate;
    @JacksonXmlProperty(localName = "price")
    private Price price;
    @JacksonXmlProperty(localName = "condition")
    private String condition;
    @JacksonXmlProperty(localName = "notes")
    private String notes;
    @JacksonXmlProperty(localName = "link")
    private WebLink link;

    public String getListDate() {
        return listDate;
    }

    public void setListDate(ValueHolder<String> listDate) {
        this.listDate = listDate.getValue();
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(ValueHolder<String> condition) {
        this.condition = condition.getValue();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(ValueHolder<String> notes) {
        this.notes = notes.getValue();
    }

    public WebLink getLink() {
        return link;
    }

    public void setLink(WebLink link) {
        this.link = link;
    }
}
