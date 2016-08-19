package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 *
 * @author Omertron
 */
public class Comment extends AbstractXmlMapping {

    private String username;
    private Float rating;
    private String value;

    public String getUsername() {
        return username;
    }

    @JsonSetter("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public Float getRating() {
        return rating;
    }

    @JsonSetter("rating")
    public void setRating(String rating) {
        // If the value is N/A, ignore it
        if (rating.equalsIgnoreCase("N/A")) {
            this.rating = null;
        } else {
            this.rating = Float.parseFloat(rating);
        }
    }

    public String getValue() {
        return value;
    }

    @JsonSetter("value")
    public void setValue(String value) {
        this.value = value;
    }

}
