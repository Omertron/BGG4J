package com.omertron.bgg.apibuilder;

import com.omertron.bgg.enums.Command;
import com.omertron.bgg.enums.Domain;
import com.omertron.bgg.enums.FamilyType;
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

    public BggApiBuilder(String urlFormat) {
        super(urlFormat);
    }

    /**
     * Add the type of request to the URL
     *
     * @param command The request type to use
     * @return
     */
    public BggApiBuilder command(Command command) {
        switch (command) {
            case THING:
                // Supported
                break;
            case FAMILY:
                // Supported
                break;
            case FORUMLIST:
                throw new ApiException("Not supported");
            case FORUM:
                throw new ApiException("Not supported");
            case THREAD:
                throw new ApiException("Not supported");
            case USER:
                // Supported
                break;
            case GUILD:
                throw new ApiException("Not supported");
            case PLAYS:
                // Supported
                break;
            case COLLECTION:
                // Supported
                break;
            case HOT:
                throw new ApiException("Not supported");
            case SEARCH:
                // Supported
                break;
            default:
                throw new ApiException("Not supported");
        }
        super.field("{command}", command.toString());
        return this;
    }

    /**
     * Specifies the id of the thing(s) to retrieve. To request multiple things with a single query, NNN can specify a
     * comma-delimited list of ids.
     *
     * @param id
     * @return
     */
    public BggApiBuilder id(int id) {
        super.parameter("id", id);
        return this;
    }

    /**
     * Specifies that, regardless of the type of thing asked for by id, the results are filtered by the THINGTYPE(s) specified.
     * Multiple THINGTYPEs can be specified in a comma-delimited list.
     *
     * @param value
     * @return
     */
    public BggApiBuilder thingType(ThingType value) {
        super.parameter("type", value.toString());
        return this;
    }

    public BggApiBuilder thingType(ThingType... values) {
        if (values != null) {
            super.parameter("type", StringUtils.join(values, ","), false);
        }
        return this;
    }

    /**
     * Defaults to 1, controls the page of data to see for historical info, comments, and ratings data.
     *
     * @param value
     * @return
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
     * @param value
     * @return
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
     * Set the family type
     *
     * @param familyType
     * @return
     */
    public BggApiBuilder family(FamilyType familyType) {
        super.parameter("type", familyType.toString());
        return this;
    }

    /**
     * Specifies the user name.
     *
     * Only one user is requestable at a time.
     *
     * @param name
     * @return
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
     * Valid values are: boardgame, rpg & videogame
     *
     * @param domain
     * @return
     */
    public BggApiBuilder domain(Domain domain) {
        super.parameter("domain", domain.toString());
        return this;
    }

    /**
     * Name of the user to request the collection for.
     *
     * @param username
     * @return
     */
    public BggApiBuilder username(String username) {
        super.parameter("username", username);
        return this;
    }

    public BggApiBuilder query(String query) {
        try {
            super.parameter("query", URLEncoder.encode(query, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            LOG.trace("Failed to encode '{}' using UTF-8", query, ex);
            super.parameter("query", query);
        }
        return this;
    }

    public BggApiBuilder include(IncludeExclude value) {
        if (value != null) {
            super.parameter(value.toString(), 1);
        }
        return this;
    }

    public BggApiBuilder include(IncludeExclude... values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 1);
            }
        }
        return this;
    }

    public BggApiBuilder include(List<IncludeExclude> values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 1);
            }
        }
        return this;
    }

    public BggApiBuilder exclude(IncludeExclude value) {
        if (value != null) {
            super.parameter(value.toString(), 0);
        }
        return this;
    }

    public BggApiBuilder exclude(IncludeExclude... values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 0);
            }
        }
        return this;
    }

    public BggApiBuilder exclude(List<IncludeExclude> values) {
        if (values != null) {
            for (IncludeExclude ie : values) {
                super.parameter(ie.toString(), 0);
            }
        }
        return this;
    }

    @Override
    public URL buildUrl() {
        return super.buildUrl();
    }

    @Override
    public URL buildUrl(boolean appendAllParameters) {
        return super.buildUrl(appendAllParameters);
    }

}
