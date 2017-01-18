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

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Convenient class for creating {@link NotificationRequest}.
 */
public final class NotificationRequestBuilder {

    private String id;
    private Boolean opened;
    private Long limit;
    private Long offset;
    private List<String> includedSegments = new ArrayList<>();
    private List<String> excludedSegments = new ArrayList<>();
    private List<Filter> filters = new ArrayList<>();
    private List<String> includePlayerIds = new ArrayList<>();
    private String appId;
    private List<String> appIds;
    private Map<String, String> contents = new HashMap<>();
    private Map<String, String> headings = new HashMap<>();
    private Map<String, String> subtitle = new HashMap<>();
    private String templateId;
    private Boolean contentAvailable;
    private Boolean mutableContent;
    private Map<String, String> data = new HashMap<>();
    private String url;
    private Map<String, String> iosAttachments = new HashMap<>();
    private String bigPicture;
    private String admBigPicture;
    private String chromeBigPicture;
    private List<Button> buttons = new ArrayList<>();
    private List<Button> webButtons = new ArrayList<>();
    private String iosCategory;
    private AndroidBackgroundLayout androidBackgroundLayout;
    private String amazonBackgroundData;
    private String smallIcon;
    private String largeIcon;
    private String chromeWebIcon;
    private String firefoxIcon;
    private String admSmallIcon;
    private String admLargeIcon;
    private String chromeIcon;
    private String iosSound;
    private String androidSound;
    private String admSound;
    private String wpSound;
    private String wpWnsSound;
    private String androidLedColor;
    private String androidAccentColor;
    private AndroidVisibility androidVisibility;
    private IosBadgeType iosBadgeType;
    private Integer iosBadgeCount;
    private String collapseId;
    private String sendAfter;
    private DelayedOption delayedOption;
    private String deliveryTimeOfDay;
    private Integer ttl;
    private Integer priority;
    private String androidGroup;
    private Map<String, String> androidGroupMessage = new HashMap<>();
    private String admGroup;
    private Map<String, String> admGroupMessage = new HashMap<>();
    private Boolean ios;
    private Boolean android;
    private Boolean anyWeb;
    private Boolean chromeWeb;
    private Boolean firefox;
    private Boolean safari;
    private Boolean wp;
    private Boolean wpwns;
    private Boolean adm;
    private Boolean chrome;

    private NotificationRequestBuilder() {
    }

    public static NotificationRequestBuilder aNotificationRequest() {
        return new NotificationRequestBuilder();
    }

    public NotificationRequestBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public NotificationRequestBuilder withOpened(Boolean opened) {
        this.opened = opened;
        return this;
    }

    public NotificationRequestBuilder withLimit(Long limit) {
        this.limit = limit;
        return this;
    }

    public NotificationRequestBuilder withOffset(Long offset) {
        this.offset = offset;
        return this;
    }

    public NotificationRequestBuilder withIncludedSegments(List<String> includedSegments) {
        this.includedSegments = includedSegments;
        return this;
    }

    public NotificationRequestBuilder withIncludedSegment(String includedSegment) {
        if (StringUtils.isNotBlank(includedSegment)) {
            includedSegments.add(includedSegment);
        }
        return this;
    }

    public NotificationRequestBuilder withExcludedSegments(List<String> excludedSegments) {
        this.excludedSegments = excludedSegments;
        return this;
    }

    public NotificationRequestBuilder withExcludedSegment(String excludedSegment) {
        if (StringUtils.isNotBlank(excludedSegment)) {
            excludedSegments.add(excludedSegment);
        }
        return this;
    }

    public NotificationRequestBuilder withFilters(List<Filter> filters) {
        this.filters = filters;
        return this;
    }

    public NotificationRequestBuilder withFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public NotificationRequestBuilder withIncludePlayerIds(List<String> includePlayerIds) {
        this.includePlayerIds = includePlayerIds;
        return this;
    }

    public NotificationRequestBuilder withIncludePlayerId(String includePlayerId) {
        if (StringUtils.isNotBlank(includePlayerId)) {
            includePlayerIds.add(includePlayerId);
        }
        return this;
    }

    public NotificationRequestBuilder withAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public NotificationRequestBuilder withAppIds(List<String> appIds) {
        this.appIds = appIds;
        return this;
    }

    public NotificationRequestBuilder withContents(Map<String, String> contents) {
        this.contents = contents;
        return this;
    }

    public NotificationRequestBuilder withContent(String language, String value) {
        if (StringUtils.isNotBlank(value)) {
            contents.put(language, value);
        }
        return this;
    }

    public NotificationRequestBuilder withHeadings(Map<String, String> headings) {
        this.headings = headings;
        return this;
    }

    public NotificationRequestBuilder withHeading(String language, String value) {
        if (StringUtils.isNotBlank(value)) {
            headings.put(language, value);
        }
        return this;
    }

    public NotificationRequestBuilder withSubtitles(Map<String, String> subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public NotificationRequestBuilder withSubtitle(String language, String value) {
        if (StringUtils.isNotBlank(value)) {
            subtitle.put(language, value);
        }
        return this;
    }

    public NotificationRequestBuilder withTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public NotificationRequestBuilder withMutableContent(Boolean mutableContent) {
        this.mutableContent = mutableContent;
        return this;
    }

    public NotificationRequestBuilder withContentAvailable(Boolean contentAvailable) {
        this.contentAvailable = contentAvailable;
        return this;
    }

    public NotificationRequestBuilder withData(Map<String, String> data) {
        this.data = data;
        return this;
    }

    public NotificationRequestBuilder withDataElement(String key, String value) {
        data.put(key, value);
        return this;
    }

    public NotificationRequestBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public NotificationRequestBuilder withIosAttachments(Map<String, String> iosAttachments) {
        this.iosAttachments = iosAttachments;
        return this;
    }

    public NotificationRequestBuilder withIosAttachment(String key, String value) {
        iosAttachments.put(key, value);
        return this;
    }

    public NotificationRequestBuilder withBigPicture(String bigPicture) {
        this.bigPicture = bigPicture;
        return this;
    }

    public NotificationRequestBuilder withAdmBigPicture(String admBigPicture) {
        this.admBigPicture = admBigPicture;
        return this;
    }

    public NotificationRequestBuilder withChromeBigPicture(String chromeBigPicture) {
        this.chromeBigPicture = chromeBigPicture;
        return this;
    }

    public NotificationRequestBuilder withButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public NotificationRequestBuilder withButton(Button button) {
        buttons.add(button);
        return this;
    }

    public NotificationRequestBuilder withWebButtons(List<Button> webButtons) {
        this.webButtons = webButtons;
        return this;
    }

    public NotificationRequestBuilder withWebButton(Button button) {
        webButtons.add(button);
        return this;
    }

    public NotificationRequestBuilder withIosCategory(String iosCategory) {
        this.iosCategory = iosCategory;
        return this;
    }

    public NotificationRequestBuilder withAndroidBackgroudLayout(AndroidBackgroundLayout androidBackgroundLayout) {
        this.androidBackgroundLayout = androidBackgroundLayout;
        return this;
    }

    public NotificationRequestBuilder withAmazonBackgroundData(String amazonBackgroundData) {
        this.amazonBackgroundData = amazonBackgroundData;
        return this;
    }

    public NotificationRequestBuilder withSmallIcon(String smallIcon) {
        this.smallIcon = smallIcon;
        return this;
    }

    public NotificationRequestBuilder withLargeIcon(String largeIcon) {
        this.largeIcon = largeIcon;
        return this;
    }

    public NotificationRequestBuilder withChromeWebIcon(String chromeWebIcon) {
        this.chromeWebIcon = chromeWebIcon;
        return this;
    }

    public NotificationRequestBuilder withFirefoxIcon(String firefoxIcon) {
        this.firefoxIcon = firefoxIcon;
        return this;
    }

    public NotificationRequestBuilder withAdmSmallIcon(String admSmallIcon) {
        this.admSmallIcon = admSmallIcon;
        return this;
    }

    public NotificationRequestBuilder withAdmLargeIcon(String admLargeIcon) {
        this.admLargeIcon = admLargeIcon;
        return this;
    }

    public NotificationRequestBuilder withChromeIcon(String chromeIcon) {
        this.chromeIcon = chromeIcon;
        return this;
    }

    public NotificationRequestBuilder withIosSound(String iosSound) {
        this.iosSound = iosSound;
        return this;
    }

    public NotificationRequestBuilder withAndroidSound(String androidSound) {
        this.androidSound = androidSound;
        return this;
    }

    public NotificationRequestBuilder withAdmSound(String admSound) {
        this.admSound = admSound;
        return this;
    }

    public NotificationRequestBuilder withWpSound(String wpSound) {
        this.wpSound = wpSound;
        return this;
    }

    public NotificationRequestBuilder withWpWnsSound(String wpWnsSound) {
        this.wpWnsSound = wpWnsSound;
        return this;
    }

    public NotificationRequestBuilder withAndroidLedColor(String androidLedColor) {
        this.androidLedColor = androidLedColor;
        return this;
    }

    public NotificationRequestBuilder withAndroidAccentColor(String androidAccentColor) {
        this.androidAccentColor = androidAccentColor;
        return this;
    }

    public NotificationRequestBuilder withAndroidVisibility(AndroidVisibility androidVisibility) {
        this.androidVisibility = androidVisibility;
        return this;
    }

    public NotificationRequestBuilder withIosBadgeType(IosBadgeType iosBadgeType) {
        this.iosBadgeType = iosBadgeType;
        return this;
    }

    public NotificationRequestBuilder withIosBadgeCount(Integer iosBadgeCount) {
        this.iosBadgeCount = iosBadgeCount;
        return this;
    }

    public NotificationRequestBuilder withCollapseId(String collapseId) {
        this.collapseId = collapseId;
        return this;
    }

    public NotificationRequestBuilder withSendAfter(String sendAfter) {
        this.sendAfter = sendAfter;
        return this;
    }

    public NotificationRequestBuilder withDelayedOption(DelayedOption delayedOption) {
        this.delayedOption = delayedOption;
        return this;
    }

    public NotificationRequestBuilder withDeliveryTimeOfDay(String deliveryTimeOfDay) {
        this.deliveryTimeOfDay = deliveryTimeOfDay;
        return this;
    }

    public NotificationRequestBuilder withTtl(Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    public NotificationRequestBuilder withPriority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public NotificationRequestBuilder withAndroidGroup(String androidGroup) {
        this.androidGroup = androidGroup;
        return this;
    }

    public NotificationRequestBuilder withAndroidGroupMessages(Map<String, String> androidGroupMessage) {
        this.androidGroupMessage = androidGroupMessage;
        return this;
    }

    public NotificationRequestBuilder withAndroidGroupMessage(String language, String value) {
        if (StringUtils.isNotBlank(value)) {
            androidGroupMessage.put(language, value);
        }
        return this;
    }

    public NotificationRequestBuilder withAdmGroup(String admGroup) {
        this.admGroup = admGroup;
        return this;
    }

    public NotificationRequestBuilder withAdmGroupMessages(Map<String, String> admGroupMessage) {
        this.admGroupMessage = admGroupMessage;
        return this;
    }

    public NotificationRequestBuilder withAdmGroupMessage(String language, String value) {
        if (StringUtils.isNotBlank(value)) {
            admGroupMessage.put(language, value);
        }
        return this;
    }

    public NotificationRequestBuilder withIos(Boolean ios) {
        this.ios = ios;
        return this;
    }

    public NotificationRequestBuilder withAndroid(Boolean android) {
        this.android = android;
        return this;
    }

    public NotificationRequestBuilder withAnyWeb(Boolean anyWeb) {
        this.anyWeb = anyWeb;
        return this;
    }

    public NotificationRequestBuilder withChromeWeb(Boolean chromeWeb) {
        this.chromeWeb = chromeWeb;
        return this;
    }

    public NotificationRequestBuilder withFirefox(Boolean firefox) {
        this.firefox = firefox;
        return this;
    }

    public NotificationRequestBuilder withSafari(Boolean safari) {
        this.safari = safari;
        return this;
    }

    public NotificationRequestBuilder withWp(Boolean wp) {
        this.wp = wp;
        return this;
    }

    public NotificationRequestBuilder withWpwns(Boolean wpwns) {
        this.wpwns = wpwns;
        return this;
    }

    public NotificationRequestBuilder withAdm(Boolean adm) {
        this.adm = adm;
        return this;
    }

    public NotificationRequestBuilder withChrome(Boolean chrome) {
        this.chrome = chrome;
        return this;
    }

    public NotificationRequest build() {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setId(id);
        notificationRequest.setOpened(opened);
        notificationRequest.setLimit(limit);
        notificationRequest.setOffset(offset);
        notificationRequest.setIncludedSegments(includedSegments);
        notificationRequest.setExcludedSegments(excludedSegments);
        notificationRequest.setFilters(filters);
        notificationRequest.setIncludePlayerIds(includePlayerIds);
        notificationRequest.setAppId(appId);
        notificationRequest.setAppIds(appIds);
        notificationRequest.setContents(contents);
        notificationRequest.setHeadings(headings);
        notificationRequest.setSubtitle(subtitle);
        notificationRequest.setTemplateId(templateId);
        notificationRequest.setContentAvailable(contentAvailable);
        notificationRequest.setMutableContent(mutableContent);
        notificationRequest.setData(data);
        notificationRequest.setUrl(url);
        notificationRequest.setIosAttachments(iosAttachments);
        notificationRequest.setBigPicture(bigPicture);
        notificationRequest.setAdmBigPicture(admBigPicture);
        notificationRequest.setChromeBigPicture(chromeBigPicture);
        notificationRequest.setButtons(buttons);
        notificationRequest.setWebButtons(webButtons);
        notificationRequest.setIosCategory(iosCategory);
        notificationRequest.setAndroidBackgroundLayout(androidBackgroundLayout);
        notificationRequest.setAmazonBackgroundData(amazonBackgroundData);
        notificationRequest.setSmallIcon(smallIcon);
        notificationRequest.setLargeIcon(largeIcon);
        notificationRequest.setChromeWebIcon(chromeWebIcon);
        notificationRequest.setFirefoxIcon(firefoxIcon);
        notificationRequest.setAdmSmallIcon(admSmallIcon);
        notificationRequest.setAdmLargeIcon(admLargeIcon);
        notificationRequest.setChromeIcon(chromeIcon);
        notificationRequest.setIosSound(iosSound);
        notificationRequest.setAndroidSound(androidSound);
        notificationRequest.setAdmSound(admSound);
        notificationRequest.setWpSound(wpSound);
        notificationRequest.setWpWnsSound(wpWnsSound);
        notificationRequest.setAndroidLedColor(androidLedColor);
        notificationRequest.setAndroidAccentColor(androidAccentColor);
        notificationRequest.setAndroidVisibility(androidVisibility);
        notificationRequest.setIosBadgeType(iosBadgeType);
        notificationRequest.setIosBadgeCount(iosBadgeCount);
        notificationRequest.setCollapseId(collapseId);
        notificationRequest.setSendAfter(sendAfter);
        notificationRequest.setDelayedOption(delayedOption);
        notificationRequest.setDeliveryTimeOfDay(deliveryTimeOfDay);
        notificationRequest.setTtl(ttl);
        notificationRequest.setPriority(priority);
        notificationRequest.setAndroidGroup(androidGroup);
        notificationRequest.setAndroidGroupMessage(androidGroupMessage);
        notificationRequest.setAdmGroup(admGroup);
        notificationRequest.setAdmGroupMessage(admGroupMessage);
        notificationRequest.setIos(ios);
        notificationRequest.setAndroid(android);
        notificationRequest.setAnyWeb(anyWeb);
        notificationRequest.setChromeWeb(chromeWeb);
        notificationRequest.setFirefox(firefox);
        notificationRequest.setSafari(safari);
        notificationRequest.setWp(wp);
        notificationRequest.setWpwns(wpwns);
        notificationRequest.setAdm(adm);
        notificationRequest.setChrome(chrome);
        return notificationRequest;
    }
}
