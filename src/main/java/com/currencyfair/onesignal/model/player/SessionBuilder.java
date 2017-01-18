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

import java.util.HashMap;
import java.util.Map;

/**
 * Convenient class for creating {@link Session}.
 */
public final class SessionBuilder {
    private String identifier;
    private String language;
    private Integer timezone;
    private String gameVersion;
    private String deviceOs;
    private AdId adId;
    private String sdk;
    private Map<String, String> tags = new HashMap<>();

    private SessionBuilder() {
    }

    public static SessionBuilder aSession() {
        return new SessionBuilder();
    }

    public SessionBuilder withIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public SessionBuilder withLanguage(String language) {
        this.language = language;
        return this;
    }

    public SessionBuilder withTimezone(Integer timezone) {
        this.timezone = timezone;
        return this;
    }

    public SessionBuilder withGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
        return this;
    }

    public SessionBuilder withDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
        return this;
    }

    public SessionBuilder withAdId(AdId adId) {
        this.adId = adId;
        return this;
    }

    public SessionBuilder withSdk(String sdk) {
        this.sdk = sdk;
        return this;
    }

    public SessionBuilder withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    public SessionBuilder withTag(String key, String value) {
        tags.put(key, value);
        return this;
    }

    public Session build() {
        Session session = new Session();
        session.setIdentifier(identifier);
        session.setLanguage(language);
        session.setTimezone(timezone);
        session.setGameVersion(gameVersion);
        session.setDeviceOs(deviceOs);
        session.setAdId(adId);
        session.setSdk(sdk);
        session.setTags(tags);
        return session;
    }
}
