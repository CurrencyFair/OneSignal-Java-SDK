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

/**
 * Represents OneSignal's app.
 */
public class App {

    /**
     * App ID.
     */
    private String id;

    /**
     * The name of your new app, as displayed on your apps list on the dashboard. This can be renamed later.
     */
    private String name;

    /**
     * iOS - Either sandbox or production
     */
    @JsonProperty("apns_env")
    private ApnsEnv apnsEnv;

    /**
     * iOS - Your apple push notification p12 certificate file, converted to a string and Base64 encoded.
     */
    @JsonProperty("apns_p12")
    private String apnsP12;

    /**
     * iOS - Password for the {@link #apnsP12} file
     */
    @JsonProperty("apns_p12_password")
    private String apnsP12Password;

    /**
     * ANDROID - Your Google Push Messaging Auth Key
     */
    @JsonProperty("gcm_key")
    private String gcmKey;

    /**
     * ANDROID - Your Google Project number. Also know as Sender ID.
     */
    @JsonProperty("android_gcm_sender_id")
    private String androidGcmSenderId;

    /**
     * NOT RECOMMENDED
     * <p>
     * CHROME, FIREFOX - OneSignal uses a shared Google Server API Key so you do not need to generate one.
     */
    @JsonProperty("chrome_web_key")
    private String chromeWebKey;

    /**
     * CHROME, FIREFOX - The URL to your website. This field is required if you wish to enable web push and specify
     * other web push parameters.
     */
    @JsonProperty("chrome_web_origin")
    private String chromeWebOrigin;

    /**
     * NOT RECOMMENDED
     * <p>
     * CHROME, FIREFOX - OneSignal uses a shared GCM Sender ID so you do not need to generate one.
     */
    @JsonProperty("chrome_web_gcm_sender_id")
    private String chromeWebGcmSenderId;

    /**
     * CHROME - Your default notification icon. Should be 80x80 pixels.
     */
    @JsonProperty("chrome_web_default_notification_icon")
    private String chromeWebDefaultNotificationIcon;

    /**
     * CHROME - A subdomain of your choice in order to support Chrome Web Push on non-HTTPS websites. This field must
     * be set in order for the {@link #chromeWebGcmSenderId} property to be processed.
     */
    @JsonProperty("chrome_web_sub_domain")
    private String chromeWebSubDomain;

    /**
     * SAFARI - Your apple push notification p12 certificate file for Safari Push Notifications, converted to a string
     * and Base64 encoded.
     */
    @JsonProperty("safari_apns_p12")
    private String safariApnsP12;

    /**
     * SAFARI - Password for {@link #safariApnsP12} file.
     */
    @JsonProperty("safari_apns_p12_password")
    private String safariApnsP12password;

    /**
     * SAFARI - The URL to your website
     */
    @JsonProperty("site_name")
    private String siteName;

    /**
     * SAFARI - The hostname to your website including {@code http(s)://}
     */
    @JsonProperty("safari_site_origin")
    private String safariSiteOrigin;

    /**
     * SAFARI - A url for a 16x16 png notification icon
     */
    @JsonProperty("safari_icon_16_16")
    private String safariIcon16x16;

    /**
     * SAFARI - A url for a 32x32 png notification icon
     */
    @JsonProperty("safari_icon_32_32")
    private String safariIcon32x32;

    /**
     * SAFARI - A url for a 64x64 png notification icon
     */
    @JsonProperty("safari_icon_64_64")
    private String safariIcon64x64;

    /**
     * SAFARI - A url for a 128x128 png notification icon
     */
    @JsonProperty("safari_icon_128_128")
    private String safariIcon128x128;

    /**
     * SAFARI - A url for a 256x256 png notification icon
     */
    @JsonProperty("safari_icon_256_256")
    private String safariIcon256x256;

    /**
     * NOT FOR WEB PUSH - Your Google Push Messaging Auth Key if you use Chrome Apps / Extensions.
     */
    @JsonProperty("chrome_key")
    private String chromeKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ApnsEnv getApnsEnv() {
        return apnsEnv;
    }

    public void setApnsEnv(ApnsEnv apnsEnv) {
        this.apnsEnv = apnsEnv;
    }

    public String getApnsP12() {
        return apnsP12;
    }

    public void setApnsP12(String apnsP12) {
        this.apnsP12 = apnsP12;
    }

    public String getApnsP12Password() {
        return apnsP12Password;
    }

    public void setApnsP12Password(String apnsP12Password) {
        this.apnsP12Password = apnsP12Password;
    }

    public String getGcmKey() {
        return gcmKey;
    }

    public void setGcmKey(String gcmKey) {
        this.gcmKey = gcmKey;
    }

    public String getAndroidGcmSenderId() {
        return androidGcmSenderId;
    }

    public void setAndroidGcmSenderId(String androidGcmSenderId) {
        this.androidGcmSenderId = androidGcmSenderId;
    }

    public String getChromeWebKey() {
        return chromeWebKey;
    }

    public void setChromeWebKey(String chromeWebKey) {
        this.chromeWebKey = chromeWebKey;
    }

    public String getChromeWebOrigin() {
        return chromeWebOrigin;
    }

    public void setChromeWebOrigin(String chromeWebOrigin) {
        this.chromeWebOrigin = chromeWebOrigin;
    }

    public String getChromeWebGcmSenderId() {
        return chromeWebGcmSenderId;
    }

    public void setChromeWebGcmSenderId(String chromeWebGcmSenderId) {
        this.chromeWebGcmSenderId = chromeWebGcmSenderId;
    }

    public String getChromeWebDefaultNotificationIcon() {
        return chromeWebDefaultNotificationIcon;
    }

    public void setChromeWebDefaultNotificationIcon(String chromeWebDefaultNotificationIcon) {
        this.chromeWebDefaultNotificationIcon = chromeWebDefaultNotificationIcon;
    }

    public String getChromeWebSubDomain() {
        return chromeWebSubDomain;
    }

    public void setChromeWebSubDomain(String chromeWebSubDomain) {
        this.chromeWebSubDomain = chromeWebSubDomain;
    }

    public String getSafariApnsP12() {
        return safariApnsP12;
    }

    public void setSafariApnsP12(String safariApnsP12) {
        this.safariApnsP12 = safariApnsP12;
    }

    public String getSafariApnsP12password() {
        return safariApnsP12password;
    }

    public void setSafariApnsP12password(String safariApnsP12password) {
        this.safariApnsP12password = safariApnsP12password;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSafariSiteOrigin() {
        return safariSiteOrigin;
    }

    public void setSafariSiteOrigin(String safariSiteOrigin) {
        this.safariSiteOrigin = safariSiteOrigin;
    }

    public String getSafariIcon16x16() {
        return safariIcon16x16;
    }

    public void setSafariIcon16x16(String safariIcon16x16) {
        this.safariIcon16x16 = safariIcon16x16;
    }

    public String getSafariIcon32x32() {
        return safariIcon32x32;
    }

    public void setSafariIcon32x32(String safariIcon32x32) {
        this.safariIcon32x32 = safariIcon32x32;
    }

    public String getSafariIcon64x64() {
        return safariIcon64x64;
    }

    public void setSafariIcon64x64(String safariIcon64x64) {
        this.safariIcon64x64 = safariIcon64x64;
    }

    public String getSafariIcon128x128() {
        return safariIcon128x128;
    }

    public void setSafariIcon128x128(String safariIcon128x128) {
        this.safariIcon128x128 = safariIcon128x128;
    }

    public String getSafariIcon256x256() {
        return safariIcon256x256;
    }

    public void setSafariIcon256x256(String safariIcon256x256) {
        this.safariIcon256x256 = safariIcon256x256;
    }

    public String getChromeKey() {
        return chromeKey;
    }

    public void setChromeKey(String chromeKey) {
        this.chromeKey = chromeKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
