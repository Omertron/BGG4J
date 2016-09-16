package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 *
 * @author Omertron
 */
@JacksonXmlRootElement(localName = "items")
@JsonIgnoreProperties("termsofuse")
public class FamilyWrapper extends AbstractXmlMapping {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<Family> items;

    public List<Family> getItems() {
        return items;
    }

    public void setItems(List<Family> items) {
        this.items = items;
    }

}
