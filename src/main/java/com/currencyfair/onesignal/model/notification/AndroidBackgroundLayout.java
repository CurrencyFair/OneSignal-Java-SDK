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

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Allows setting a background image for the notification.
 */
public class AndroidBackgroundLayout {

    /**
     * Asset file, android resource name, or URL to remote image.
     */
    private String image;

    /**
     * Title text color ARGB Hex format. Example(Blue): {@code "FF0000FF"}.
     */
    @JsonProperty("headings_color")
    private String headingsColor;

    /**
     * Body text color ARGB Hex format. Example(Red): {@code "FFFF0000"}
     */
    @JsonProperty("contents_color")
    private String contentsColor;

    public AndroidBackgroundLayout(String image, String headingsColor, String contentsColor) {
        this.image = image;
        this.headingsColor = headingsColor;
        this.contentsColor = contentsColor;
    }

    public AndroidBackgroundLayout() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeadingsColor() {
        return headingsColor;
    }

    public void setHeadingsColor(String headingsColor) {
        this.headingsColor = headingsColor;
    }

    public String getContentsColor() {
        return contentsColor;
    }

    public void setContentsColor(String contentsColor) {
        this.contentsColor = contentsColor;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
