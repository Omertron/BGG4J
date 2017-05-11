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
package com.omertron.bgg.apibuilder;

import com.omertron.bgg.enums.Command;
import com.omertron.bgg.enums.Domain;
import com.omertron.bgg.enums.FamilyType;
import com.omertron.bgg.enums.HotItemType;
import com.omertron.bgg.enums.IncludeExclude;
import com.omertron.bgg.enums.ThingType;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Omertron
 */
public class BggApiBuilder extends ApiBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(BggApiBuilder.class);
    private static final String NOT_SUPPORTED = "Not supported";

    public BggApiBuilder(String urlFormat) {
        super(urlFormat);
    }

    /**
     * Add the type of request to the URL
     *
     * @param command The request type to use
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder command(Command command) {
        switch (command) {
            case THING:
            case FAMILY:
            case USER:
            case PLAYS:
            case COLLECTION:
            case HOT:
            case SEARCH:
                // Supported
                break;
            case FORUMLIST:
                throw new ApiException(NOT_SUPPORTED);
            case FORUM:
                throw new ApiException(NOT_SUPPORTED);
            case THREAD:
                throw new ApiException(NOT_SUPPORTED);
            case GUILD:
                throw new ApiException(NOT_SUPPORTED);
            default:
                throw new ApiException(NOT_SUPPORTED);
        }
        super.field("{command}", command.toString());
        return this;
    }

    /**
     * Specifies the id of the thing(s) to retrieve.
     *
     * @param id Id
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder id(Integer id) {
        if (id != null && id > 0) {
            super.parameter("id", id);
        }
        return this;
    }

    /**
     * Specifies the id of the thing(s) to retrieve.<br>
     * To request multiple things with a single query, NNN can specify a comma-delimited list of ids.
     *
     * @param id Id
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder id(String id) {
        if (StringUtils.isNotBlank(id)) {
            super.parameter("id", id);
        }
        return this;
    }

    /**
     * Specifies that, regardless of the type of thing asked for by id, the results are filtered by the THINGTYPE(s) specified.<br>
     * Multiple THINGTYPEs can be specified.
     *
     * @param value Value
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder thingType(ThingType value) {
        super.parameter("type", value.toString());
        return this;
    }

    /**
     * Specifies that, regardless of the type of thing asked for by id, the results are filtered by the THINGTYPE(s) specified.<br>
     * Multiple THINGTYPEs can be specified.
     *
     * @param values Values
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder thingType(ThingType... values) {
        if (values != null) {
            super.parameter("type", StringUtils.join(values, ","), false);
        }
        return this;
    }

    /**
     * Defaults to 1, controls the page of data to see for historical info, comments, and ratings data.
     *
     * @param value Value
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder page(int value) {
        if (value <= 1) {
            return this;
        }
        super.parameter("page", Math.max(1, value));
        return this;
    }

    /**
     * Set the number of records to return in paging.
     *
     * Minimum is 10, maximum is 100
     *
     * @param value Value
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder pageSize(int value) {
        int newValue;
        if (value < 10) {
            newValue = 10;
        } else if (value > 100) {
            newValue = 100;
        } else {
            newValue = value;
        }
        super.parameter("pagesize", newValue);
        return this;
    }

    /**
     * Specifies which collection you want to retrieve.<p>
     * TYPE may be boardgame, boardgameexpansion, boardgameaccessory, rpgitem, rpgissue, or videogame<p>
     * The default is boardgame
     *
     * @param subType
     * @return
     */
    public BggApiBuilder subType(ThingType subType) {
        super.parameter("subtype", subType.toString());
        return this;
    }

    /**
     * Specifies which subtype you want to exclude from the results.
     *
     * @param subType
     * @return
     */
    public BggApiBuilder excludeSubType(ThingType subType) {
        super.parameter("excludesubtype", subType.toString());
        return this;
    }

    /**
     * Set the family type
     *
     * @param familyType Family Type
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder family(FamilyType familyType) {
        super.parameter("type", familyType.toString());
        return this;
    }

    /**
     * Set the hot item list type
     *
     * @param hotItemType Hot Item Type
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder hotType(HotItemType hotItemType) {
        super.parameter("type", hotItemType.toString());
        return this;
    }

    /**
     * Specifies the user name.
     *
     * Only one user can be requested at a time.
     *
     * @param name Name
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder name(String name) {
        super.parameter("name", name);
        return this;
    }

    /**
     * Controls the domain for the users hot 10 and top 10 lists.
     *
     * The DOMAIN default is boardgame
     *
     * Valid values are: boardgame, rpg and videogame
     *
     * @param domain Valid values are: boardgame (Default), rpg and videogame
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder domain(Domain domain) {
        super.parameter("domain", domain.toString());
        return this;
    }

    /**
     * Name of the user to request the collection for.
     *
     * @param username Username
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder username(String username) {
        super.parameter("username", username);
        return this;
    }

    /**
     * The query to use for any searches
     *
     * @param query Query
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder query(String query) {
        try {
            super.parameter("query", URLEncoder.encode(query, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            LOG.trace("Failed to encode '{}' using UTF-8", query, ex);
            super.parameter("query", query);
        }
        return this;
    }

    /**
     * Append a single include
     *
     * @param value Value
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder include(IncludeExclude value) {
        if (value != null) {
            super.parameter(value.toString(), 1);
        }
        return this;
    }

    /**
     * Append a list of includes
     *
     * @param values Values
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder include(IncludeExclude... values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 1);
            }
        }
        return this;
    }

    /**
     * Append a list of includes
     *
     * @param values Values
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder include(List<IncludeExclude> values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 1);
            }
        }
        return this;
    }

    /**
     * Append a single exclude
     *
     * @param value Value
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder exclude(IncludeExclude value) {
        if (value != null) {
            super.parameter(value.toString(), 0);
        }
        return this;
    }

    /**
     * Append a list of excludes
     *
     * @param values Values
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder exclude(IncludeExclude... values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 0);
            }
        }
        return this;
    }

    /**
     * Append the exclude list
     *
     * @param values Values
     * @return Current instance for builder pattern.
     */
    public BggApiBuilder exclude(List<IncludeExclude> values) {
        if (values != null) {
            values.forEach((ie) -> {
                super.parameter(ie.toString(), 0);
            });
        }
        return this;
    }

    /**
     * Create the URL from the builder
     *
     * @return URL
     */
    @Override
    public URL buildUrl() {
        return super.buildUrl();
    }

    /**
     * Create the URL from the builder
     *
     * @param appendAllParameters Append the extra parameters (likely to always be true)
     * @return URL
     */
    @Override
    public URL buildUrl(boolean appendAllParameters) {
        return super.buildUrl(appendAllParameters);
    }

}
