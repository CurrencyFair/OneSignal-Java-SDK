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
 * The ad id for the device's platform.
 */
public enum AdId {
    /**
     * {@code Advertising Id}.
     */
    ANDROID("ANDROID"),
    /**
     * {@code identifierForVendor}.
     */
    IOS("iOS"),
    /**
     * {@code DeviceUniqueId}.
     */
    WP8_0("WP8.0"),
    /**
     * {@code AdvertisingId}.
     */
    WP8_1("WP8.1");

    private final String value;

    AdId(String value) {
        this.value = value;
    }

    @JsonCreator
    public static AdId forValue(String value) {
        for (AdId adId : AdId.values()) {
            if (adId.value.equalsIgnoreCase(value)) {
                return adId;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
