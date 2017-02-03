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
