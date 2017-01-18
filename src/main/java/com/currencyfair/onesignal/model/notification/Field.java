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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Name of the field that can be used in {@link Filter} when creating notification.
 */
public enum Field {

    /**
     * {@code relation} = {@link Relation#LESS_THAN} or {@link Relation#GREATER_THAN}
     * <p>
     * {@code hours_ago} = number of hours before or after the users last session. Example: {@code "1.1"}
     */
    LAST_SESSION("last_session"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN} or {@link Relation#GREATER_THAN}
     * <p>
     * {@code hours_ago} = number of hours before or after the users first session. Example: {@code "1.1"}
     */
    FIRST_SESSION("first_session"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN}, {@link Relation#GREATER_THAN}, {@link Relation#EQUALS} or
     * {@link Relation#NOT_EQUALS}
     * <p>
     * {@code value} = number of sessions. Example: {@code "1"}
     */
    SESSION_COUNT("session_count"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN} or {@link Relation#GREATER_THAN}
     * <p>
     * {@code value} = Time in seconds the user has been in your app. Example: {@code "3600"}
     */
    SESSION_TIME("session_time"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN}, {@link Relation#GREATER_THAN} or {@link Relation#EQUALS}
     * <p>
     * {@code value} = Amount in USD a user has spent on IAP (In App Purchases). Example: {@code "0.99"}
     */
    AMOUNT_SPENT("amount_spent"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN}, {@link Relation#GREATER_THAN} or {@link Relation#EQUALS}
     * <p>
     * {@code key} = SKU purchased in your app as an IAP (In App Purchases). Example: {@code "com.domain.100coinpack"}
     * <p>
     * {@code value} = value of SKU to compare to. Example: {@code "0.99"}
     */
    BOUGHT_SKU("bought_sku"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN}, {@link Relation#GREATER_THAN}, {@link Relation#EQUALS},
     * {@link Relation#NOT_EQUALS}, {@link Relation#EXISTS} or {@link Relation#NOT_EXISTS}
     * <p>
     * {@code key} = Tag key to compare.
     * <p>
     * {@code value} = Tag value to compare. Not required for {@link Relation#EXISTS} or {@link Relation#NOT_EXISTS}.
     */
    TAG("tag"),
    /**
     * {@code relation} = {@link Relation#EQUALS} or {@link Relation#NOT_EQUALS}
     * <p>
     * {@code value} =  2 character language code. Example: {@code "en".}
     */
    LANGUAGE("language"),
    /**
     * {@code relation} = {@link Relation#LESS_THAN}, {@link Relation#GREATER_THAN}, {@link Relation#EQUALS} or
     * {@link Relation#NOT_EQUALS}
     * <p>
     * {@code value} = app version. Example: {@code "1.0.0"}
     */
    APP_VERSION("app_version"),
    /**
     * {@code radius} = in meters
     * {@code lat} = latitude
     * {@code long} = longitude
     */
    LOCATION("location"),
    /**
     * {@code value} = email address
     */
    EMAIL("email");

    private final String value;

    Field(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Field forValue(String value) {
        for (Field field : Field.values()) {
            if (field.value.equalsIgnoreCase(value)) {
                return field;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
