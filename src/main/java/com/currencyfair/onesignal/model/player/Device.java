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
 * The user device.
 */
public class Device extends Session {

    /**
     * REQUIRED The device's platform.
     */
    @JsonProperty("device_type")
    private DeviceType deviceType;

    /**
     * RECOMMENDED Device make and model. Example: {@code iPhone5,1}.
     */
    @JsonProperty("device_model")
    private String deviceModel;

    /**
     * Number of times the user has played the game, defaults to 1.
     */
    @JsonProperty("session_count")
    private Long sessionCount;

    /**
     * Amount the user has spent in USD, up to two decimal places.
     */
    @JsonProperty("amount_spent")
    private BigDecimal amountSpent;

    /**
     * Unixtime when the player joined the game.
     */
    @JsonProperty("created_at")
    private Long createdAt;

    /**
     * Current iOS badge count displayed on the app icon.
     */
    @JsonProperty("badge_count")
    private Long badgeCount;

    /**
     * Unixtime when the player was last active.
     */
    @JsonProperty("last_active")
    private Long lastActive;

    /**
     * Test type.
     */
    @JsonProperty("test_type")
    private TestType testType;

    /**
     * Seconds player was running your app.
     */
    private Long playtime;

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Long getSessionCount() {
        return sessionCount;
    }

    public void setSessionCount(Long sessionCount) {
        this.sessionCount = sessionCount;
    }

    public BigDecimal getAmountSpent() {
        return amountSpent;
    }

    public void setAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getBadgeCount() {
        return badgeCount;
    }

    public void setBadgeCount(Long badgeCount) {
        this.badgeCount = badgeCount;
    }

    public Long getLastActive() {
        return lastActive;
    }

    public void setLastActive(Long lastActive) {
        this.lastActive = lastActive;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public Long getPlaytime() {
        return playtime;
    }

    public void setPlaytime(Long playtime) {
        this.playtime = playtime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
