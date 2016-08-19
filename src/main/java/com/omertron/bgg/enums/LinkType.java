package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Omertron
 */
public enum LinkType {
    BOARDGAMEVERSION,
    BOARDGAMECATEGORY,
    BOARDGAMEMECHANIC,
    BOARDGAMEFAMILY,
    BOARDGAMEEXPANSION,
    BOARDGAMEINTEGRATION,
    BOARDGAMEDESIGNER,
    BOARDGAMEARTIST,
    BOARDGAMEPUBLISHER;

    public String getShortName() {
        return this.name().substring(9).toLowerCase();
    }

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static LinkType fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return LinkType.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("LinkType " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("LinkType must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
