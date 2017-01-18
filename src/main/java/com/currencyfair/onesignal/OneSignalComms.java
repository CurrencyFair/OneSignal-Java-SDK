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

import com.currencyfair.onesignal.model.SuccessResponse;
import com.currencyfair.onesignal.model.app.App;
import com.currencyfair.onesignal.model.app.AppResponse;
import com.currencyfair.onesignal.model.notification.CreateNotificationResponse;
import com.currencyfair.onesignal.model.notification.NotificationRequest;
import com.currencyfair.onesignal.model.notification.ViewNotificationResponse;
import com.currencyfair.onesignal.model.notification.ViewNotificationsResponse;
import com.currencyfair.onesignal.model.player.AddDeviceResponse;
import com.currencyfair.onesignal.model.player.AddEditDeviceRequest;
import com.currencyfair.onesignal.model.player.CsvExportFileLocationRequest;
import com.currencyfair.onesignal.model.player.CsvExportFileLocationResponse;
import com.currencyfair.onesignal.model.player.Purchases;
import com.currencyfair.onesignal.model.player.Session;
import com.currencyfair.onesignal.model.player.ViewDeviceResponse;
import com.currencyfair.onesignal.model.player.ViewDevicesResponse;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * Feign-compatible interface for working with OneSignal API.
 */
@Headers("Accept: application/json")
public interface OneSignalComms {

    /**
     * The {@code application/json} content type header.
     */
    String JSON_CONTENT_TYPE_HEADER = "Content-Type: application/json; charset=utf-8";

    // NOTIFICATIONS

    @RequestLine("POST /notifications")
    @Headers({
            "Authorization: Basic {appAuthKey}",
            JSON_CONTENT_TYPE_HEADER
    })
    CreateNotificationResponse createNotification(@Param("appAuthKey") String appAuthKey, NotificationRequest notificationRequest);

    @RequestLine("DELETE /notifications/{id}?app_id={appId}")
    @Headers("Authorization: Basic {appAuthKey}")
    void cancelNotification(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, @Param("id") String notificationId);

    @RequestLine("GET /notifications/{id}?app_id={appId}")
    @Headers("Authorization: Basic {appAuthKey}")
    ViewNotificationResponse viewNotification(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, @Param("id") String notificationId);

    @RequestLine("GET /notifications?app_id={appId}&limit={limit}&offset={offset}")
    @Headers("Authorization: Basic {appAuthKey}")
    ViewNotificationsResponse viewNotifications(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, @Param("limit") Number limit, @Param("offset") Number offset);

    @RequestLine("PUT /notifications/{id}")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    @Body("%7B\"opened\": true, \"app_id\": \"{appId}\"%7D")
    void trackOpen(@Param("appId") String appId, @Param("id") String notificationId);


    // APPS

    @RequestLine("GET /apps")
    @Headers("Authorization: Basic {userAuthKey}")
    List<AppResponse> viewApps(@Param("userAuthKey") String userAuthKey);

    @RequestLine("GET /apps/{id}")
    @Headers("Authorization: Basic {userAuthKey}")
    AppResponse viewApp(@Param("userAuthKey")String userAuthKey, @Param("id") String appId);

    @RequestLine("POST /apps")
    @Headers({
            "Authorization: Basic {userAuthKey}",
            JSON_CONTENT_TYPE_HEADER
    })
    AppResponse createApp(@Param("userAuthKey")String userAuthKey, App app);

    @RequestLine("PUT /apps/{id}")
    @Headers({
            "Authorization: Basic {userAuthKey}",
            JSON_CONTENT_TYPE_HEADER
    })
    AppResponse updateApp(@Param("userAuthKey")String userAuthKey, @Param("id") String appId, App app);


    // PLAYERS

    @RequestLine("GET /players?app_id={appId}&limit={limit}&offset={offset}")
    @Headers("Authorization: Basic {appAuthKey}")
    ViewDevicesResponse viewDevices(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, @Param("limit") Number limit, @Param("offset") Number offset);

    @RequestLine("GET /players/{id}?app_id={appId}")
    @Headers("Authorization: Basic {appAuthKey}")
    ViewDeviceResponse viewDevice(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, @Param("id") String deviceId);

    @RequestLine("POST /players")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    AddDeviceResponse addDevice(AddEditDeviceRequest device);

    @RequestLine("PUT /players/{id}")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    SuccessResponse editDevice(@Param("id") String deviceId, AddEditDeviceRequest device);

    @RequestLine("POST /players/{id}/on_session")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    SuccessResponse newSession(@Param("id") String deviceId, Session session);

    @RequestLine("POST /players/{id}/on_purchase")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    SuccessResponse newPurchase(@Param("id") String deviceId, Purchases purchases);

    @RequestLine("POST /players/{id}/on_focus")
    @Headers(JSON_CONTENT_TYPE_HEADER)
    @Body("%7B\"state\": \"ping\", \"active_time\": \"{activeTime}\"%7D")
    SuccessResponse incrementSessionLength(@Param("id") String deviceId, @Param("activeTime") Long activeTime);

    @RequestLine("POST /players/csv_export?app_id={appId}")
    @Headers({
            "Authorization: Basic {appAuthKey}",
            JSON_CONTENT_TYPE_HEADER
    })
    CsvExportFileLocationResponse csvExportLocation(@Param("appAuthKey") String appAuthKey, @Param("appId") String appId, CsvExportFileLocationRequest csvExportFileLocationRequest);
}
