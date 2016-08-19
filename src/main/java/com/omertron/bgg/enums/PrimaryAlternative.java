package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stuar
 */
public enum PrimaryAlternative {
    PRIMARY,
    ALTERNATE;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static PrimaryAlternative fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return PrimaryAlternative.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("PrimaryAlternative " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("PrimaryAlternative must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
