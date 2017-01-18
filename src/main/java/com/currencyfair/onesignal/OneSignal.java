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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * OneSignal requests entry point.
 */
public final class OneSignal {

    private OneSignal() {
    }

    /**
     * The Create Notification method is used when you want your server to programmatically send notifications to a
     * segment or individual users. You may target users in one of three ways using this method: by <b>Segment</b>, by
     * <b>Filter</b>, or by <b>Device</b>. At least one targeting parameter must be specified.
     * <p>
     * You may only use one method of targeting users
     * <p>
     * If a targeting parameter of one type is used, then targeting parameters from other types may not be used.
     * For instance, you cannot use the {@link NotificationRequest#includedSegments} parameter (from segments) with
     * the {@link NotificationRequest#filters}.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param notificationRequest the notification to create
     * @return the response
     */
    public static CreateNotificationResponse createNotification(String appAuthKey, NotificationRequest notificationRequest) {
        return oneSignal().createNotification(appAuthKey, notificationRequest);
    }

    /**
     * Stop a scheduled or currently outgoing notification.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs, unless the notification was created using
     * {@link NotificationRequest#includePlayerIds} and targeting only one user.
     * @param appId OneSignal App ID
     * @param notificationId the notification ID to cancel
     */
    public static void cancelNotification(String appAuthKey, String appId, String notificationId) {
        oneSignal().cancelNotification(appAuthKey, appId, notificationId);
    }

    /**
     * View the details of a single notification.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param appId OneSignal App ID
     * @param notificationId the notification ID to retrieve
     * @return the matching notifications or error response
     */
    public static ViewNotificationResponse viewNotification(String appAuthKey, String appId, String notificationId) {
        return oneSignal().viewNotification(appAuthKey, appId, notificationId);
    }

    /**
     * View the details of multiple notifications.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param appId OneSignal App ID
     * @param limit max number of notifications to retrieve, if {@code null} defaults to {@code 50}
     * @param offset where to start, if {@code null} defaults to {@code 0}
     * @return list of matching notifications or error response
     */
    public static ViewNotificationsResponse viewNotifications(String appAuthKey, String appId, Number limit, Number offset) {
        return oneSignal().viewNotifications(appAuthKey, appId, limit, offset);
    }

    /**
     * Mark notification as opened.
     * @param appId OneSignal App ID
     * @param notificationId the notification ID to mark as opened
     */
    public static void trackOpen(String appId, String notificationId) {
        oneSignal().trackOpen(appId, notificationId);
    }

    /**
     * View the details of all of your current OneSignal apps.
     * @param userAuthKey OneSignal User Auth Key, available in Keys &amp; IDs.
     * @return list of all your apps
     */
    public static List<AppResponse> viewApps(String userAuthKey) {
        return oneSignal().viewApps(userAuthKey);
    }

    /**
     * View the details of a single OneSignal app.
     * @param userAuthKey OneSignal User Auth Key, available in Keys &amp; IDs.
     * @param appId the app ID
     * @return the details of the app
     */
    public static AppResponse viewApp(String userAuthKey, String appId) {
        return oneSignal().viewApp(userAuthKey, appId);
    }

    /**
     * Creates a new OneSignal app.
     * @param userAuthKey OneSignal User Auth Key, available in Keys &amp; IDs.
     * @param app the app details for creation
     * @return the created app
     */
    public static AppResponse createApp(String userAuthKey, App app) {
        return oneSignal().createApp(userAuthKey, app);
    }

    /**
     * Updates the name or configuration settings of an existing OneSignal app.
     * <p>
     * Updating some platforms like Safari web push requires all parameters to be set (even if they are unchanged) in order for the update to be processed.
     * <ul>
     * <li>To update only your app name, you can pass in only a new app name parameter.</li>
     * <li>To update Android, be sure to pass in {@link App#gcmKey}.</li>
     * <li>To update Chrome Apps &amp; Extensions, be sure to pass in {@link App#chromeKey}.</li>
     * <li>To update Chrome web push, be sure to pass in {@link App#chromeWebOrigin}.</li>
     * <li>To update Safari web push, you must pass in all of these parameters: {@link App#safariApnsP12},
     * {@link App#safariApnsP12password}, {@link App#siteName}, and {@link App#safariSiteOrigin}. Most users use our
     * auto-generated Safari web ID. If you use our auto-generated Safari web ID, please set {@link App#safariApnsP12}
     * to {@code ""} and {@link App#safariApnsP12password} to {@code ""}.</li>
     * <li>To update iOS, you must pass in {@link App#apnsEnv} and {@link App#apnsP12}.</li>
     * </ul>
     * @param userAuthKey OneSignal User Auth Key, available in Keys &amp; IDs.
     * @param app the app details for update
     * @return the updated app
     */
    public static AppResponse updateApp(String userAuthKey, App app) {
        return oneSignal().updateApp(userAuthKey, app.getId(), app);
    }

    /**
     * View the details of multiple devices in one of your OneSignal apps.
     * <p>
     * <b>Unavailable for Apps &gt; 100,000 users</b>
     * <p>
     * For performance reasons, this method is not available for larger apps. Larger apps should use the CSV export API
     * endpoint, which is much more performant.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param appId The app ID that you want to view devices from
     * @param limit How many devices to return. Max is 300. Default is 300
     * @param offset Result offset. Default is 0. Results are sorted by id
     * @return object wrapping list of devices
     */
    public static ViewDevicesResponse viewDevices(String appAuthKey, String appId, Number limit, Number offset) {
        return oneSignal().viewDevices(appAuthKey, appId, limit, offset);
    }

    /**
     * View the details of an existing device in one of your OneSignal apps
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param appId Your app_id for this device
     * @param deviceId Player's OneSignal ID
     * @return details of the given device
     */
    public static ViewDeviceResponse viewDevice(String appAuthKey, String appId, String deviceId) {
        return oneSignal().viewDevice(appAuthKey, appId, deviceId);
    }

    /**
     * Register a new device to one of your OneSignal apps.
     * <p>
     * If a device is already registered with the specified identifier, then this will update the existing device record
     * instead of creating a new one.
     * @param device the device to create
     * @return The returned ID is a player / user ID. Use the returned ID to send push notifications to this specific
     * user later, or to include this player when sending to a set of users.
     */
    public static AddDeviceResponse addDevice(AddEditDeviceRequest device) {
        return oneSignal().addDevice(device);
    }

    /**
     * Update an existing device in one of your OneSignal apps.
     * <p>
     * To delete a tag, <i>include</i> its key and set its value to blank. Omitting a key/value will not delete it.
     * <p>
     * For example, if I wanted to delete two existing tanks {@code rank} and {@code category} while simultaneously
     * adding a new tag class, the tags JSON would look like the following:
     * <pre>
     * "tags": {
     *            "rank": "",
     *            "category": "",
     *            "class": "my_new_value"
     *         }
     * </pre>
     * @param deviceId The device's OneSignal ID
     * @param device the device to update
     * @return information whether the response was successful
     */
    public static SuccessResponse editDevice(String deviceId, AddEditDeviceRequest device) {
        return oneSignal().editDevice(deviceId, device);
    }

    /**
     * Update a device's session information.
     * <p>
     * This method should be called when a device opens your app after they are already registered. This method will
     * automatically increment the player's
     * {@link com.currencyfair.onesignal.model.player.Device#sessionCount sessionCount}, and should also be used to
     * update any fields that may have changed (such as
     * {@link com.currencyfair.onesignal.model.player.Device#language language} or
     * {@link com.currencyfair.onesignal.model.player.Device#timezone timezone}).
     * @param deviceId The device's OneSignal ID
     * @param session the new device's session
     * @return response with status
     */
    public static SuccessResponse newSession(String deviceId, Session session) {
        return oneSignal().newSession(deviceId, session);
    }

    /**
     * Track a new purchase in your app.
     * <p>
     * This will increment the player's {@link com.currencyfair.onesignal.model.player.Device#amountSpent amountSpent}.
     * @param deviceId The device's OneSignal ID
     * @param purchases object containing a list of purchases
     * @return response with status
     */
    public static SuccessResponse newPurchase(String deviceId, Purchases purchases) {
        return oneSignal().newPurchase(deviceId, purchases);
    }

    /**
     * Update a device's {@link com.currencyfair.onesignal.model.player.Device#playtime playtime} upon app resuming.
     * <p>
     * Call this method when the app is resumed or placed into from standby.
     * @param deviceId The device's OneSignal ID
     * @param activeTime The lesser of: The number of seconds since either: 1. this method was last called OR 2.
     * {@link OneSignal#newSession(String, Session)} or {@link OneSignal#addDevice(AddEditDeviceRequest)}
     * @return response with status
     */
    public static SuccessResponse incrementSessionLength(String deviceId, Long activeTime) {
        return oneSignal().incrementSessionLength(deviceId, activeTime);
    }

    /**
     * Generate a compressed CSV export of all of your current user data.
     * <p>
     * This method can be used to generate a compressed CSV export of all of your current user data. It is a much faster
     * alternative than retrieving this data using the {@link OneSignal#viewDevices(String, String, Number, Number)}
     * method.
     * <p>
     * You can test if it is complete by calling {@link OneSignal#csvExportFileDownload(URL, File)}. If the file is
     * not ready, a 404 error will be returned. Otherwise the file itself will be downloaded.
     * <p>
     * The file will be compressed using GZip.
     * <p>
     * The file may take several minutes to generate depending on the number of users in your app.
     * @param appAuthKey OneSignal App Auth Key, available in Keys &amp; IDs.
     * @param appId OneSignal App ID
     * @param csvExportFileLocationRequest the optional request object
     * @return object with the url to the CSV file
     */
    public static CsvExportFileLocationResponse csvExportFileLocation(String appAuthKey, String appId,
            CsvExportFileLocationRequest csvExportFileLocationRequest) {
        return oneSignal().csvExportLocation(
                appAuthKey,
                appId,
                csvExportFileLocationRequest == null ? new CsvExportFileLocationRequest() : csvExportFileLocationRequest
        );
    }

    /**
     * Download a file from {@code url} to the {@code location}.
     * @param url the url of the file to retrieve
     * @param location the path and filename where to save the file
     * @throws IOException if {@code url} cannot be opened
     * @throws IOException if {@code location} is a directory
     * @throws IOException if {@code location} cannot be written
     * @throws IOException if {@code location} needs creating but can't be
     * @throws IOException if an IO error occurs during copying
     */
    public static void csvExportFileDownload(URL url, File location) throws IOException {
        FileUtils.copyURLToFile(url, location);
    }

    private static OneSignalComms oneSignal() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.setSerializationInclusion(Include.NON_EMPTY);
        JacksonDecoder decoder = new JacksonDecoder(objectMapper);
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(decoder)
                .decode404()
                .errorDecoder(new OneSignalErrorDecoder(decoder))
                .logger(new Slf4jLogger())
                .logLevel(Level.FULL)
                .target(OneSignalComms.class, "https://onesignal.com/api/v1");
    }

}
