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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.omertron.bgg.enums.LinkType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stuar
 */
@JacksonXmlRootElement(localName = "item")
@JsonIgnoreProperties("poll")
public class BoardGameExtended extends BoardGame {
    // TODO: Add poll data

    @JacksonXmlProperty(localName = "description")
    private String description;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer playingTime;
    private Integer minPlayTime;
    private Integer maxPlayTime;
    private Integer minAge;

    @JacksonXmlProperty(localName = "videos")
    private List<Video> videos = new ArrayList<>();
    @JacksonXmlProperty(localName = "versions")
    private List<BoardGame> versions = new ArrayList<>();
    @JacksonXmlProperty(localName = "comments")
    private List<Comment> comments = new ArrayList<>();
    @JacksonXmlProperty(localName = "marketplacelistings")
    private List<MarketplaceListing> marketplace = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    @JsonSetter("minplayers")
    public void setMinPlayers(ValueHolder<Integer> minPlayers) {
        this.minPlayers = minPlayers.getValue();
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    @JsonSetter("maxplayers")
    public void setMaxPlayers(ValueHolder<Integer> maxPlayers) {
        this.maxPlayers = maxPlayers.getValue();
    }

    public Integer getPlayingTime() {
        return playingTime;
    }

    @JsonSetter("playingtime")
    public void setPlayingTime(ValueHolder<Integer> playingTime) {
        this.playingTime = playingTime.getValue();
    }

    public Integer getMinPlayTime() {
        return minPlayTime;
    }

    @JsonSetter("minplaytime")
    public void setMinPlaytime(ValueHolder<Integer> minPlaytime) {
        this.minPlayTime = minPlaytime.getValue();
    }

    public Integer getMaxPlayTime() {
        return maxPlayTime;
    }

    @JsonSetter("maxplaytime")
    public void setMaxPlaytime(ValueHolder<Integer> maxPlaytime) {
        this.maxPlayTime = maxPlaytime.getValue();
    }

    public Integer getMinAge() {
        return minAge;
    }

    @JsonSetter("minage")
    public void setMinAge(ValueHolder<Integer> minAge) {
        this.minAge = minAge.getValue();
    }

    public List<IdValue> getBoardGameCategory() {
        return getLink(LinkType.BOARDGAMECATEGORY);
    }

    public List<IdValue> getBoardGameMechanic() {
        return getLink(LinkType.BOARDGAMEMECHANIC);
    }

    public List<IdValue> getBoardGameFamily() {
        return getLink(LinkType.BOARDGAMEFAMILY);
    }

    public List<IdValue> getBoardGameExpansion() {
        return getLink(LinkType.BOARDGAMEEXPANSION);
    }

    public List<IdValue> getBoardGameIntegration() {
        return getLink(LinkType.BOARDGAMEINTEGRATION);
    }

    public List<IdValue> getBoardGameDesigner() {
        return getLink(LinkType.BOARDGAMEDESIGNER);
    }

    public List<IdValue> getBoardGameArtist() {
        return getLink(LinkType.BOARDGAMEARTIST);
    }

    public List<IdValue> getBoardGamePublisher() {
        return getLink(LinkType.BOARDGAMEPUBLISHER);
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<BoardGame> getVersions() {
        return versions;
    }

    public void setVersions(List<BoardGame> versions) {
        this.versions = versions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<MarketplaceListing> getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(List<MarketplaceListing> marketplace) {
        this.marketplace = marketplace;
    }
}
