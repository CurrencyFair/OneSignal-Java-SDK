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

import java.util.List;

/**
 * Response to the {@link com.currencyfair.onesignal.OneSignal#viewNotifications(String, String, Number, Number)} request.
 */
public class ViewNotificationsResponse {

    /**
     * Total number of notifications.
     */
    @JsonProperty("total_count")
    private Long totalCount;

    /**
     * Limit of how many notifications could be retrieved.
     */
    private Long limit;

    /**
     * Offset of where the notifications were started to be retrieved.
     */
    private Long offset;

    /**
     * List of retrieved notifications.
     */
    private List<ViewNotificationResponse> notifications;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public List<ViewNotificationResponse> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<ViewNotificationResponse> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
