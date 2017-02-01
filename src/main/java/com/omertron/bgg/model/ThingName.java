package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.omertron.bgg.enums.PrimaryAlternative;

/**
 *
 * @author stuar
 */
public class ThingName extends AbstractXmlMapping {

    private PrimaryAlternative type = PrimaryAlternative.PRIMARY;
    @JacksonXmlProperty(localName = "sortindex", isAttribute = true)
    private int sortIndex;
    @JacksonXmlText
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private String value;

    public PrimaryAlternative getType() {
        return type;
    }
    
    @JsonSetter("type")
    public void setType(String type) {
        this.type = PrimaryAlternative.fromString(type);
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
