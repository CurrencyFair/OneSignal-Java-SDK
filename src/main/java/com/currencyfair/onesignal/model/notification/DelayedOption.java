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
 * Delivery schedule option.
 */
public enum DelayedOption {

    /**
     * Deliver at a specific time-of-day in each users own timezone.
     */
    TIMEZONE("timezone"),
    /**
     * Deliver at the same time of day as each user last used your app.
     */
    LAST_ACTIVE("last-active");

    private final String value;

    DelayedOption(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DelayedOption forValue(String value) {
        for (DelayedOption field : DelayedOption.values()) {
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
