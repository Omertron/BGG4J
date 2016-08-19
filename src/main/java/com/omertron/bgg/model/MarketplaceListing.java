package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Omertron
 */
public class MarketplaceListing extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "listdate")
    private String listDate;
    @JacksonXmlProperty(localName = "price")
    private Price price;
    @JacksonXmlProperty(localName = "condition")
    private String condition;
    @JacksonXmlProperty(localName = "notes")
    private String notes;
    @JacksonXmlProperty(localName = "link")
    private WebLink link;

    public String getListDate() {
        return listDate;
    }

    public void setListDate(ValueHolder<String> listDate) {
        this.listDate = listDate.getValue();
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(ValueHolder<String> condition) {
        this.condition = condition.getValue();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(ValueHolder<String> notes) {
        this.notes = notes.getValue();
    }

    public WebLink getLink() {
        return link;
    }

    public void setLink(WebLink link) {
        this.link = link;
    }
}
