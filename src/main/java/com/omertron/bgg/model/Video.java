package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Omertron
 */
public class Video extends AbstractXmlMapping {

    /*
    video id="107906" 
    title="Toronto Gaymers' Board Game Review: Dead of Winter: The Long Night" 
    category="review" 
    language="English" 
    link="http://www.youtube.com/watch?v=s02yTugWcxM" 
    username="Justen" 
    userid="223597" 
    postdate="2016-08-15T16:32:44-05:00"/>
     */
    @JacksonXmlProperty(isAttribute = true)
    private Long id;
    private String title;
    private String category;
    private String language;
    private String link;
    private String username;
    @JacksonXmlProperty(localName = "userid", isAttribute = true)
    private Long userId;
    @JacksonXmlProperty(localName = "postdate", isAttribute = true)
    private String postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

}
