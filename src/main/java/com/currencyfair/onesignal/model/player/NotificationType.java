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
package com.currencyfair.onesignal.model.player;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Notification type.
 * <p>
 * iOS - These values are set each time the user opens the app from the SDK. Use the SDK function set Subscription
 * instead.
 * <p>
 * ANDROID - You may set this but you can no longer use the SDK method setSubscription later in your app as it will
 * create synchronization issues.
 */
public enum NotificationType {

    /**
     * Subscribed.
     */
    SUBSCRIBED("1"),
    /**
     * Unsubscribed.
     */
    UNSUBSCRIBED("-2");

    private final String value;

    NotificationType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static NotificationType forValue(String value) {
        for (NotificationType notificationType : NotificationType.values()) {
            if (notificationType.value.equalsIgnoreCase(value)) {
                return notificationType;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
