package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.omertron.bgg.enums.PrimaryAlternative;

/**
 *
 * @author stuar
 */
@SuppressWarnings("unused")
public class ThingName extends AbstractXmlMapping {

    private PrimaryAlternative type = PrimaryAlternative.PRIMARY;
    @JacksonXmlProperty(localName = "sortindex", isAttribute = true)
    private int sortIndex;
    @JacksonXmlText
    private String text;
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

    /**
     * This is needed to handle the JacksonXmlText
     *
     * @param text
     */
    public void setText(String text) {
        this.value = text;
    }
}
