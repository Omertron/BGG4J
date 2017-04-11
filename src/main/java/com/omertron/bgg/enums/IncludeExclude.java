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
public enum IncludeExclude {
    /**
     * Returns more abbreviated results.<br>
     * Used in: Collection<br>
     * Use: Include
     */
    BRIEF,
    /**
     * Turns on optional buddies reporting.<br>
     * Used in: Users<br>
     * Use: Include
     */
    BUDDIES,
    /**
     * Filter for items that have been commented.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    COMMENT,
    /**
     * Returns all commnts about the item. Also includes ratings when
     * commented.<br>
     * Used in: Items<br>
     * Use: Include
     *
     */
    COMMENTS,
    /**
     * Limit results to items that match the SEARCH_QUERY exactly.<br>
     * Used in: Search<br>
     * Use: Include & Exclude
     */
    EXACT,
    /**
     * Turns on optional guilds reporting.<br>
     * Used in: Users<br>
     * Use: Include
     */
    GUILDS,
    /**
     * Filter on whether there is a comment in the Has Parts field of the
     * item.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    HASPARTS,
    /**
     * Returns historical data over time.<br>
     * Used in: Items<br>
     * Use: Include
     */
    HISTORICAL,
    /**
     * Include the user's Hot 10 list from their profile.<br>
     * Used in: Users<br>
     * Use: Include
     */
    HOT,
    /**
     * Returns marketplace data.<br>
     * Used in: Items<br>
     * Use: Include
     *
     */
    MARKETPLACE,
    /**
     * Filter for owned games.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    OWN,
    /**
     * Filter for whether an item has been played.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    PLAYED,
    /**
     * Filter for pre-ordered games.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    PREORDERED,
    /**
     * Filter for games marked previously owned.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    PREVOWNED,
    /**
     * Filter for whether an item has been rated.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    RATED,
    /**
     * Returns all ratings for the item. Also includes comments when rated.<br>
     * The ratingcomments and comments parameters cannot be used together;
     * comments parameter takes precedence if both are specified.<br>
     * Ratings are sorted in descending rating value, based on the highest
     * rating they have assigned to that item (each item in the collection can
     * have a different rating).<br>
     * Used in: Items<br>
     * Use: Include
     *
     */
    RATINGCOMMENTS,
    /**
     * Filter to show private collection info. Only works when viewing your own
     * collection and you are logged in.<br>
     * Used in: Collection<br>
     * Use: Include
     */
    SHOWPRIVATE,
    /**
     * Returns expanded rating/ranking info for the collection.<br>
     * Used in: Collection, Items<br>
     * Use: Include
     */
    STATS,
    /**
     * Include the user's top 10 list from their profile.<br>
     * Used in: Users<br>
     * Use: Include
     */
    TOP,
    /**
     * Filter for items marked for trade.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    TRADE,
    /**
     * Returns version info for the item.<br>
     * Used in: Items<br>
     * Use: Include
     */
    VERSIONS,
    /**
     * Returns version info for each item in your collection.<br>
     * Used in: Collection<br>
     * Use: Include
     */
    VERSION,
    /**
     * Returns videos for the item.<br>
     * Used in: Items<br>
     * Use: Include
     */
    VIDEOS,
    /**
     * Filter for items wanted in trade.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    WANT,
    /**
     * Filter on whether there is a comment in the Wants Parts field of the
     * item.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    WANTPARTS,
    /**
     * Filter for items marked as wanting to buy.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    WANTTOBUY,
    /**
     * Filter for items marked as wanting to play.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    WANTTOPLAY,
    /**
     * Filter for items on the wishlist.<br>
     * Used in: Collection<br>
     * Use: Include & Exclude
     */
    WISHLIST;

    /**
     * Convert a string into an Enum type
     *
     * @param source String representation of the enum to convert
     * @return The enum that matches the source
     * @throws IllegalArgumentException If type is not recognised
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
