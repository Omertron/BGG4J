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

public class BoardGameVersion extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "item")
    private BoardGame item;
    @JacksonXmlProperty(localName = "imageid")
    private String imageid;
    @JacksonXmlProperty(localName = "year")
    private int year;
    @JacksonXmlProperty(localName = "publisher")
    private IdValue publisher;

    public BoardGame getItem() {
        return item;
    }

    public void setItem(BoardGame item) {
        this.item = item;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public IdValue getPublisher() {
        return publisher;
    }

    public void setPublisher(IdValue publisher) {
        this.publisher = publisher;
    }

}
