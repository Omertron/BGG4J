package com.omertron.bgg.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author Omertron
 * @param <T>
 */
public class ValueHolder<T> extends AbstractXmlMapping {

    @JacksonXmlProperty(isAttribute = true)
    private T value;

    public T getValue() {
        return (T) value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
