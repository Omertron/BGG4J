package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "item")
public class CollectionItem extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "objecttype", isAttribute = true)
    private String objectType;
    @JacksonXmlProperty(localName = "subtype", isAttribute = true)
    private String subtype;
    @JacksonXmlProperty(localName = "objectid", isAttribute = true)
    private int objectId;
    @JacksonXmlProperty(localName = "collid", isAttribute = true)
    private int collectionId;
    @JacksonXmlElementWrapper(useWrapping = true)
    @JacksonXmlProperty(localName = "name", isAttribute = false)
    private ThingName name;
    @JacksonXmlProperty(localName = "originalname")
    private String originalName;
    @JacksonXmlProperty(localName = "yearpublished")
    private String yearPublished;
    @JacksonXmlProperty(localName = "image")
    private String image;
    @JacksonXmlProperty(localName = "thumbnail")
    private String thumbnail;
    @JacksonXmlProperty(localName = "status")
    private OwnerStatus ownerStatus;
    @JacksonXmlProperty(localName = "numplays")
    private int numPlays;
    @JacksonXmlProperty(localName = "comment")
    private String comment;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(ThingName name) {
        this.name = name;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
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

    public OwnerStatus getOwnerStatus() {
        return ownerStatus;
    }

    public void setOwnerStatus(OwnerStatus ownerStatus) {
        this.ownerStatus = ownerStatus;
    }

    public int getNumPlays() {
        return numPlays;
    }

    public void setNumPlays(int numPlays) {
        this.numPlays = numPlays;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

}
