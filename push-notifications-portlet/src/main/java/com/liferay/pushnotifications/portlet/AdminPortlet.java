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

package com.liferay.pushnotifications.portlet;

import java.io.IOException;
import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.pushnotifications.model.Application;
import com.liferay.pushnotifications.service.ApplicationLocalServiceUtil;
import com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil;
import com.liferay.pushnotifications.util.PortletPropsKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Bruno Farache
 */
public class AdminPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		
		String cmd = ParamUtil.getString(
				renderRequest,  Constants.CMD, "");
		String type = ParamUtil.getString(
				renderRequest,  "type", "");
		if(cmd.equals(Constants.ADD) && type.equals("app")){
			Long appId = ParamUtil.getLong(
					renderRequest,  "appId", 0);
			
			renderRequest.setAttribute("appId", appId);
			super.viewTemplate = "/html/admin/editApp.jsp";
		}else{
			super.viewTemplate = "/html/admin/view.jsp";
		}
		super.doView(renderRequest, renderResponse);
	}

	public void updateApplication(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	
		
		Long appId = ParamUtil.getLong(
				actionRequest, "appId", 0);
		
		String appName = ParamUtil.getString(actionRequest, "applicationName", "");
		
		Application app = null;
		if(appId == 0){
			app = addApplication(actionRequest, appName);
		}
		
		actionResponse.setRenderParameter("appId", ""+app.getApplicationId());
		actionResponse.setRenderParameter(Constants.CMD, Constants.ADD);
		actionResponse.setRenderParameter("type", "app");
	}
	
	private Application addApplication(ActionRequest actionRequest, String appName){

		User u = (User)actionRequest.getAttribute(WebKeys.USER);
		return ApplicationLocalServiceUtil.updateApplication(appName, u);
		
		
	}
	
	
	private void updateApplication(){
		
	}
	
	public void updatePortletPreferences(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletPreferences portletPreferences = PrefsPropsUtil.getPreferences();

		String androidApiKey = ParamUtil.getString(
			actionRequest, "androidApiKey");

		portletPreferences.setValue(
			PortletPropsKeys.ANDROID_API_KEY, androidApiKey);

		int androidRetries = ParamUtil.getInteger(
			actionRequest, "androidRetries");

		portletPreferences.setValue(
			PortletPropsKeys.ANDROID_RETRIES, String.valueOf(androidRetries));

		String appleCertificatePassword = ParamUtil.getString(
			actionRequest, "appleCertificatePassword");

		portletPreferences.setValue(
			PortletPropsKeys.APPLE_CERTIFICATE_PASSWORD,
			appleCertificatePassword);

		String appleCertificatePath = ParamUtil.getString(
			actionRequest, "appleCertificatePath");

		portletPreferences.setValue(
			PortletPropsKeys.APPLE_CERTIFICATE_PATH, appleCertificatePath);

		boolean appleSandbox = ParamUtil.getBoolean(
			actionRequest, "appleSandbox");

		portletPreferences.setValue(
			PortletPropsKeys.APPLE_SANDBOX, String.valueOf(appleSandbox));

		portletPreferences.store();

		PushNotificationsDeviceLocalServiceUtil.resetPushNotificationSenders();
	}

	
	public void deleteDevice(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		long pushid = ParamUtil.getLong(
				actionRequest, "pushId");
		try{
			PushNotificationsDeviceLocalServiceUtil.deletePushNotificationsDevice(pushid);
			SessionMessages.add(actionRequest, "success");
		}catch(Exception e){
			
		}
		
	}
}