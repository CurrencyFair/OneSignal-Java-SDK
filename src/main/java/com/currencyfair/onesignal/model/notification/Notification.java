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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;

/**
 * Represents a single notification with all of its properties.
 */
public class Notification {

    /**
     * Notification id.
     */
    private String id;

    // SEND TO SEGMENTS
    //
    // Segments are the most common way developers send notifications via OneSignal. Sending to segments is easy: you
    // simply specify which segments you want to send to, and, optionally, which ones you don't.

    /**
     * The segment names you want to target. Users in these segments will receive a notification.
     * This targeting parameter is only compatible with {@link #excludedSegments}.
     * <p>
     * Example: {@code ["Active Users", "Inactive Users"]}
     */
    @JsonProperty("included_segments")
    private List<String> includedSegments;

    /**
     * Segment that will be excluded when sending. Users in these segments will not receive a notification, even if they
     * were included in {@link #includedSegments}. This targeting parameter is only compatible with
     * {@link #includedSegments}.
     * <p>
     * Example: {@code ["Active Users", "Inactive Users"]}
     */
    @JsonProperty("excluded_segments")
    private List<String> excludedSegments;



    // SEND TO USERS BASED ON FILTERS

    /**
     * @see Filter
     */
    private List<Filter> filters;



    // SEND TO SPECIFIC DEVICES
    //
    // Finally, you may also target specific devices with the create notification method. Targeting devices is typically
    // used in two ways:
    // 1. For notifications that target individual users, such as if they've received a message from someone.
    // 2. For apps that wish to manage their own segments, such as tracking a user's followers and sending notifications
    // to them when that user posts.
    // When targeting specific devices, you may use any of the following parameters together:

    /**
     * RECOMMENDED - Specific players to send your notification to. <i>Does not require API Auth Key</i>.
     * <p>
     * Do not combine with other targeting parameters. Not compatible with any other targeting parameters.
     * <p>
     * Example: {@code ["1dd608f2-c6a1-11e3-851d-000c2940e62c"]}
     * <p>
     * <i>Limit of 2,000 entries per REST API call</i>
     */
    @JsonProperty("include_player_ids")
    private List<String> includePlayerIds;

    /**
     * RECOMMENDED - Target specific devices by custom user IDs assigned via API.
     * <p>
     * Do not combine with other targeting parameters. Not compatible with any other targeting parameters.
     * <p>
     * Example: {@code [“custom-id-assigned-by-api”]}
     * <p>
     * <i>Limit of 2,000 entries per REST API call</i>
     */
    @JsonProperty("include_external_user_ids")
    private List<String> includeExternalUserIds;



    // COMMON PARAMETERS
    //
    // The following are parameters in Create Notifications common to all methods of targeting users.

    /**
     * REQUIRED Your OneSignal application ID, which can be found in Keys &amp; IDs. It is a UUID and looks similar to
     * {@code 8250eaf6-1a58-489e-b136-7c74a864b434}.
     */
    @JsonProperty("app_id")
    private String appId;

    /**
     * REQUIRED Your User Auth Key, which can be found in Account.
     * <p>
     * {@code #appIds} contains an array of OneSignal app IDs. All users within these apps will receive at most one
     * notification.
     * <p>
     * Example: {@code ["2dd608f2-a6a1-11e3-251d-400c2940e62b", "2dd608f2-a6a1-11e3-251d-500f2950e61c"]}
     * <p>
     * IMPORTANT NOTE: No targeting parameters may be used when using the {@code #appIds} parameter. All subscribed
     * users will receive the notification.
     * <p>
     * ANDROID, iOS
     */
    @JsonProperty("app_ids")
    private List<String> appIds;



    // CONTENT & LANGUAGE
    //
    // The content you want to send in notifications.

    /**
     * REQUIRED unless {@link #contentAvailable contentAvailable=true} or {@link #templateId} is set.
     * <p>
     * The notification's content (excluding the title), a map of language codes to text for each language.
     * <p>
     * Each hash must have a language code string for a key, mapped to the localized text you would like users to
     * receive for that language. <b>English must be included in the hash</b>.
     * <p>
     * Example: {@code {"en": "English Message", "es": "Spanish Message"}}
     */
    private Map<String, String> contents;

    /**
     * The notification's title, a map of language codes to text for each language. Each hash must have a language code
     * string for a key, mapped to the localized text you would like users to receive for that language. A default title
     * may be displayed if a title is not provided.
     * <p>
     * Example: {@code {"en": "English Title", "es": "Spanish Title"}}
     */
    private Map<String, String> headings;

    /**
     * The notification's subtitle, a map of language codes to text for each language. Each hash must have a language
     * code string for a key, mapped to the localized text you would like users to receive for that language. A default
     * title may be displayed if a title is not provided.
     * <p>
     * Example: {@code {"en": "English Subtitle", "es": "Spanish Subtitle"}}
     * <p>
     * iOS 10+
     */
    private Map<String, String> subtitle;

    /**
     * Use a template you setup on our dashboard. You can override the template values by sending other parameters with
     * the request. The {@code #templateId} is the UUID found in the URL when viewing a template on our dashboard.
     * <p>
     * Example: {@code be4a8044-bbd6-11e4-a581-000c2940e62c}
     */
    @JsonProperty("template_id")
    private String templateId;

    /**
     * Sending {@code true} wakes your app to run custom native code (Apple interprets this as
     * {@code content-available=1}). Omit {@link #contents} field to make notification silent.
     * <p>
     * iOS
     */
    @JsonProperty("content_available")
    private Boolean contentAvailable;

    /**
     * Sending {@code true} allows you to change the notification content in your app before it is displayed. Triggers
     * {@code didReceive(_:withContentHandler:)} on your {@code UNNotificationServiceExtension}.
     * <p>
     * iOS 10+
     */
    @JsonProperty("mutable_content")
    private Boolean mutableContent;



    // ATTACHMENTS
    //
    // These are additional content attached to notifications, primarily images.

    /**
     * A custom map of data that is passed back to your app.
     * <p>
     * Example: {@code {"abc": "123", "foo": "bar"}}
     */
    private Map<String, String> data;

    /**
     * The URL to open in the browser when a user clicks on the notification.
     * <p>
     * Example: {@code https://www.google.com}
     */
    private String url;

    /**
     * Adds media attachments to notifications. Set as JSON object, key as a media id of your choice and the value as a
     * valid local file name or URL. User must press and hold on the notification to view.
     * <p>
     * Do not set {@link #mutableContent} to download attachments. The OneSignal SDK does this automatically.
     * <p>
     * Example: {@code {"id1": "https://domain.com/image.jpg"}}
     * <p>
     * iOS 10+
     */
    @JsonProperty("ios_attachments")
    private Map<String, String> iosAttachments;

    /**
     * Picture to display in the expanded view. Can be a drawable resource name or a URL.
     * <p>
     * ANDROID
     */
    @JsonProperty("big_picture")
    private String bigPicture;

    /**
     * Picture to display in the expanded view. Can be a drawable resource name or a URL.
     * <p>
     * AMAZON
     */
    @JsonProperty("adm_big_picture")
    private String admBigPicture;

    /**
     * Large picture to display below the notification text. Must be a local URL.
     * <p>
     * CHROMEAPP
     */
    @JsonProperty("chrome_big_picture")
    private String chromeBigPicture;



    // ACTION BUTTONS
    //
    // These add buttons to notifications, allowing the user to take more than one action on a notification.

    /**
     * Buttons to add to the notification.
     * <p>
     * iOS 8.0+, ANDROID 4.1+, AMAZON
     */
    @JsonDeserialize(using = ButtonCollectionDeserializer.class)
    private List<Button> buttons;

    /**
     * Add action buttons to the notification. The {@link Button#id} field is required.
     * <p>
     * CHROME 48+
     */
    @JsonDeserialize(using = ButtonCollectionDeserializer.class)
    @JsonProperty("web_buttons")
    private List<Button> webButtons;

    /**
     * Category APS payload, use with {@code registerUserNotificationSettings:categories} in your Objective-C / Swift
     * code.
     * <p>
     * Example: {@code calendar} category which contains actions like {@code accept} and {@code decline}
     * <p>
     * iOS 10+ This will trigger your {@code UNNotificationContentExtension} whose ID matches this category.
     * <p>
     * iOS
     */
    @JsonProperty("ios_category")
    private String iosCategory;



    // APPEARANCE
    //
    // These parameters let you adjust notification icons, sounds, badges, and other appearance changes to your
    // notifications.
    // Icons - Different platforms handle icons differently. Typically, the app icon is shown.
    // Sounds - By default, the device notification sound plays when a new notification arrives. You may alter this by
    // specifying a different sound asset.
    // Badges - shows the number of notifications outstanding. Note: Android badges are automatically handled by
    // OneSignal.

    /**
     * Allows setting a background image for the notification.
     * <p>
     * ANDROID
     */
    @JsonProperty("android_background_layout")
    private AndroidBackgroundLayout androidBackgroundLayout;

    /**
     * AMAZON
     */
    @JsonProperty("amazon_background_data")
    private String amazonBackgroundData;

    /**
     * If blank the app icon is used. Must be the drawable resource name.
     * <p>
     * ANDROID
     */
    @JsonProperty("small_icon")
    private String smallIcon;

    /**
     * If blank the {@link #smallIcon} is used. Can be a drawable resource name or a URL.
     * <p>
     * ANDROID
     */
    @JsonProperty("large_icon")
    private String largeIcon;

    /**
     * Sets the web push notification's icon. An image URL linking to a valid image. Common image types are supported;
     * GIF will not animate. We recommend 256x256 (at least 80x80) to display well on high DPI devices.
     * Firefox will also use this icon, unless you specify {@link #firefoxIcon}.
     * <p>
     * CHROME
     */
    @JsonProperty("chrome_web_icon")
    private String chromeWebIcon;

    /**
     * NOT RECOMMENDED Few people need to set Firefox-specific icons. We recommend setting {@link #chromeWebIcon}
     * instead, which Firefox will also use.
     * <p>
     * Sets the web push notification's icon for Firefox. An image URL linking to a valid image. Common image types are
     * supported; GIF will not animate. We recommend 256x256 (at least 80x80) to display well on high DPI devices.
     * <p>
     * FIREFOXs
     */
    @JsonProperty("firefox_icon")
    private String firefoxIcon;

    /**
     * Specific Amazon icon to use. If blank the app icon is used. Must be the drawable resource name.
     * <p>
     * ANDROID
     */
    @JsonProperty("adm_small_icon")
    private String admSmallIcon;

    /**
     * Specific Amazon icon to display to the left of the notification. If blank the {@link #admSmallIcon} is used.
     * Can be a drawable resource name or a URL.
     * <p>
     * ANDROID
     */
    @JsonProperty("adm_large_icon")
    private String admLargeIcon;

    /**
     * THIS FLAG IS NOT USED FOR WEB PUSH For web push, please see {@link #chromeWebIcon} instead.
     * <p>
     * The local URL to an icon to use. If blank, the app icon will be used.
     * <p>
     * CHROMEAPP
     */
    @JsonProperty("chrome_icon")
    private String chromeIcon;

    /**
     * Sound file that is included in your app to play instead of the default device notification sound. Pass "nil" to
     * disable vibration and sound for the notification.
     * <p>
     * Example: {@code "notification.wav"}
     * <p>
     * iOS
     */
    @JsonProperty("ios_sound")
    private String iosSound;

    /**
     * Sound file that is included in your app to play instead of the default device notification sound.
     * NOTE: Leave off file extension for Android.
     * <p>
     * Example: {@code "notification"}
     * <p>
     * ANDROID
     */
    @JsonProperty("android_sound")
    private String androidSound;

    /**
     * Sound file that is included in your app to play instead of the default device notification sound.
     * NOTE: Leave off file extension for Android.
     * <p>
     * Example: {@code "notification"}
     * <p>
     * AMAZON
     */
    @JsonProperty("adm_sound")
    private String admSound;

    /**
     * Sound file that is included in your app to play instead of the default device notification sound.
     * <p>
     * Example: {@code "notification.wav"}
     * <p>
     * WINDOWS PHONE 8.0
     */
    @JsonProperty("wp_sound")
    private String wpSound;

    /**
     * Sound file that is included in your app to play instead of the default device notification sound.
     * <p>
     * Example: {@code "notification.wav"}
     * <p>
     * WINDOWS PHONE 8.1+
     */
    @JsonProperty("wp_wns_sound")
    private String wpWnsSound;

    /**
     * Sets the devices LED notification light if the device has one. ARGB Hex format.
     * <p>
     * Example(Blue): {@code "FF0000FF"}
     * <p>
     * ANDROID
     */
    @JsonProperty("android_led_color")
    private String androidLedColor;

    /**
     * Sets the background color of the notification circle to the left of the notification text.
     * Only applies to apps targeting Android API level 21+ on Android 5.0+ devices.
     * <p>
     * Example(Red): {@code "FFFF0000"}
     * <p>
     * ANDROID
     */
    @JsonProperty("android_accent_color")
    private String androidAccentColor;

    /**
     * Sets the lock screen visibility for apps targeting Android API level 21+ running on Android 5.0+ devices.
     * <p>
     * ANDROID 5.0+
     */
    @JsonProperty("android_visibility")
    private AndroidVisibility androidVisibility;

    /**
     * Describes whether to set or increase/decrease your app's iOS badge count by the {@link #iosBadgeCount} specified
     * count.
     * <p>
     * iOS
     */
    @JsonProperty("ios_badgeType")
    private IosBadgeType iosBadgeType;

    /**
     * Used with {@link #iosBadgeType}, describes the value to set or amount to increase/decrease your app's iOS badge
     * count by.
     * <p>
     * You can use a negative number to decrease the badge count when used with an {@link #iosBadgeType} of
     * {@link IosBadgeType#INCREASE}.
     * <p>
     * iOS
     */
    @JsonProperty("ios_badgeCount")
    private Integer iosBadgeCount;

    /**
     * Only one notification with the same id will be shown on the device. Use the same id to update an existing
     * notification instead of showing a new one.
     * <p>
     * <i>This is known as {@code apns-collapse-id} on iOS and {@code collapse_key} on Android.</i>
     * <p>
     * iOS 10+, ANDROID
     */
    @JsonProperty("collapse_id")
    private String collapseId;



    // DELIVERY

    /**
     * Schedule notification for future delivery.
     * <p>
     * Examples: All examples are the exact same date &amp; time.
     * <p>
     * {@code "Thu Sep 24 2015 14:00:00 GMT-0700 (PDT)"}
     * <p>
     * {@code "September 24th 2015, 2:00:00 pm UTC-07:00"}
     * <p>
     * {@code "2015-09-24 14:00:00 GMT-0700"}
     * <p>
     * {@code "Sept 24 2015 14:00:00 GMT-0700"}
     * <p>
     * {@code "Thu Sep 24 2015 14:00:00 GMT-0700 (Pacific Daylight Time)"}
     */
    @JsonProperty("send_after")
    private String sendAfter;

    /**
     * Delivery schedule option.
     * <p>
     * If {@link #sendAfter} is used, this takes effect after the {@link #sendAfter} time has elapsed.
     */
    @JsonProperty("delayed_option")
    private DelayedOption delayedOption;

    /**
     * Use with {@link DelayedOption#TIMEZONE}.
     * <p>
     * Example: {@code "9:00AM"}
     */
    @JsonProperty("delivery_time_of_day")
    private String deliveryTimeOfDay;

    /**
     * Time To Live - In seconds. The notification will be expired if the device does not come back online within this
     * time. The default is 259,200 seconds (3 days).
     * <p>
     * iOS, ANDROID, CHROME, CHROMEWEB
     */
    private Integer ttl;

    /**
     * Delivery priority through the push server (example GCM/FCM). Pass {@code 10} for high priority. Defaults to
     * normal priority for Android and high for iOS. For Android 6.0+ devices setting priority to high will wake the
     * device out of doze mode.
     * <p>
     * iOS, ANDROID, CHROME, CHROMEWEB
     */
    private Integer priority;



    // GROUPING & COLLAPSING
    //
    // Grouping lets you combine multiple notifications into a single notification to improve the user experience.
    // Collapsing lets you dismiss old notifications in favor of newer ones.

    /**
     * All notifications with the same group will be stacked together using Android's Notification Stacking feature.
     * <p>
     * ANDROID
     */
    @JsonProperty("android_group")
    private String androidGroup;

    /**
     * Summary message to display when 2+ notifications are stacked together. Default is "# new messages".
     * Include $[notif_count] in your message and it will be replaced with the current number.
     * <p>
     * <b>Languages</b> - The value of each key is the message that will be sent to users for that language.
     * "en" (English) is required. The key of each hash is either a 2 character language code or one of
     * zh-Hans/zh-Hant for Simplified or Traditional Chinese.
     * <p>
     * Example: {@code {"en": "You have $[notif_count] new messages"}}
     * <p>
     * ANDROID
     */
    @JsonProperty("android_group_message")
    private Map<String, String> androidGroupMessage;

    /**
     * All notifications with the same group will be stacked together using Android's Notification Stacking feature.
     * <p>
     * AMAZON
     */
    @JsonProperty("adm_group")
    private String admGroup;

    /**
     * Summary message to display when 2+ notifications are stacked together. Default is "# new messages".
     * Include $[notif_count] in your message and it will be replaced with the current number.
     * "en" (English) is required. The key of each hash is either a a 2 character language code or one of
     * zh-Hans/zh-Hant for Simplified or Traditional Chinese. The value of each key is the message that will be sent
     * to users for that language.
     * <p>
     * Example: {@code {"en": "You have $[notif_count] new messages"}}
     * <p>
     * AMAZON
     */
    @JsonProperty("adm_group_message")
    private Map<String, String> admGroupMessage;



    // PLATFORM TO DELIVER TO
    //
    // By default, OneSignal will send to every platform (each of these is true).
    // To only send to specific platforms, you may pass in true on one or more of these parameters corresponding to
    // the platform you wish to send to. If you do so, all other platforms will be set to false and will not be
    // delivered to.

    /**
     * Indicates whether to send to all devices registered under your app's Apple iOS platform.
     * <p>
     * iOS
     */
    @JsonProperty("isIos")
    private Boolean ios;

    /**
     * Indicates whether to send to all devices registered under your app's Google Android platform.
     * <p>
     * ANDROID
     */
    @JsonProperty("isAndroid")
    private Boolean android;

    /**
     * Indicates whether to send to all subscribed web browser users, including Chrome, Firefox, and Safari.
     * You may use this instead as a combined flag instead of separately enabling {@link #chromeWeb},
     * {@link #firefox}, and {@link #safari}, though the three options are equivalent to this one.
     */
    @JsonProperty("isAnyWeb")
    private Boolean anyWeb;

    /**
     * Indicates whether to send to all Google Chrome, Chrome on Android, and Mozilla Firefox users registered under
     * your Chrome &amp; Firefox web push platform.
     * <p>
     * WEB
     */
    @JsonProperty("isChromeWeb")
    private Boolean chromeWeb;

    /**
     * Indicates whether to send to all Mozilla Firefox desktop users registered under your Firefox web push platform.
     * <p>
     * WEB
     */
    @JsonProperty("isFirefox")
    private Boolean firefox;

    /**
     * DOES NOT SUPPORT IOS SAFARI Indicates whether to send to all Apple's Safari desktop users registered under your
     * Safari web push platform.
     * <p>
     * WEB
     */
    @JsonProperty("isSafari")
    private Boolean safari;

    /**
     * Indicates whether to send to all devices registered under your app's Windows Phone 8.0 platform.
     * <p>
     * WINDOWS PHONE 8.0
     */
    @JsonProperty("isWP")
    private Boolean wp;

    /**
     * Indicates whether to send to all devices registered under your app's Windows Phone 8.1+ platform.
     * <p>
     * WINDOWS PHONE 8.1+
     */
    @JsonProperty("isWP_WNS")
    private Boolean wpwns;

    /**
     * Indicates whether to send to all devices registered under your app's Amazon Fire platform.
     * <p>
     * AMAZON
     */
    @JsonProperty("isAdm")
    private Boolean adm;

    /**
     * THIS FLAG IS NOT USED FOR WEB PUSH Please see {@link #chromeWeb} for sending to web push users. This flag only
     * applies to Google Chrome Apps &amp; Extensions.
     * <p>
     * Indicates whether to send to all devices registered under your app's Google Chrome Apps &amp; Extension platform.
     * <p>
     * CHROMEAPP
     */
    @JsonProperty("isChrome")
    private Boolean chrome;

    /**
     * Use this if you have client side Android Oreo Channels you have already defined in your app with code.
     * <p>
     * ANDROID
     */
    @JsonProperty("existing_android_channel_id")
    private String existingAndroidChannelId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getIncludedSegments() {
        return includedSegments;
    }

    public void setIncludedSegments(List<String> includedSegments) {
        this.includedSegments = includedSegments;
    }

    public List<String> getExcludedSegments() {
        return excludedSegments;
    }

    public void setExcludedSegments(List<String> excludedSegments) {
        this.excludedSegments = excludedSegments;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<String> getIncludePlayerIds() {
        return includePlayerIds;
    }

    public void setIncludePlayerIds(List<String> includePlayerIds) {
        this.includePlayerIds = includePlayerIds;
    }

    public List<String> getIncludeExternalUserIds() {
        return includeExternalUserIds;
    }

    public void setIncludeExternalUserIds(List<String> externalUserIds) {
        this.includeExternalUserIds = includeExternalUserIds;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<String> getAppIds() {
        return appIds;
    }

    public void setAppIds(List<String> appIds) {
        this.appIds = appIds;
    }

    public Map<String, String> getContents() {
        return contents;
    }

    public void setContents(Map<String, String> contents) {
        this.contents = contents;
    }

    public Map<String, String> getHeadings() {
        return headings;
    }

    public void setHeadings(Map<String, String> headings) {
        this.headings = headings;
    }

    public Map<String, String> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Map<String, String> subtitle) {
        this.subtitle = subtitle;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Boolean getContentAvailable() {
        return contentAvailable;
    }

    public void setContentAvailable(Boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
    }

    public Boolean getMutableContent() {
        return mutableContent;
    }

    public void setMutableContent(Boolean mutableContent) {
        this.mutableContent = mutableContent;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getIosAttachments() {
        return iosAttachments;
    }

    public void setIosAttachments(Map<String, String> iosAttachments) {
        this.iosAttachments = iosAttachments;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBigPicture() {
        return bigPicture;
    }

    public void setBigPicture(String bigPicture) {
        this.bigPicture = bigPicture;
    }

    public String getAdmBigPicture() {
        return admBigPicture;
    }

    public void setAdmBigPicture(String admBigPicture) {
        this.admBigPicture = admBigPicture;
    }

    public String getChromeBigPicture() {
        return chromeBigPicture;
    }

    public void setChromeBigPicture(String chromeBigPicture) {
        this.chromeBigPicture = chromeBigPicture;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public List<Button> getWebButtons() {
        return webButtons;
    }

    public void setWebButtons(List<Button> webButtons) {
        this.webButtons = webButtons;
    }

    public String getIosCategory() {
        return iosCategory;
    }

    public void setIosCategory(String iosCategory) {
        this.iosCategory = iosCategory;
    }

    public AndroidBackgroundLayout getAndroidBackgroundLayout() {
        return androidBackgroundLayout;
    }

    public void setAndroidBackgroundLayout(AndroidBackgroundLayout androidBackgroundLayout) {
        this.androidBackgroundLayout = androidBackgroundLayout;
    }

    public String getAmazonBackgroundData() {
        return amazonBackgroundData;
    }

    public void setAmazonBackgroundData(String amazonBackgroundData) {
        this.amazonBackgroundData = amazonBackgroundData;
    }

    public String getSmallIcon() {
        return smallIcon;
    }

    public void setSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public void setLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
    }

    public String getChromeWebIcon() {
        return chromeWebIcon;
    }

    public void setChromeWebIcon(String chromeWebIcon) {
        this.chromeWebIcon = chromeWebIcon;
    }

    public String getFirefoxIcon() {
        return firefoxIcon;
    }

    public void setFirefoxIcon(String firefoxIcon) {
        this.firefoxIcon = firefoxIcon;
    }

    public String getAdmSmallIcon() {
        return admSmallIcon;
    }

    public void setAdmSmallIcon(String admSmallIcon) {
        this.admSmallIcon = admSmallIcon;
    }

    public String getAdmLargeIcon() {
        return admLargeIcon;
    }

    public void setAdmLargeIcon(String admLargeIcon) {
        this.admLargeIcon = admLargeIcon;
    }

    public String getChromeIcon() {
        return chromeIcon;
    }

    public void setChromeIcon(String chromeIcon) {
        this.chromeIcon = chromeIcon;
    }

    public String getIosSound() {
        return iosSound;
    }

    public void setIosSound(String iosSound) {
        this.iosSound = iosSound;
    }

    public String getAndroidSound() {
        return androidSound;
    }

    public void setAndroidSound(String androidSound) {
        this.androidSound = androidSound;
    }

    public String getAdmSound() {
        return admSound;
    }

    public void setAdmSound(String admSound) {
        this.admSound = admSound;
    }

    public String getWpSound() {
        return wpSound;
    }

    public void setWpSound(String wpSound) {
        this.wpSound = wpSound;
    }

    public String getWpWnsSound() {
        return wpWnsSound;
    }

    public void setWpWnsSound(String wpWnsSound) {
        this.wpWnsSound = wpWnsSound;
    }

    public String getAndroidLedColor() {
        return androidLedColor;
    }

    public void setAndroidLedColor(String androidLedColor) {
        this.androidLedColor = androidLedColor;
    }

    public String getAndroidAccentColor() {
        return androidAccentColor;
    }

    public void setAndroidAccentColor(String androidAccentColor) {
        this.androidAccentColor = androidAccentColor;
    }

    public AndroidVisibility getAndroidVisibility() {
        return androidVisibility;
    }

    public void setAndroidVisibility(AndroidVisibility androidVisibility) {
        this.androidVisibility = androidVisibility;
    }

    public IosBadgeType getIosBadgeType() {
        return iosBadgeType;
    }

    public void setIosBadgeType(IosBadgeType iosBadgeType) {
        this.iosBadgeType = iosBadgeType;
    }

    public Integer getIosBadgeCount() {
        return iosBadgeCount;
    }

    public void setIosBadgeCount(Integer iosBadgeCount) {
        this.iosBadgeCount = iosBadgeCount;
    }

    public String getCollapseId() {
        return collapseId;
    }

    public void setCollapseId(String collapseId) {
        this.collapseId = collapseId;
    }

    public String getSendAfter() {
        return sendAfter;
    }

    public void setSendAfter(String sendAfter) {
        this.sendAfter = sendAfter;
    }

    public DelayedOption getDelayedOption() {
        return delayedOption;
    }

    public void setDelayedOption(DelayedOption delayedOption) {
        this.delayedOption = delayedOption;
    }

    public String getDeliveryTimeOfDay() {
        return deliveryTimeOfDay;
    }

    public void setDeliveryTimeOfDay(String deliveryTimeOfDay) {
        this.deliveryTimeOfDay = deliveryTimeOfDay;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getAndroidGroup() {
        return androidGroup;
    }

    public void setAndroidGroup(String androidGroup) {
        this.androidGroup = androidGroup;
    }

    public Map<String, String> getAndroidGroupMessage() {
        return androidGroupMessage;
    }

    public void setAndroidGroupMessage(Map<String, String> androidGroupMessage) {
        this.androidGroupMessage = androidGroupMessage;
    }

    public String getAdmGroup() {
        return admGroup;
    }

    public void setAdmGroup(String admGroup) {
        this.admGroup = admGroup;
    }

    public Map<String, String> getAdmGroupMessage() {
        return admGroupMessage;
    }

    public void setAdmGroupMessage(Map<String, String> admGroupMessage) {
        this.admGroupMessage = admGroupMessage;
    }

    public Boolean getIos() {
        return ios;
    }

    public void setIos(Boolean ios) {
        this.ios = ios;
    }

    public Boolean getAndroid() {
        return android;
    }

    public void setAndroid(Boolean android) {
        this.android = android;
    }

    public Boolean getAnyWeb() {
        return anyWeb;
    }

    public void setAnyWeb(Boolean anyWeb) {
        this.anyWeb = anyWeb;
    }

    public Boolean getChromeWeb() {
        return chromeWeb;
    }

    public void setChromeWeb(Boolean chromeWeb) {
        this.chromeWeb = chromeWeb;
    }

    public Boolean getFirefox() {
        return firefox;
    }

    public void setFirefox(Boolean firefox) {
        this.firefox = firefox;
    }

    public Boolean getSafari() {
        return safari;
    }

    public void setSafari(Boolean safari) {
        this.safari = safari;
    }

    public Boolean getWp() {
        return wp;
    }

    public void setWp(Boolean wp) {
        this.wp = wp;
    }

    public Boolean getWpwns() {
        return wpwns;
    }

    public void setWpwns(Boolean wpwns) {
        this.wpwns = wpwns;
    }

    public Boolean getAdm() {
        return adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public Boolean getChrome() {
        return chrome;
    }

    public void setChrome(Boolean chrome) {
        this.chrome = chrome;
    }

    public void setExistingAndroidChannelId(String channelId) {
        this.existingAndroidChannelId = channelId;
    }

    public String getExistingAndroidChannelId() {
        return existingAndroidChannelId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
