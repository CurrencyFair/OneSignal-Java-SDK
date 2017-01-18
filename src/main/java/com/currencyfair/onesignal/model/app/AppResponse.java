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
package com.currencyfair.onesignal.model.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Represents a response to requests done on apps endpoint.
 */
public class AppResponse extends App {

    /**
     * Number of registered players in the app.
     */
    private Long players;

    /**
     * Number of messageable players in the app.
     */
    @JsonProperty("messageable_players")
    private Long messageablePlayers;

    /**
     * Date when app was last updated.
     */
    @JsonProperty("updated_at")
    private Date updatedAt;

    /**
     * Date when app was created.
     */
    @JsonProperty("created_at")
    private Date createdAt;

    /**
     * iOS - Your apns certificate
     */
    @JsonProperty("apns_certificates")
    private String apnsCertificates;

    /**
     * SAFARI - Your Safari APNS certificate
     */
    @JsonProperty("safari_apns_certificate")
    private String safariApnsCertificate;

    /**
     * SAFARI - The certificate bundle ID for Safari Web Push
     */
    @JsonProperty("safari_push_id")
    private String safariPushId;

    /**
     * App auth key.
     */
    @JsonProperty("basic_auth_key")
    private String basicAuthKey;

    public Long getPlayers() {
        return players;
    }

    public void setPlayers(Long players) {
        this.players = players;
    }

    public Long getMessageablePlayers() {
        return messageablePlayers;
    }

    public void setMessageablePlayers(Long messageablePlayers) {
        this.messageablePlayers = messageablePlayers;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getApnsCertificates() {
        return apnsCertificates;
    }

    public void setApnsCertificates(String apnsCertificates) {
        this.apnsCertificates = apnsCertificates;
    }

    public String getSafariApnsCertificate() {
        return safariApnsCertificate;
    }

    public void setSafariApnsCertificate(String safariApnsCertificate) {
        this.safariApnsCertificate = safariApnsCertificate;
    }

    public String getSafariPushId() {
        return safariPushId;
    }

    public void setSafariPushId(String safariPushId) {
        this.safariPushId = safariPushId;
    }

    public String getBasicAuthKey() {
        return basicAuthKey;
    }

    public void setBasicAuthKey(String basicAuthKey) {
        this.basicAuthKey = basicAuthKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
