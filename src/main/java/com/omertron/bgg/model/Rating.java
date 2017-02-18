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
package com.omertron.bgg.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;

public class Rating extends AbstractXmlMapping {

    @JacksonXmlProperty(localName = "value", isAttribute = true)
    private float value;
    private int usersRated;
    private float average;
    private float bayesAverage;
    private float stdDev;
    private int median;
    private List<Rank> ranks;

    public float getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = NumberUtils.toFloat(value, -1F);
    }

    public int getUsersRated() {
        return usersRated;
    }

    @JsonSetter("usersrated")
    public void setUsersRated(ValueHolder<Integer> usersRated) {
        this.usersRated = usersRated.getValue();
    }

    public float getAverage() {
        return average;
    }

    @JsonSetter("average")
    public void setAverage(ValueHolder<Float> average) {
        this.average = average.getValue();
    }

    public float getBayesAverage() {
        return bayesAverage;
    }

    @JsonSetter("bayesaverage")
    public void setBayesAverage(ValueHolder<Float> bayesAverage) {
        this.bayesAverage = bayesAverage.getValue();
    }

    public float getStdDev() {
        return stdDev;
    }

    @JsonSetter("stddev")
    public void setStdDev(ValueHolder<Float> stdDev) {
        this.stdDev = stdDev.getValue();
    }

    public int getMedian() {
        return median;
    }

    @JsonSetter("median")
    public void setMedian(ValueHolder<Integer> median) {
        this.median = median.getValue();
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(List<Rank> ranks) {
        this.ranks = ranks;
    }

}
