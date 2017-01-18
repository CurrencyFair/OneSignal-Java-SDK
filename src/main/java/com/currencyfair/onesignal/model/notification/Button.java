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
package com.currencyfair.onesignal.model.notification;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Notification button.
 */
public class Button {

    /**
     * Button ID.
     */
    private String id;

    /**
     * Button text.
     */
    private String text;

    /**
     * Button icon. Only works for Android.
     */
    private String icon;

    /**
     * Button url. Only works for Chrome 48+.
     */
    private String url;

    public Button(String id, String text, String icon, String url) {
        this.id = id;
        this.text = text;
        this.icon = icon;
        this.url = url;
    }

    public Button() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
