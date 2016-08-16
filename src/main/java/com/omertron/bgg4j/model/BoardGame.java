package com.omertron.bgg4j.model;

import java.util.List;

/**
 *
 * @author stuar
 */
public class BoardGame extends Thing {
    // TODO: Add poll data

    private int id;
    private String image;
    private String thumbnail;
    private List<ThingName> name;
    private String description;
    private Integer yearPublished;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer playingtime;
    private Integer minPlaytime;
    private Integer maxPlaytime;
    private Integer minAge;
    private List<IdValue> boardGameCategory;
    private List<IdValue> boardGameMechanic;
    private List<IdValue> boardGameFamily;
    private List<IdValue> boardGameExpansion;
    private List<IdValue> boardGameIntegration;
    private List<IdValue> boardGameDesigner;
    private List<IdValue> boardGameArtist;
    private List<IdValue> boardGamePublisher;

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

    public List<ThingName> getName() {
        return name;
    }

    public void setName(List<ThingName> name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(Integer yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getPlayingtime() {
        return playingtime;
    }

    public void setPlayingtime(Integer playingtime) {
        this.playingtime = playingtime;
    }

    public Integer getMinPlaytime() {
        return minPlaytime;
    }

    public void setMinPlaytime(Integer minPlaytime) {
        this.minPlaytime = minPlaytime;
    }

    public Integer getMaxPlaytime() {
        return maxPlaytime;
    }

    public void setMaxPlaytime(Integer maxPlaytime) {
        this.maxPlaytime = maxPlaytime;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public List<IdValue> getBoardGameCategory() {
        return boardGameCategory;
    }

    public void setBoardGameCategory(List<IdValue> boardGameCategory) {
        this.boardGameCategory = boardGameCategory;
    }

    public List<IdValue> getBoardGameMechanic() {
        return boardGameMechanic;
    }

    public void setBoardGameMechanic(List<IdValue> boardGameMechanic) {
        this.boardGameMechanic = boardGameMechanic;
    }

    public List<IdValue> getBoardGameFamily() {
        return boardGameFamily;
    }

    public void setBoardGameFamily(List<IdValue> boardGameFamily) {
        this.boardGameFamily = boardGameFamily;
    }

    public List<IdValue> getBoardGameExpansion() {
        return boardGameExpansion;
    }

    public void setBoardGameExpansion(List<IdValue> boardGameExpansion) {
        this.boardGameExpansion = boardGameExpansion;
    }

    public List<IdValue> getBoardGameIntegration() {
        return boardGameIntegration;
    }

    public void setBoardGameIntegration(List<IdValue> boardGameIntegration) {
        this.boardGameIntegration = boardGameIntegration;
    }

    public List<IdValue> getBoardGameDesigner() {
        return boardGameDesigner;
    }

    public void setBoardGameDesigner(List<IdValue> boardGameDesigner) {
        this.boardGameDesigner = boardGameDesigner;
    }

    public List<IdValue> getBoardGameArtist() {
        return boardGameArtist;
    }

    public void setBoardGameArtist(List<IdValue> boardGameArtist) {
        this.boardGameArtist = boardGameArtist;
    }

    public List<IdValue> getBoardGamePublisher() {
        return boardGamePublisher;
    }

    public void setBoardGamePublisher(List<IdValue> boardGamePublisher) {
        this.boardGamePublisher = boardGamePublisher;
    }
}
