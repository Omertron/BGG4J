/*
 *      Copyright (c) 2017 Stuart Boston
 *
 *      This file is part of the Board Game Geek API Wrapper.
 *
 *      This API wrapper is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API wrapper is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API Wrapper.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Omertron
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
     * @param source String representation of the enum to convert
     * @return The enum that matches the source
     * @throws IllegalArgumentException If type is not recognised
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
