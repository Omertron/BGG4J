package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class to handle any unknown properties by outputting a log message
 *
 * @author stuart.boston
 */
public abstract class AbstractXmlMapping implements Serializable {

    private static final long serialVersionUID = 100L;
    protected static final Logger LOG = LoggerFactory.getLogger(AbstractXmlMapping.class);

    /**
     * Handle unknown properties and print a message
     *
     * @param key
     * @param value
     */
    @JsonAnySetter
    protected void handleUnknown(String key, Object value) {
        StringBuilder unknown = new StringBuilder(this.getClass().getSimpleName());
        unknown.append(": Unknown property='").append(key)
               .append("' value='").append(value).append("'");

        LOG.trace(unknown.toString());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}