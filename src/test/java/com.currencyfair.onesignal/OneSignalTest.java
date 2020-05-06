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
package com.currencyfair.onesignal;

import static com.currencyfair.onesignal.Config.APP_AUTH_KEY;
import static com.currencyfair.onesignal.Config.APP_ID;

import com.currencyfair.onesignal.model.notification.CreateNotificationResponse;
import com.currencyfair.onesignal.model.notification.Field;
import com.currencyfair.onesignal.model.notification.Filter;
import com.currencyfair.onesignal.model.notification.NotificationRequest;
import com.currencyfair.onesignal.model.notification.NotificationRequestBuilder;
import com.currencyfair.onesignal.model.notification.Relation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OneSignalTest {

    @Test
    public void locationFilterTest(){

        Filter location = new Filter(Field.LOCATION, "100000", "50.42", "30.50");

        NotificationRequest nr = NotificationRequestBuilder.aNotificationRequest()
                .withAppId(APP_ID)
                .withFilters(Arrays.asList(location))
                .withContent("en", "Message with location filter")
                .withHeading("en", "Location filter test")
                .build();



        CreateNotificationResponse response = OneSignal.createNotification(APP_AUTH_KEY, nr);

        Assert.assertTrue(response.getId() != null);
        Assert.assertEquals(null,response.getErrors());
        System.out.println("CreateNotificationResponse: " + response);
    }

    @Test
    public void HoursAgoFilterTest() {

        Filter location = new Filter(Field.FIRST_SESSION, Relation.GREATER_THAN,1);

        NotificationRequest nr = NotificationRequestBuilder.aNotificationRequest()
                .withAppId(APP_ID)
                .withFilters(Arrays.asList(location))
                .withContent("en", "Message with location filter")
                .withHeading("en", "Location filter test")
                .build();



        CreateNotificationResponse response = OneSignal.createNotification(APP_AUTH_KEY, nr);

    /*    Assert.assertTrue(response.getId() != null);
        Assert.assertEquals(null,response.getErrors());*/
        Assert.assertTrue(response.getId() != null);
        System.out.println("CreateNotificationResponse: " + response);
    }
}
