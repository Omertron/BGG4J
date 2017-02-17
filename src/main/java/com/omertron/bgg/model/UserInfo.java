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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omertron
 */
@JsonIgnoreProperties("termsofuse")
public class UserInfo extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "name", isAttribute = true)
    private String name;
    private String firstName;
    private String lastName;
    private String avatarLink;
    private Integer yearRegistered;
    private String lastLogin;
    private String stateOrProvince;
    private String country;
    private String webAddress;
    private String xboxAccount;
    private String wiiAccount;
    private String psnAccount;
    private String battlenetAccount;
    private String steamAccount;
    private Float tradeRating;
    private List<IdValue> buddies = new ArrayList<>();
    private List<IdValue> guilds = new ArrayList<>();
    @JacksonXmlProperty(localName = "top")
    private List<RankedList> topList = new ArrayList<>();
    @JacksonXmlProperty(localName = "hot")
    private List<RankedList> hotList = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSetter("firstname")
    public void setFirstName(ThingName firstName) {
        this.firstName = firstName.getValue();
    }

    @JsonSetter("lastname")
    public void setLastName(ThingName lastName) {
        this.lastName = lastName.getValue();
    }

    @JsonSetter("avatarlink")
    public void setAvatarLink(ThingName avatarLink) {
        this.avatarLink = avatarLink.getValue();
    }

    @JsonSetter("yearregistered")
    public void setYearRegistered(ThingName yearRegistered) {
        this.yearRegistered = Integer.parseInt(yearRegistered.getValue());
    }

    @JsonSetter("lastlogin")
    public void setLastLogin(ThingName lastLogin) {
        this.lastLogin = lastLogin.getValue();
    }

    @JsonSetter("stateorprovince")
    public void setStateOrProvince(ThingName stateOrProvince) {
        this.stateOrProvince = stateOrProvince.getValue();
    }

    @JsonSetter("country")
    public void setCountry(ThingName country) {
        this.country = country.getValue();
    }

    @JsonSetter("webaddress")
    public void setWebAddress(ThingName webAddress) {
        this.webAddress = webAddress.getValue();
    }

    @JsonSetter("xboxaccount")
    public void setXboxAccount(ThingName xboxAccount) {
        this.xboxAccount = xboxAccount.getValue();
    }

    @JsonSetter("wiiaccount")
    public void setWiiAccount(ThingName wiiAccount) {
        this.wiiAccount = wiiAccount.getValue();
    }

    @JsonSetter("psnaccount")
    public void setPsnAccount(ThingName psnAccount) {
        this.psnAccount = psnAccount.getValue();
    }

    @JsonSetter("battlenetaccount")
    public void setBattlenetAccount(ThingName battlenetAccount) {
        this.battlenetAccount = battlenetAccount.getValue();
    }

    @JsonSetter("steamaccount")
    public void setSteamAccount(ThingName steamAccount) {
        this.steamAccount = steamAccount.getValue();
    }

    @JsonSetter("traderating")
    public void setTradeRating(ThingName tradeRating) {
        this.tradeRating = Float.parseFloat(tradeRating.getValue());
    }

    public void setBuddies(List<IdValue> buddies) {
        this.buddies = buddies;
    }

    public void setGuilds(List<IdValue> guilds) {
        this.guilds = guilds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public Integer getYearRegistered() {
        return yearRegistered;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public String getXboxAccount() {
        return xboxAccount;
    }

    public String getWiiAccount() {
        return wiiAccount;
    }

    public String getPsnAccount() {
        return psnAccount;
    }

    public String getBattlenetAccount() {
        return battlenetAccount;
    }

    public String getSteamAccount() {
        return steamAccount;
    }

    public Float getTradeRating() {
        return tradeRating;
    }

    public List<IdValue> getBuddies() {
        return buddies;
    }

    public List<IdValue> getGuilds() {
        return guilds;
    }

    public List<RankedList> getTopList() {
        return topList;
    }

    public void setTopList(List<RankedList> topList) {
        this.topList = topList;
    }

    public List<RankedList> getHotList() {
        return hotList;
    }

    public void setHotList(List<RankedList> hotList) {
        this.hotList = hotList;
    }

}
