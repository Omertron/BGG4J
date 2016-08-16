package com.omertron.bgg4j.apibuilder;

import com.omertron.bgg4j.enums.Command;
import com.omertron.bgg4j.enums.ThingType;

/**
 *
 * @author Omertron
 */
public class BggApiBuilder extends ApiBuilder {

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
            case thing:
                // Supported
                break;
            case family:
                throw new ApiException("Not supported");
            case forumlist:
                throw new ApiException("Not supported");
            case forum:
                throw new ApiException("Not supported");
            case thread:
                throw new ApiException("Not supported");
            case user:
                throw new ApiException("Not supported");
            case guild:
                throw new ApiException("Not supported");
            case plays:
                break;
            case collection:
                throw new ApiException("Not supported");
            case hot:
                throw new ApiException("Not supported");
            case search:
                throw new ApiException("Not supported");
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

    /**
     * Returns version info for the item.
     *
     * @param value
     * @return
     */
    public BggApiBuilder versions(int value) {
        super.parameter("versions", value);
        return this;
    }

    /**
     * Returns videos for the item.
     *
     * @param value
     * @return
     */
    public BggApiBuilder videos(int value) {
        super.parameter("videos ", value);
        return this;
    }

    /**
     * Returns ranking and rating stats for the item.
     *
     * @param value
     * @return
     */
    public BggApiBuilder stats(int value) {
        super.parameter("stats", value);
        return this;
    }

    /**
     * Returns historical data over time. See page parameter.
     *
     * @param value
     * @return
     */
    public BggApiBuilder historical(int value) {
        super.parameter("historical", value);
        return this;
    }

    /**
     * Returns marketplace data.
     *
     * @param value
     * @return
     */
    public BggApiBuilder marketplace(int value) {
        super.parameter("marketplace", value);
        return this;
    }

    /**
     * Returns all comments about the item. Also includes ratings when commented. See page parameter.
     *
     * @param value
     * @return
     */
    public BggApiBuilder comments(int value) {
        super.parameter("comments", value);
        return this;
    }

    /**
     * Returns all ratings for the item.
     *
     * Also includes comments when rated.
     *
     * See page parameter.
     *
     * The ratingcomments and comments parameters cannot be used together, as the output always appears in the comments node of the
     * XML; comments parameter takes precedence if both are specified.
     *
     * Ratings are sorted in descending rating value, based on the highest rating they have assigned to that item (each item in the
     * collection can have a different rating).
     *
     * @param value
     * @return
     */
    public BggApiBuilder ratingComments(int value) {
        super.parameter("ratingcomments", value);
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

    @Override
    public String buildUrl() {
        return super.buildUrl();
    }

    @Override
    public String buildUrl(boolean appendAllParameters) {
        return super.buildUrl(appendAllParameters);
    }

    /**
     * Accept a value and return 1 or 0, nothing else;
     *
     * @param value
     * @return
     */
    private int onOff(int value) {
        if (value == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
