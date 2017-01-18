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

import com.currencyfair.onesignal.model.SuccessResponse;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Response object for {@link com.currencyfair.onesignal.OneSignal#addDevice(AddEditDeviceRequest)}
 * and {@link com.currencyfair.onesignal.OneSignal#editDevice(String, AddEditDeviceRequest)} requests.
 */
public class AddDeviceResponse extends SuccessResponse {

    /**
     * The device/player ID.
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
