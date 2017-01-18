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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Filter relation.
 */
public enum Relation {

    //CHECKSTYLE:Off Javadoc
    LESS_THAN(">"),
    GREATER_THAN("<"),
    EQUALS("+"),
    NOT_EQUALS("!="),
    EXISTS("exists"),
    NOT_EXISTS("not_exists");
    //CHECKSTYLE:On Javadoc

    private final String value;

    Relation(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Relation forValue(String value) {
        for (Relation relation : Relation.values()) {
            if (relation.value.equalsIgnoreCase(value)) {
                return relation;
            }
        }
        return null;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
