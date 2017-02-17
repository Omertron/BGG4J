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

public class OwnerStatus {

    @JacksonXmlProperty(localName = "own", isAttribute = true)
    private boolean own;
    @JacksonXmlProperty(localName = "prevowned", isAttribute = true)
    private boolean previouslyOwned;
    @JacksonXmlProperty(localName = "fortrade", isAttribute = true)
    private boolean forTrade;
    @JacksonXmlProperty(localName = "want", isAttribute = true)
    private boolean want;
    @JacksonXmlProperty(localName = "wanttoplay", isAttribute = true)
    private boolean wantToPlay;
    @JacksonXmlProperty(localName = "wanttobuy", isAttribute = true)
    private boolean wantToBuy;
    @JacksonXmlProperty(localName = "wishlist", isAttribute = true)
    private int wishlist;
    @JacksonXmlProperty(localName = "wishlistpriority", isAttribute = true)
    private int wishlistPriority;
    @JacksonXmlProperty(localName = "preordered", isAttribute = true)
    private boolean preordered;
    @JacksonXmlProperty(localName = "lastmodified",isAttribute = true)
    private String lastModified;

    public boolean isOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = Boolean.parseBoolean(own);
    }

    public boolean isPreviouslyOwned() {
        return previouslyOwned;
    }

    public void setPreviouslyOwned(String previouslyOwned) {
        this.previouslyOwned = Boolean.parseBoolean(previouslyOwned);
    }

    public boolean isForTrade() {
        return forTrade;
    }

    public void setForTrade(String forTrade) {
        this.forTrade = Boolean.parseBoolean(forTrade);
    }

    public boolean isWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = Boolean.parseBoolean(want);
    }

    public boolean isWantToPlay() {
        return wantToPlay;
    }

    public void setWantToPlay(String wantToPlay) {
        this.wantToPlay = Boolean.parseBoolean(wantToPlay);
    }

    public boolean isWantToBuy() {
        return wantToBuy;
    }

    public void setWantToBuy(String wantToBuy) {
        this.wantToBuy = Boolean.parseBoolean(wantToBuy);
    }

    public int getWishlist() {
        return wishlist;
    }

    public void setWishlist(int wishlist) {
        this.wishlist = wishlist;
    }

    public int getWishlistPriority() {
        return wishlistPriority;
    }

    public void setWishlistPriority(int wishlistPriority) {
        this.wishlistPriority = wishlistPriority;
    }

    public boolean isPreordered() {
        return preordered;
    }

    public void setPreordered(String preordered) {
        this.preordered = Boolean.parseBoolean(preordered);
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

}
