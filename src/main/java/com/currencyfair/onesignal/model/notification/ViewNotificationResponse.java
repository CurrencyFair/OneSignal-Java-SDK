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

import java.util.Map;

/**
 * Response to the {@link com.currencyfair.onesignal.OneSignal#viewNotification(String, String, String)} request.
 */
public class ViewNotificationResponse extends Notification {

    /**
     * Successful.
     */
    private Long successful;

    /**
     * Number of notifications that have not been sent out yet. This can mean either our system is still processing the
     * notification or you have delayed options set.
     */
    private Long remaining;

    /**
     * Number of notifications that could not be delivered due to an error. You can find more information by viewing
     * the notification in the dashboard.
     */
    private Long failed;

    /**
     * Number of users who have clicked / tapped on your notification.
     */
    private Long converted;

    /**
     * Errored.
     */
    private Long errored;

    /**
     * Cancelled.
     */
    private Boolean canceled;

    /**
     * Unixtime representation of the time that the notification was queued.
     */
    @JsonProperty("queued_at")
    private String queuedAt;

    /**
     * Custom tags for the player. Only support string key value pairs. Does not support arrays or other nested objects.
     * <p>
     * Example: {@code {"foo":"bar","this":"that"}}
     */
    private Map<String, String> tags;

    public Long getSuccessful() {
        return successful;
    }

    public void setSuccessful(Long successful) {
        this.successful = successful;
    }

    public Long getRemaining() {
        return remaining;
    }

    public void setRemaining(Long remaining) {
        this.remaining = remaining;
    }

    public Long getFailed() {
        return failed;
    }

    public void setFailed(Long failed) {
        this.failed = failed;
    }

    public Long getConverted() {
        return converted;
    }

    public void setConverted(Long converted) {
        this.converted = converted;
    }

    public Long getErrored() {
        return errored;
    }

    public void setErrored(Long errored) {
        this.errored = errored;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public String getQueuedAt() {
        return queuedAt;
    }

    public void setQueuedAt(String queuedAt) {
        this.queuedAt = queuedAt;
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
