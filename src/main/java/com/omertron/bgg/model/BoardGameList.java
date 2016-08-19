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
public class BoardGameList extends AbstractXmlMapping {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<BoardGameExtended> items;

    public List<BoardGameExtended> getItems() {
        return items;
    }

    public void setItems(List<BoardGameExtended> items) {
        this.items = items;
    }

}
