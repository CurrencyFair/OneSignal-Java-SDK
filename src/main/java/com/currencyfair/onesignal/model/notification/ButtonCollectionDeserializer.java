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

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Deserializes a collection of {@link Button} objects in JSON.
 * <p>
 * A word of explanation.
 * <p>
 * During testing of the API I've found out that OneSignal wraps the collection of
 * {@code web_buttons} in a String
 * <pre>
 *     "web_buttons":"[{\"id\":\"id\",\"text\":\"here be button\",\"icon\":\"http://i.imgur.com/N8SN8ZS.png\",\"url\":\"https://app.currencyfair.com\"}]"
 * </pre>
 * which makes it impossible to parse as standard collection of objects - Jackson, correctly, interprets it as a simple
 * String ({@link JsonToken#VALUE_STRING}). Contacting OneSignal resulted in much saying response
 * <blockquote>
 *     It looks like we're returning this response as a JSON response. You'll have to parse this response from a JSON string into a Java Object or dictionary in order to get at the original array.
 * </blockquote>
 * hence this custom {@link com.fasterxml.jackson.databind.JsonDeserializer JsonDeserializer}. It also implements a
 * fallback to the standard {@link ObjectMapper#readValue(JsonParser, Class)} call without changed content for a case
 * where OneSignal decides to correctly return the array of objects in the future.
 */
public class ButtonCollectionDeserializer extends StdDeserializer<List<Button>> {

    private static final long serialVersionUID = 1L;

    protected ButtonCollectionDeserializer() {
        super(List.class);
    }

    @Override
    public List<Button> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        TreeNode treeNode = mapper.readTree(p);
        Button[] buttons;
        if (treeNode.asToken() == JsonToken.VALUE_STRING) {
            String rawJson = ((JsonNode) treeNode).asText();
            buttons = mapper.readValue(rawJson, Button[].class);
        } else {
            buttons = mapper.readValue(p, Button[].class);
        }
        return buttons == null ? Collections.<Button>emptyList() : Arrays.asList(buttons);
    }

}
