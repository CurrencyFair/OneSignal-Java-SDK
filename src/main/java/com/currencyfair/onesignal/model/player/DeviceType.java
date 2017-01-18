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
 * The device's platform.
 */
public enum DeviceType {

    //CHECKSTYLE:Off Javadoc
    IOS(0),
    ANDROID(1),
    AMAZON(2),
    WINDOWSPHONE_MPNS(3),
    CHROME_APPS_EXTENSIONS(4),
    CHROME_WEB_PUSH(5),
    WINDOWSPHONE_WNS(6),
    SAFARI(7),
    FIREFOX(8),
    MACOS(9);
    //CHECKSTYLE:On Javadoc

    private final Integer value;

    DeviceType(Integer value) {
        this.value = value;
    }

    @JsonCreator
    public static DeviceType forValue(Integer value) {
        for (DeviceType deviceType : DeviceType.values()) {
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
