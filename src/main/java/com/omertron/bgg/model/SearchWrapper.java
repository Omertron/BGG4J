package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

@JacksonXmlRootElement(localName = "items")
@JsonIgnoreProperties({"termsofuse", "script"})
public class SearchWrapper extends AbstractXmlMapping {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<Thing> items;
    @JacksonXmlProperty(localName = "total", isAttribute = true)
    private int total;

    public List<Thing> getItems() {
        return items;
    }

    public void setItems(List<Thing> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
