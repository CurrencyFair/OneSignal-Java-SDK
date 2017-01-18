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
 * Describes whether to set or increase/decrease your app's iOS badge count by the {@link Notification#iosBadgeCount}
 * specified count.
 */
public enum IosBadgeType {

    /**
     * Leaves the count unaffected.
     */
    NONE("None"),
    /**
     * Directly sets the badge count to the number specified in {@link Notification#iosBadgeCount}.
     */
    SET_TO("SetTo"),
    /**
     * Adds the number specified in {@link Notification#iosBadgeCount} to the total. Use a negative number to decrease
     * the badge count.
     */
    INCREASE("Increase");

    private final String value;

    IosBadgeType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static IosBadgeType forValue(String value) {
        for (IosBadgeType relation : IosBadgeType.values()) {
            if (relation.value.equalsIgnoreCase(value)) {
                return relation;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
