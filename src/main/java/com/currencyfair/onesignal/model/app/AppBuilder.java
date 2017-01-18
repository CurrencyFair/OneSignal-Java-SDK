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

/**
 * Convenient class for creating {@link App}.
 */
public final class AppBuilder {

    private String id;
    private String name;
    private ApnsEnv apnsEnv;
    private String apnsP12;
    private String apnsP12Password;
    private String gcmKey;
    private String androidGcmSenderId;
    private String chromeWebKey;
    private String chromeWebOrigin;
    private String chromeWebGcmSenderId;
    private String chromeWebDefaultNotificationIcon;
    private String chromeWebSubDomain;
    private String safariApnsP12;
    private String safariApnsP12password;
    private String siteName;
    private String safariSiteOrigin;
    private String safariIcon16x16;
    private String safariIcon32x32;
    private String safariIcon64x64;
    private String safariIcon128x128;
    private String safariIcon256x256;
    private String chromeKey;

    private AppBuilder() {
    }

    public static AppBuilder anApp() {
        return new AppBuilder();
    }

    public AppBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public AppBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AppBuilder withApnsEnv(ApnsEnv apnsEnv) {
        this.apnsEnv = apnsEnv;
        return this;
    }

    public AppBuilder withApnsP12(String apnsP12) {
        this.apnsP12 = apnsP12;
        return this;
    }

    public AppBuilder withApnsP12Password(String apnsP12Password) {
        this.apnsP12Password = apnsP12Password;
        return this;
    }

    public AppBuilder withGcmKey(String gcmKey) {
        this.gcmKey = gcmKey;
        return this;
    }

    public AppBuilder withAndroidGcmSenderId(String androidGcmSenderId) {
        this.androidGcmSenderId = androidGcmSenderId;
        return this;
    }

    public AppBuilder withChromeWebKey(String chromeWebKey) {
        this.chromeWebKey = chromeWebKey;
        return this;
    }

    public AppBuilder withChromeWebOrigin(String chromeWebOrigin) {
        this.chromeWebOrigin = chromeWebOrigin;
        return this;
    }

    public AppBuilder withChromeWebGcmSenderId(String chromeWebGcmSenderId) {
        this.chromeWebGcmSenderId = chromeWebGcmSenderId;
        return this;
    }

    public AppBuilder withChromeWebDefaultNotificationIcon(String chromeWebDefaultNotificationIcon) {
        this.chromeWebDefaultNotificationIcon = chromeWebDefaultNotificationIcon;
        return this;
    }

    public AppBuilder withChromeWebSubDomain(String chromeWebSubDomain) {
        this.chromeWebSubDomain = chromeWebSubDomain;
        return this;
    }

    public AppBuilder withSafariApnsP12(String safariApnsP12) {
        this.safariApnsP12 = safariApnsP12;
        return this;
    }

    public AppBuilder withSafariApnsP12password(String safariApnsP12password) {
        this.safariApnsP12password = safariApnsP12password;
        return this;
    }

    public AppBuilder withSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public AppBuilder withSafariSiteOrigin(String safariSiteOrigin) {
        this.safariSiteOrigin = safariSiteOrigin;
        return this;
    }

    public AppBuilder withSafariIcon16x16(String safariIcon16x16) {
        this.safariIcon16x16 = safariIcon16x16;
        return this;
    }

    public AppBuilder withSafariIcon32x32(String safariIcon32x32) {
        this.safariIcon32x32 = safariIcon32x32;
        return this;
    }

    public AppBuilder withSafariIcon64x64(String safariIcon64x64) {
        this.safariIcon64x64 = safariIcon64x64;
        return this;
    }

    public AppBuilder withSafariIcon128x128(String safariIcon128x128) {
        this.safariIcon128x128 = safariIcon128x128;
        return this;
    }

    public AppBuilder withSafariIcon256x256(String safariIcon256x256) {
        this.safariIcon256x256 = safariIcon256x256;
        return this;
    }

    public AppBuilder withChromeKey(String chromeKey) {
        this.chromeKey = chromeKey;
        return this;
    }

    public App build() {
        App app = new App();
        app.setId(id);
        app.setName(name);
        app.setApnsEnv(apnsEnv);
        app.setApnsP12(apnsP12);
        app.setApnsP12Password(apnsP12Password);
        app.setGcmKey(gcmKey);
        app.setAndroidGcmSenderId(androidGcmSenderId);
        app.setChromeWebKey(chromeWebKey);
        app.setChromeWebOrigin(chromeWebOrigin);
        app.setChromeWebGcmSenderId(chromeWebGcmSenderId);
        app.setChromeWebDefaultNotificationIcon(chromeWebDefaultNotificationIcon);
        app.setChromeWebSubDomain(chromeWebSubDomain);
        app.setSafariApnsP12(safariApnsP12);
        app.setSafariApnsP12password(safariApnsP12password);
        app.setSiteName(siteName);
        app.setSafariSiteOrigin(safariSiteOrigin);
        app.setSafariIcon16x16(safariIcon16x16);
        app.setSafariIcon32x32(safariIcon32x32);
        app.setSafariIcon64x64(safariIcon64x64);
        app.setSafariIcon128x128(safariIcon128x128);
        app.setSafariIcon256x256(safariIcon256x256);
        app.setChromeKey(chromeKey);
        return app;
    }
}
