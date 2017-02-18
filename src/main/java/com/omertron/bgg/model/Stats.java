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

public class Stats extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "minplayers", isAttribute = true)
    private int minPlayers;
    @JacksonXmlProperty(localName = "maxplayers", isAttribute = true)
    private int maxPlayers;
    @JacksonXmlProperty(localName = "minplaytime", isAttribute = true)
    private int minPlayTime;
    @JacksonXmlProperty(localName = "maxplaytime", isAttribute = true)
    private int maxPlayTIme;
    @JacksonXmlProperty(localName = "playingtime", isAttribute = true)
    private int playingTime;
    @JacksonXmlProperty(localName = "numowned", isAttribute = true)
    private int numOwned;
    @JacksonXmlProperty(localName = "rating")
    private Rating rating;

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayTime() {
        return minPlayTime;
    }

    public void setMinPlayTime(int minPlayTime) {
        this.minPlayTime = minPlayTime;
    }

    public int getMaxPlayTIme() {
        return maxPlayTIme;
    }

    public void setMaxPlayTIme(int maxPlayTIme) {
        this.maxPlayTIme = maxPlayTIme;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getNumOwned() {
        return numOwned;
    }

    public void setNumOwned(int numOwned) {
        this.numOwned = numOwned;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
