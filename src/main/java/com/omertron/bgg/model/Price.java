package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Omertron
 */
public class Price extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "currency", isAttribute = true)
    private String currency;
    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private Float value;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
