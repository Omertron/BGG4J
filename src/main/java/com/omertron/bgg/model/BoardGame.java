package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.omertron.bgg.enums.LinkType;
import com.omertron.bgg.enums.PrimaryAlternative;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Omertron
 */
public class BoardGame extends Thing {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "image")
    private String image;
    @JacksonXmlProperty(localName = "thumbnail")
    private String thumbnail;
    private IdValue boardGameVersion;
    private final List<ThingName> names = new ArrayList<>();
    private final Map<LinkType, List<IdValue>> boardGameLinks = new HashMap<>();
    private Integer yearPublished;
    private Float width;
    private Float length;
    private Float depth;
    private Float weight;
    private String productCode;
    private IdValue language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @JsonSetter("link")
    public void setLink(Link link) {
        if (link.getType().equalsIgnoreCase("language")) {
            this.language = new IdValue(link.getId(), link.getValue());
            return;
        }

        try {
            LinkType linkType = LinkType.fromString(link.getType());
            List<IdValue> results = boardGameLinks.get(linkType);

            if (results == null) {
                results = new ArrayList<>();
            }
            results.add(new IdValue(link.getId(), link.getValue()));

            boardGameLinks.put(linkType, results);
        } catch (IllegalArgumentException ex) {
            LOG.warn("Unknown category '{}' for link", link.getType());
        }
    }

    public List<IdValue> getLink(LinkType linkType) {
        return boardGameLinks.get(linkType);
    }

    public IdValue getBoardGameVersion() {
        return boardGameVersion;
    }

    public List<ThingName> getNames() {
        return names;
    }

    public String getPrimaryName() {
        for (ThingName name : names) {
            if (name.getType() == PrimaryAlternative.PRIMARY) {
                return name.getValue();
            }
        }
        return null;
    }

    public List<String> getAlternativeNames() {
        List<String> results = new ArrayList<>();
        for (ThingName name : names) {
            if (name.getType() == PrimaryAlternative.ALTERNATE) {
                results.add(name.getValue());
            }
        }
        return results;
    }

    @JsonSetter("name")
    public void setName(ThingName name) {
        this.names.add(name);
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    @JsonSetter("yearpublished")
    public void setYearPublished(ValueHolder<Integer> yearPublished) {
        this.yearPublished = yearPublished.getValue();
    }

    public Float getWidth() {
        return width;
    }

    @JsonSetter("width")
    public void setWidth(ValueHolder<Float> width) {
        this.width = width.getValue();
    }

    public Float getLength() {
        return length;
    }

    @JsonSetter("length")
    public void setLength(ValueHolder<Float> length) {
        this.length = length.getValue();
    }

    public Float getDepth() {
        return depth;
    }

    @JsonSetter("depth")
    public void setDepth(ValueHolder<Float> depth) {
        this.depth = depth.getValue();
    }

    public Float getWeight() {
        return weight;
    }

    @JsonSetter("weight")
    public void setHeight(ValueHolder<Float> height) {
        this.weight = height.getValue();
    }

    public String getProductCode() {
        return productCode;
    }

    @JsonSetter("productcode")
    public void setProductCode(ValueHolder<String> productCode) {
        this.productCode = productCode.getValue();
    }

    public IdValue getLanguage() {
        return language;
    }

}
