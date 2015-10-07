/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.pushnotifications.sender.microsoft;

import java.util.Iterator;
import java.util.List;

import org.jboss.aerogear.windows.mpns.MPNS;
import org.jboss.aerogear.windows.mpns.MpnsNotification;
import org.jboss.aerogear.windows.mpns.MpnsService;
import org.jboss.aerogear.windows.mpns.MpnsServiceBuilder;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.pushnotifications.sender.PushNotificationsSender;
import com.liferay.pushnotifications.util.PushNotificationsConstants;

/**
 * @author Silvio Santos
 * @author Bruno Farache
 */
public class MicrosoftPushNotificationsSender implements PushNotificationsSender {

	@Override
	public void reset() {
		_mpnsService = null;
	}

	@Override
	public void send(
			String platform, List<String> tokens, JSONObject payloadJSONObject)
		throws Exception {

		MpnsService mpnsService = getMpnsService();

		if (mpnsService == null) {
			return;
		}
		String body = payloadJSONObject.getString(
				PushNotificationsConstants.KEY_BODY);
		
		String title = "";
		
		if(payloadJSONObject.has(PushNotificationsConstants.KEY_TITLE)){ 
			title = payloadJSONObject.getString(PushNotificationsConstants.KEY_TITLE);
		}
		payloadJSONObject.remove(PushNotificationsConstants.KEY_TITLE);	
		payloadJSONObject.remove(PushNotificationsConstants.KEY_BODY);
		String payload = buildToast(payloadJSONObject);

		MpnsNotification toast = MPNS.newNotification().toast().title(title)
				.subtitle(body)
				.parameter(payload)
				.build();
		

		MpnsNotification tiles = MPNS.newNotification().tile().title(title)
				.count(1).backContent(body).callbackUri(payload)
				.backTitle(title).build();
		for(String token: tokens){
			mpnsService.push(token, tiles);
			mpnsService.push(token, toast);
		}
		
	}

	protected String buildToast(JSONObject payloadJSONObject) {

		String mpnsParam = "";
		String sep = "";
		Iterator<String> keys = payloadJSONObject.keys();

		while (keys.hasNext()) {
			String key = keys.next();

			mpnsParam += sep + key + "="+  payloadJSONObject.getString(key);
		}
		
		return mpnsParam;
	}

	protected MpnsService getMpnsService() throws Exception {
		if (_mpnsService == null) {
			MpnsServiceBuilder mpnsServiceBuilder = MPNS.newService();

			//mpnsService.delegate(new MpnsDelegateImpl());
			_mpnsService = mpnsServiceBuilder.build();
		}

		return _mpnsService;
	}

	private MpnsService _mpnsService;


}