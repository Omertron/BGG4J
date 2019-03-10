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
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.apache.commons.lang3.BooleanUtils;

public class Play extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "date", isAttribute = true)
    private String date;
    @JacksonXmlProperty(localName = "quantity", isAttribute = true)
    private Integer quantity;
    @JacksonXmlProperty(localName = "length", isAttribute = true)
    private Integer length;
    @JacksonXmlProperty(localName = "incomplete", isAttribute = true)
    private Boolean incomplete;
    @JacksonXmlProperty(localName = "nowinstats", isAttribute = true)
    private Boolean nowInStats;
    @JacksonXmlProperty(localName = "location", isAttribute = true)
    private String location;
    @JacksonXmlProperty(localName = "item", isAttribute = true)
    private Item item;
    @JacksonXmlProperty(localName = "players", isAttribute = true)
    private List<Player> players = new ArrayList<>();
    @JsonSetter("comments")
    private String comments;

    /**
     * Get the play ID
     *
     * @return The ID
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getIncomplete() {
        return incomplete;
    }

    public void setIncomplete(int incomplete) {
        this.incomplete = BooleanUtils.toBoolean(incomplete);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Boolean getNowInStats() {
        return nowInStats;
    }

    public void setNowInStats(int nowInStats) {
        this.nowInStats = BooleanUtils.toBoolean(nowInStats);
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
