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
 * Response to the {@link com.currencyfair.onesignal.OneSignal#createNotification(String, NotificationRequest)} request.
 */
public class CreateNotificationResponse {

    /**
     * The ID of the created notification.
     */
    private String id;

    /**
     * Number of recipients that receive the notification.
     */
    private Integer recipients;

    /**
     * Not strictly defined so treating it dynamically... No smart mapping to a class can be done since errors content
     * can be an array of strings (as error messages) or a JSON object (as "invalid_player_ids").
     */
    private Object errors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRecipients() {
        return recipients;
    }

    public void setRecipients(Integer recipients) {
        this.recipients = recipients;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
