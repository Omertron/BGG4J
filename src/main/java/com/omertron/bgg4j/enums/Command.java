package com.omertron.bgg4j.enums;

/**
 *
 * @author stuar
 */
public enum Command {
    /**
     * In the BGG database, any physical, tangible product is called a thing
     */
    thing,
    /**
     * In the BGG database, more abstract or esoteric concepts are represented by something called a family.
     */
    family,
    /**
     * Request a list of forums for a particular type/id
     */
    forumlist,
    /**
     * Request a list of threads in a particular forum
     */
    forum,
    /**
     * Request forum threads by thread id.
     *
     * A thread consists of some basic information about the thread and a series of articles or individual postings.
     */
    thread,
    /**
     * Request basic public profile information about a user by username
     */
    user,
    /**
     * Request information about particular guilds.
     */
    guild,
    /**
     * Request plays logged by a particular user or for a particular item.
     */
    plays,
    /**
     * Request details about a user's collection.
     */
    collection,
    /**
     * You can retrieve the list of most active items on the site.
     */
    hot,
    /**
     * You can search for items from the database by name.
     */
    search;
}
