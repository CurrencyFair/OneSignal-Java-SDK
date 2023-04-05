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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Convenient class for creating {@link AddEditDeviceRequest}.
 */
public final class AddEditDeviceRequestBuilder {
    private DeviceType deviceType;
    private String appId;
    private NotificationType notificationType;
    private String identifier;
    private BigDecimal longitude;
    private String language;
    private BigDecimal latitude;
    private Integer timezone;
    private String gameVersion;
    private String deviceModel;
    private String deviceOs;
    private AdId adId;
    private String sdk;
    private Long sessionCount;
    private Map<String, String> tags = new HashMap<>();
    private BigDecimal amountSpent;
    private Long createdAt;
    private Long badgeCount;
    private Long lastActive;
    private TestType testType;
    private Long playtime;
    private String externalUserId;

    private AddEditDeviceRequestBuilder() {
    }

    public static AddEditDeviceRequestBuilder anAddEditDeviceRequest() {
        return new AddEditDeviceRequestBuilder();
    }

    public AddEditDeviceRequestBuilder withDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public AddEditDeviceRequestBuilder withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public AddEditDeviceRequestBuilder withNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public AddEditDeviceRequestBuilder withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public AddEditDeviceRequestBuilder withLongitude(BigDecimal longitude) {
        this.longitude = longitude;
        return this;
    }

    public AddEditDeviceRequestBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    public AddEditDeviceRequestBuilder withLatitude(BigDecimal latitude) {
        this.latitude = latitude;
        return this;
    }

    public AddEditDeviceRequestBuilder withTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public AddEditDeviceRequestBuilder withGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
        return this;
    }

    public AddEditDeviceRequestBuilder withDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
        return this;
    }

    public AddEditDeviceRequestBuilder withDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
        return this;
    }

    public AddEditDeviceRequestBuilder withAdId(AdId adId) {
        this.adId = adId;
        return this;
    }

    public AddEditDeviceRequestBuilder withSdk(String sdk) {
        this.sdk = sdk;
        return this;
    }

    public AddEditDeviceRequestBuilder withSessionCount(Long sessionCount) {
        this.sessionCount = sessionCount;
        return this;
    }

    public AddEditDeviceRequestBuilder withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    public AddEditDeviceRequestBuilder withTag(String key, String value) {
        tags.put(key, value);
        return this;
    }

    public AddEditDeviceRequestBuilder withAmountSpent(BigDecimal amountSpent) {
        this.amountSpent = amountSpent;
        return this;
    }

    public AddEditDeviceRequestBuilder withCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public AddEditDeviceRequestBuilder withBadgeCount(Long badgeCount) {
        this.badgeCount = badgeCount;
        return this;
    }

    public AddEditDeviceRequestBuilder withLastActive(Long lastActive) {
        this.lastActive = lastActive;
        return this;
    }

    public AddEditDeviceRequestBuilder withTestType(TestType testType) {
        this.testType = testType;
        return this;
    }

    public AddEditDeviceRequestBuilder withPlaytime(Long playtime) {
        this.playtime = playtime;
        return this;
    }

    public AddEditDeviceRequestBuilder withExternalUserId(String externalUserId) {
        this.externalUserId = externalUserId;
        return this;
    }

    public AddEditDeviceRequest build() {
        AddEditDeviceRequest addEditDeviceRequest = new AddEditDeviceRequest();
        addEditDeviceRequest.setDeviceType(deviceType);
        addEditDeviceRequest.setAppId(appId);
        addEditDeviceRequest.setNotificationType(notificationType);
        addEditDeviceRequest.setIdentifier(identifier);
        addEditDeviceRequest.setLongitude(longitude);
        addEditDeviceRequest.setLanguage(language);
        addEditDeviceRequest.setLatitude(latitude);
        addEditDeviceRequest.setTimezone(timezone);
        addEditDeviceRequest.setGameVersion(gameVersion);
        addEditDeviceRequest.setDeviceModel(deviceModel);
        addEditDeviceRequest.setDeviceOs(deviceOs);
        addEditDeviceRequest.setAdId(adId);
        addEditDeviceRequest.setSdk(sdk);
        addEditDeviceRequest.setSessionCount(sessionCount);
        addEditDeviceRequest.setTags(tags);
        addEditDeviceRequest.setAmountSpent(amountSpent);
        addEditDeviceRequest.setCreatedAt(createdAt);
        addEditDeviceRequest.setBadgeCount(badgeCount);
        addEditDeviceRequest.setLastActive(lastActive);
        addEditDeviceRequest.setTestType(testType);
        addEditDeviceRequest.setPlaytime(playtime);
        addEditDeviceRequest.setExternalUserId(externalUserId);
        return addEditDeviceRequest;
    }
}
