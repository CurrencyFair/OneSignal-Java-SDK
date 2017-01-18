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

import java.util.Objects;

/**
 * Sets the lock screen visibility for apps targeting Android API level 21+ running on Android 5.0+ devices.
 */
public enum AndroidVisibility {

    /**
     * Shows the full message on the lock screen unless the user has disabled all notifications from showing on the lock
     * screen. Please consider the user and mark private if the contents are.
     */
    DEFAULT(1),
    /**
     * Hides message contents on lock screen if the user set "Hide sensitive notification content" in the system
     * settings.
     */
    PRIVATE(0),
    /**
     * Notification does not show on the lock screen at all.
     */
    SECRET(-1);

    private final Integer value;

    AndroidVisibility(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static AndroidVisibility forValue(Integer value) {
        for (AndroidVisibility deviceType : AndroidVisibility.values()) {
            if (Objects.equals(deviceType.value, value)) {
                return deviceType;
            }
        }
        return null;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }
}
