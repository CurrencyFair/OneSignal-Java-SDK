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

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Object containing a list of purchases.
 */
public class Purchases {

    /**
     * REQUIRED A list of purchases.
     */
    private List<Purchase> purchases = new ArrayList<>();

    /**
     * Pass {@code true} on the first run of your app if you're tracking existing non-consumable purchases. This
     * prevents tracking the same purchases more than once if the user re-installs your app.
     */
    private Boolean existing;

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Boolean getExisting() {
        return existing;
    }

    public void setExisting(Boolean existing) {
        this.existing = existing;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
