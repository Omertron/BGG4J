package com.omertron.bgg4j.model;

import com.omertron.bgg4j.enums.PrimaryAlternative;

/**
 *
 * @author stuar
 */
public class ThingName {

    private PrimaryAlternative type;
    private int sortIndex;
    private String value;

    public PrimaryAlternative getType() {
        return type;
    }

    public void setType(PrimaryAlternative type) {
        this.type = type;
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
