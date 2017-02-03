package com.omertron.bgg.enums;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author stuar
 */
public enum Command {
    /**
     * In the BGG database, any physical, tangible product is called a thing
     */
    THING,
    /**
     * In the BGG database, more abstract or esoteric concepts are represented by something called a family.
     */
    FAMILY,
    /**
     * Request a list of forums for a particular type/id
     */
    FORUMLIST,
    /**
     * Request a list of threads in a particular forum
     */
    FORUM,
    /**
     * Request forum threads by thread id.
     *
     * A thread consists of some basic information about the thread and a series of articles or individual postings.
     */
    THREAD,
    /**
     * Request basic public profile information about a user by username
     */
    USER,
    /**
     * Request information about particular guilds.
     */
    GUILD,
    /**
     * Request plays logged by a particular user or for a particular item.
     */
    PLAYS,
    /**
     * Request details about a user's collection.
     */
    COLLECTION,
    /**
     * You can retrieve the list of most active items on the site.
     */
    HOT,
    /**
     * You can search for items from the database by name.
     */
    SEARCH;

    /**
     * Convert a string into an Enum type
     *
     * @param source
     * @return
     * @throws IllegalArgumentException If type is not recognised
     *
     */
    public static Command fromString(String source) {
        if (StringUtils.isNotBlank(source)) {
            try {
                return Command.valueOf(source.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Command " + source + " does not exist.", ex);
            }
        }
        throw new IllegalArgumentException("Command must not be null");
    }
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}