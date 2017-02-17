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
 * @author stuart
 */
public enum IncludeExclude {
    BRIEF,
    BUDDIES,
    COMMENT,
    COMMENTS,
    EXACT,
    GUILDS,
    HASPARTS,
    HISTORICAL,
    HOT,
    MARKETPLACE,
    OWN,
    PLAYED,
    PREORDERED,
    PREVOWNED,
    RATED,
    RATINGCOMMENTS,
    SHOWPRIVATE,
    STATS,
    TOP,
    TRADE,
    VERSIONS,
    VERSION,
    VIDEOS,
    WANT,
    WANTPARTS,
    WANTTOBUY,
    WANTTOPLAY,
    WISHLIST;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static IncludeExclude fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return IncludeExclude.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("IncludeExclude " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("IncludeExclude must not be null");
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
