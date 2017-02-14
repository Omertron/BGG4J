package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.omertron.bgg.enums.PrimaryAlternative;
import java.util.ArrayList;
import java.util.List;

public class Thing extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    private final List<ThingName> names = new ArrayList<>();
    private Integer yearPublished;

    /**
     * Get the game ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get all the names associated with the Thing
     *
     * @return
     */
    public List<ThingName> getNames() {
        return names;
    }

    /**
     * Return the name for the Thing.
     *
     * @return the primary name if available, then default to the first alternative name found. If no names are available, null is
     * returned
     */
    public String getName() {
        String name = getPrimaryName();

        if (name == null) {
            List<String> altNames = getAlternativeNames();
            if (altNames != null && !altNames.isEmpty()) {
                name = altNames.get(0);
            }
        }

        return name;
    }

    /**
     * Get the primary name for the thing
     *
     * @return null if no name found
     */
    public String getPrimaryName() {
        if (names.isEmpty()) {
            return null;
        }

        for (ThingName name : names) {
            if (name.getType() == PrimaryAlternative.PRIMARY) {
                return name.getValue();
            }
        }

        return null;
    }

    /**
     * Get a list of the alternative names
     *
     * @return
     */
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    @JsonSetter("yearpublished")
    public void setYearPublished(ValueHolder<Integer> yearPublished) {
        this.yearPublished = yearPublished.getValue();
    }

}
