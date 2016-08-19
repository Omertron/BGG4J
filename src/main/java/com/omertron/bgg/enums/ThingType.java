package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stuar
 */
public enum ThingType {
    BOARDGAME,
    BOARDGAMEEXPANSION,
    BOARDGAMEACCESSORY,
    VIDEOGAME,
    RPGITEM,
    RPGISSUE;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static ThingType fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return ThingType.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("ThingType " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("ThingType must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
