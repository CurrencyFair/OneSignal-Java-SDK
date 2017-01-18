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

import java.util.Objects;

/**
 * Test type - decides whether to use your iOS Sandbox or Production push certificate when sending a push when both
 * have been uploaded. Set to the iOS provisioning profile that was used to build your app.
 */
public enum TestType {

    /**
     * Subscribed.
     */
    DEVELOPMENT(1),
    /**
     * Unsubscribed.
     */
    AD_HOC(2);

    private final Integer value;

    TestType(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static TestType forValue(Integer value) {
        for (TestType deviceType : TestType.values()) {
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
