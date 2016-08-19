package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stuar
 */
public enum FamilyType {
    RPG,
    RPGPERIODICAL,
    BOARDGAMEFAMILY;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static FamilyType fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return FamilyType.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("FamilyType " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("FamilyType must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
