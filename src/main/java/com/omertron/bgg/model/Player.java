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
import org.apache.commons.lang3.BooleanUtils;

public class Player {

    @JacksonXmlProperty(localName = "userid", isAttribute = true)
    private int userId;
    @JacksonXmlProperty(localName = "username", isAttribute = true)
    private String username;
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    @JacksonXmlProperty(localName = "startposition", isAttribute = true)
    private int startposition;
    @JacksonXmlProperty(localName = "color", isAttribute = true)
    private String color;
    @JacksonXmlProperty(localName = "score", isAttribute = true)
    private Float score;
    @JacksonXmlProperty(localName = "new", isAttribute = true)
    private Boolean isNew;
    @JacksonXmlProperty(localName = "rating", isAttribute = true)
    private Float raiting;
    @JacksonXmlProperty(localName = "win", isAttribute = true)
    private Boolean isWin;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartposition() {
        return startposition;
    }

    public void setStartposition(int startposition) {
        this.startposition = startposition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Boolean isNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = BooleanUtils.toBoolean(isNew);
    }

    public Float getRaiting() {
        return raiting;
    }

    public void setRaiting(Float raiting) {
        this.raiting = raiting;
    }

    public Boolean isWin() {
        return isWin;
    }

    public void setIsWin(String isWin) {
        this.isWin = BooleanUtils.toBoolean(isWin);
    }
}
