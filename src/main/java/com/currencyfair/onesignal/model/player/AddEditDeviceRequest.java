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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

/**
 * Request object for {@link com.currencyfair.onesignal.OneSignal#addDevice(AddEditDeviceRequest)} and
 * {@link com.currencyfair.onesignal.OneSignal#editDevice(String, AddEditDeviceRequest)} requests.
 */
public class AddEditDeviceRequest extends Device {

    /**
     * REQUIRED Your OneSignal App Id found in Keys & IDs.
     */
    @JsonProperty("app_id")
    private String appId;

    /**
     * Notification type.
     */
    @JsonProperty("notification_types")
    private NotificationType notificationType;

    /**
     * Longitude of the device, used for geotagging to segment on.
     */
    @JsonProperty("long")
    private BigDecimal longitude;

    /**
     * Latitude of the device, used for geotagging to segment on.
     */
    @JsonProperty("lat")
    private BigDecimal latitude;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
