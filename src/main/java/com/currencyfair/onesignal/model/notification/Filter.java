/*
 * Copyright 2017 CurrencyFair Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.currencyfair.onesignal.model.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Filters are a powerful way to target users, allowing you to use both data that OneSignal has about a user and
 * any Tags your app may send OneSignal. Filters can be combined together to form advanced, highly precise user
 * targeting. OneSignal customers use all sorts of filters to send notifications, including language, location,
 * user activity, and more.
 * <p>
 * For performance reasons, a maximum of 200 entries can be used at a time.
 * <p>
 * This filter targeting parameter cannot be combined with any other targeting parameters.
 * <p>
 * The filters parameter targets notification recipients using an array of JSON objects containing field conditions
 * to check.
 */

public class Filter {

    /**
     * Name of the field to filter on.
     */
    private Field field;

    /**
     * Key.
     */
    private String key;

    /**
     * Relation.
     */
    private Relation relation;

    /**
     * Value.
     */
    private String value;
    /**
     * for location filter
     */
    private String radius;
    /**
     * for location filter
     */
    @JsonProperty("lat")
    private String latitude;
    /**
     * for location filter
     */
    @JsonProperty("long")
    private String longitude;

    @JsonProperty("hours_ago")
    private int hoursAgo;
    /**
     * Operator. Defaults to {@link Operator#AND}.
     */
    private Operator operator;

    public Filter(Field field, String key, Relation relation, String value) {
        this.field = field;
        this.key = key;
        this.relation = relation;
        this.value = value;
    }

    public Filter(Field field, String radius, String latitude, String longitude) {
        this.field = field;
        this.radius = radius;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Filter(Field field, Relation relation, int hoursAgo) {
        this.field = field;
        this.relation = relation;
        this.hoursAgo = hoursAgo;
    }

    public Filter(Operator operator) {
        this.operator = operator;
    }

    public Filter() {
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getHoursAgo() {
        return hoursAgo;
    }

    public void setHoursAgo(int hoursAgo) {
        this.hoursAgo = hoursAgo;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
