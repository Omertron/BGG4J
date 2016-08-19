package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author stuar
 */
public class IdValue extends AbstractXmlMapping{

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private String value;

    public IdValue() {
    }

    public IdValue(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
