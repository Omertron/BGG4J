package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stuart
 */
public enum Domain {
    BOARDGAME,
    RPG,
    VIDEOGAME;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static Domain fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return Domain.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Domain " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("Domain must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
