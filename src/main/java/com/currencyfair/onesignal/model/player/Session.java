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

import java.util.Map;

/**
 * Device's session.
 */
public class Session {

    /**
     * RECOMMENDED Push notification identifier from Google or Apple. For Apple push identifiers, you must strip all non
     * alphanumeric characters. Example: {@code ce777617da7f548fe7a9ab6febb56}.
     */
    private String identifier;

    /**
     * RECOMMENDED Language code. Typically lower case two letters, except for Chinese where it must be one of
     * {@code zh-Hans} or {@code zh-Hant}. Example: {@code en}.
     */
    private String language;

    /**
     * RECOMMENDED Number of seconds away from UTC. Example: {@code -28800}.
     */
    private Integer timezone;

    /**
     * RECOMMENDED Version of your app. Example: {@code 1.1}.
     */
    @JsonProperty("game_version")
    private String gameVersion;

    /**
     * RECOMMENDED Device operating system version. Example: {@code 7.0.4}.
     */
    @JsonProperty("device_os")
    private String deviceOs;

    /**
     * RECOMMENDED The ad id for the device's platform.
     */
    @JsonProperty("ad_id")
    private AdId adId;

    /**
     * RECOMMENDED Name and version of the plugin that's calling this API method (if any).
     */
    private String sdk;

    /**
     * Custom tags for the player. Example: {@code {"foo":"bar","this":"that"}}.
     */
    private Map<String, String> tags;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public String getDeviceOs() {
        return deviceOs;
    }

    public void setDeviceOs(String deviceOs) {
        this.deviceOs = deviceOs;
    }

    public AdId getAdId() {
        return adId;
    }

    public void setAdId(AdId adId) {
        this.adId = adId;
    }

    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
