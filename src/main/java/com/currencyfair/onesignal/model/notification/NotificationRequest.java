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
 * Notification request object. Used for interacting with any method of OneSignal's notification endpoint.
 */
public class NotificationRequest extends Notification {

    /**
     * Used in {@link com.currencyfair.onesignal.OneSignal#trackOpen(String, String)} request, has to be set to
     * {@code true}.
     */
    private Boolean opened;

    /**
     * Used in {@link com.currencyfair.onesignal.OneSignal#viewNotifications(String, String, Number, Number)} as the
     * upper limit of how many notifications should be retrieved.
     */
    private Long limit;

    /**
     * Used in {@link com.currencyfair.onesignal.OneSignal#viewNotifications(String, String, Number, Number)} as offset
     * of where to start retrieving notifications.
     */
    private Long offset;

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
