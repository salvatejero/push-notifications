<%--
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
--%>
<%@ include file="../../init.jsp" %>

<%
String androidApiKey = PrefsPropsUtil.getString(PortletPropsKeys.ANDROID_API_KEY, PortletPropsValues.ANDROID_API_KEY);
int androidRetries = PrefsPropsUtil.getInteger(PortletPropsKeys.ANDROID_RETRIES, PortletPropsValues.ANDROID_RETRIES);
String appleCertificatePassword = PrefsPropsUtil.getString(PortletPropsKeys.APPLE_CERTIFICATE_PASSWORD, PortletPropsValues.APPLE_CERTIFICATE_PASSWORD);
String appleCertificatePath = PrefsPropsUtil.getString(PortletPropsKeys.APPLE_CERTIFICATE_PATH, PortletPropsValues.APPLE_CERTIFICATE_PATH);
boolean appleSandbox = PrefsPropsUtil.getBoolean(PortletPropsKeys.APPLE_SANDBOX, PortletPropsValues.APPLE_SANDBOX);

%>

<liferay-portlet:actionURL name="updatePortletPreferences" var="updatePortletPreferencesURL" />
<%

PortletURL portletURL = renderResponse.createRenderURL();

String orderByCol = ParamUtil.getString(request, "orderByCol", "platform");
String orderByType = ParamUtil.getString(request, "orderByType","ASC");

OrderByComparator orderByComparator = PushNotificationsDeviceComparatorUtil.getPushNotificationOrderByComparator(orderByCol, orderByType);
%>
<liferay-ui:tabs
	names="devices,configuration,applications,test"
	refresh="<%= false %>"
>

	<liferay-ui:section>
	
		<liferay-ui:success key="success" message="device-delete-successfull"/>	
		<liferay-ui:search-container emptyResultsMessage="no-devices-were-found" delta="10"
			iteratorURL="<%= portletURL %>"
			orderByCol="<%= orderByCol %>"
			orderByComparator="<%= orderByComparator %>"
			orderByType="<%= orderByType %>"
			total="<%= PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDevicesCount() %>">
			<liferay-ui:search-container-results
				results="<%= PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDeviceByComparator(searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
			/>
	
			<liferay-ui:search-container-row
				className="com.liferay.pushnotifications.model.PushNotificationsDevice"
				keyProperty="pushNotificationsDeviceId"
				modelVar="device">
				<%
				User userToken = UserLocalServiceUtil.getUser(device.getUserId());
				%>
				<liferay-ui:search-container-column-text
					name="userid"
					value='<%= ""+userToken.getUserId() %>'	/>
				<liferay-ui:search-container-column-text
					name="fullname"
					value='<%= ""+userToken.getFullName() %>'/>
				<liferay-ui:search-container-column-text 
					name="screename"
					value='<%= userToken.getScreenName() %>'/>
				<liferay-ui:search-container-column-text
					name="platform"
					orderable="<%= true %>"
      				orderableProperty="platform"
					value="<%= device.getPlatform() %>"/>
				<liferay-ui:search-container-column-text
					name="model"
					orderable="<%= true %>"
      				orderableProperty="model"
					value="<%= device.getModel() %>" />
				<liferay-ui:search-container-column-text
					name="osversion"
					orderable="<%= true %>"
      				orderableProperty="OSVersion"
					value="<%= device.getOSVersion() %>"/>
				<liferay-ui:search-container-column-text
					name="appversion" orderable="<%= true %>"
      				orderableProperty="appVersion"
					value="<%= device.getAppVersion() %>" />
				<liferay-ui:search-container-column-text
					name="token"
					value="<%= device.getToken() %>"/>
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/admin/devices_action.jsp" />
				</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>	
	</liferay-ui:section>
	<liferay-ui:section>
		<aui:form action="<%= updatePortletPreferencesURL %>" method="post" name="configurationFm">
			<aui:fieldset label="android">
				<aui:input helpMessage="android-api-key-help" label="android-api-key" name="androidApiKey" type="text" value="<%= androidApiKey %>" wrapperCssClass="lfr-input-text-container" />

				<aui:input helpMessage="android-retries-help" label="android-retries" name="androidRetries" type="text" value="<%= androidRetries %>" wrapperCssClass="lfr-input-text-container">
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>
			</aui:fieldset>

			<aui:fieldset label="ios">
				<aui:input helpMessage="apple-certificate-path-help" label="apple-certificate-path" name="appleCertificatePath" type="text" value="<%= appleCertificatePath %>" wrapperCssClass="lfr-input-text-container" />

				<aui:input helpMessage="apple-certificate-password-help" label="apple-certificate-password" name="appleCertificatePassword" type="password" value="<%= appleCertificatePassword %>" wrapperCssClass="lfr-input-text-container" />

				<aui:fieldset>
					<aui:input helpMessage="apple-sandbox-help" label="apple-sandbox"  name="appleSandbox" type="checkbox" value="<%= appleSandbox %>" />
				</aui:fieldset>
			</aui:fieldset>

			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</liferay-ui:section>
<%
%>
	<liferay-ui:section>
	
		<div></div>
	
		<liferay-ui:success key="success" message="app-delete-successfull"/>	
		<liferay-ui:search-container emptyResultsMessage="no-apps-were-found" delta="10"
			iteratorURL="<%= portletURL %>"
			total="<%= ApplicationLocalServiceUtil.getApplicationsCount() %>">
			
			
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item iconCssClass="icon-plus" href="#" onClick='addApp()' id="addApp" label="add" />
				</aui:nav>

			</aui:nav-bar>
			
			
			<liferay-ui:search-container-results
				results="<%= ApplicationLocalServiceUtil.getApplications(searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>
	
			<liferay-ui:search-container-row
				className="com.liferay.pushnotifications.model.Application"
				keyProperty="applicationId"
				modelVar="app">
				<%
				List<AppVersion> versions = AppVersionLocalServiceUtil.findAppVerionByAppId(app.getApplicationId());
				String appVersions = "";
				String sep = "";
				for(AppVersion version: versions){
					appVersions += sep + version.getAppVersionKey();
					sep = ", ";
				}
				%>
				<liferay-ui:search-container-column-text
					name="userid"
					value='<%= ""+app.getApplicationName() %>'	/>
				<liferay-ui:search-container-column-text
					name="Versions"
					value='<%=appVersions %>'/>
				
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/admin/appVerions_action.jsp" />
				</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</liferay-ui:section>

	<liferay-ui:section>
		<aui:form name="fm">
			<aui:input label="message" name="message" rows="6" type="textarea" />

			<aui:button type="submit" value="send" />

			<aui:button type="reset" value="reset" />
		</aui:form>

		<br />

		<div class="alert alert-success hide" id="<portlet:namespace />success">
			<p><liferay-ui:message key="the-push-notification-was-sent-successfully" /></p>
		</div>

		<div class="alert alert-danger hide" id="<portlet:namespace />error">
			<p></p>
		</div>
	</liferay-ui:section>
	
</liferay-ui:tabs>

<%
PortletURL addAppUrl = renderResponse.createRenderURL();

addAppUrl.setPortletMode(PortletMode.VIEW);
addAppUrl.setParameter(Constants.CMD, Constants.ADD);
addAppUrl.setParameter("type", "app");
addAppUrl.setWindowState(LiferayWindowState.POP_UP);
%>
<aui:script use="aui-base,aui-dialog">
	var form = A.one('#<portlet:namespace />fm');

	form.on(
		'submit',
		function(event) {
			event.halt();

			var message = form.one('textarea[name="<portlet:namespace />message"]').val();

			Liferay.Service(
				'/push-notifications-portlet.pushnotificationsdevice/send-push-notification',
				{
					payload: A.JSON.stringify(
						{
							body: message
						}
					),
					toUserIds: []
				},
				<portlet:namespace />onSendPushNotification
			);
		}
	);

	function <portlet:namespace />onSendPushNotification(result) {
		var success = A.one('#<portlet:namespace />success');

		success.hide();

		var error = A.one('#<portlet:namespace />error');

		error.hide();

		if (A.Object.hasKey(result, 'exception')) {
			error.one('p').text(result);

			error.show();
		}
		else {
			success.show();
		}
	}
	
	
		Liferay.provide(window, 'addApp', function() {

			Liferay.Util.openWindow(
				{
					dialog: {
						height: 460,
						width: 770
					},
					id: '<portlet:namespace />addAppDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "new-app") %>',
					uri: '<%= addAppUrl.toString() %>'
				}
			);
		});
	
	
</aui:script>
