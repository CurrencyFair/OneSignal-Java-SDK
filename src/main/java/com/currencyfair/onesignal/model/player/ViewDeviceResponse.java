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

/**
 * Response class for {@link com.currencyfair.onesignal.OneSignal#viewDevice(String, String, String)} request.
 */
public class ViewDeviceResponse extends Device {

    /**
     * If {@code true}, this is the equivalent of a user being <i>Unsubscribed</i> (as seen in All Users).
     */
    @JsonProperty("invalid_identifier")
    private Boolean invalidIdentifier;

    public Boolean getInvalidIdentifier() {
        return invalidIdentifier;
    }

    public void setInvalidIdentifier(Boolean invalidIdentifier) {
        this.invalidIdentifier = invalidIdentifier;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
