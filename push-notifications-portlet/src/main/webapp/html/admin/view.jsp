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
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.pushnotifications.model.Application"%>
<%@page import="com.liferay.pushnotifications.service.permission.PushNotificationsPermission"%>
<%@page import="com.liferay.pushnotifications.util.ActionKeys"%>
<%@page import="com.liferay.pushnotifications.service.permission.PushAppsNotificationsPermission"%>
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

Long appIdSelected = ParamUtil.getLong(request, "appSelected", 0);

String tabSelected = (String)ParamUtil.getString(request, "tabSelected", "");
OrderByComparator orderByComparator = PushNotificationsDeviceComparatorUtil.getPushNotificationOrderByComparator(orderByCol, orderByType);
List<Application> listApps = ApplicationLocalServiceUtil.getApplications(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//names="devices,configuration,applications,test"
%>
<liferay-ui:tabs
	names="devices,applications"
	refresh="<%= false %>"
	value="<%=tabSelected %>">

	<liferay-ui:section>
	
		<liferay-ui:success key="success" message="device-delete-successfull"/>	
		<aui:nav-bar >
			<aui:nav>
				<aui:select name="appSelected" label="select-app" onChange="" inlineLabel="true" cssClass="appSelected">
				
					<aui:option value='0' selected="<%=(appIdSelected == 0) %>"><liferay-ui:message key="all"/> </aui:option>
					<% 
					for(Application appFor:listApps){%>
					
					<aui:option value='<%= appFor.getApplicationId()%>' selected="<%=(appIdSelected == appFor.getApplicationId()) %>"><%= appFor.getApplicationName()%></aui:option>
					<%
					}
					%>
				</aui:select>
	
			</aui:nav>

		</aui:nav-bar>
		
		<liferay-ui:search-container emptyResultsMessage="no-devices-were-found" delta="10"
			iteratorURL="<%= portletURL %>"
			orderByCol="<%= orderByCol %>"
			orderByComparator="<%= orderByComparator %>"
			orderByType="<%= orderByType %>"
			total="<%=PushNotificationsDeviceLocalServiceUtil.getAppDevicesCount(appIdSelected)%>">
			<liferay-ui:search-container-results
				results="<%= PushNotificationsDeviceLocalServiceUtil.getPushNotificationsDeviceByAppIdByComparator(appIdSelected, searchContainer.getStart(), searchContainer.getEnd(), orderByComparator) %>"
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
					
					
				<%
				Application app = null;
				Long idApp = device.getAppId();
				if(idApp != 0){
					ApplicationLocalServiceUtil.getApplication(idApp);
				}
				
				%>	
				<liferay-ui:search-container-column-text
					name="applicationName" 
					orderable="<%= true %>"
      				orderableProperty="applicationName"
					value='<%= (app != null)? app.getApplicationName():"" %>'/>	
				<liferay-ui:search-container-column-text
					name="appversion" orderable="<%= true %>"
      				orderableProperty="appVersion"
					value="<%= device.getAppVersion() %>" />
				<liferay-ui:search-container-column-text
					name="token"
					value="<%= device.getToken() %>"/>
					<c:if test="<%= PushNotificationsPermission.contains(permissionChecker, ActionKeys.DELETE_DEVICES) %>">
				<liferay-ui:search-container-column-jsp
					align="right" cssClass="actionColumn" 
					path="/html/admin/devices_action.jsp" />
					</c:if>
				</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>	
	</liferay-ui:section>
	
	<liferay-ui:section>
	
		<liferay-ui:success key="success-app-version" message="app-delete-successfull"/>	
		<liferay-ui:search-container emptyResultsMessage="no-apps-were-found" delta="10"
			iteratorURL="<%= portletURL %>"
			total="<%= ApplicationLocalServiceUtil.getApplicationsCount() %>">
			
		<% 	if(PushAppsNotificationsPermission.contains(permissionChecker, ActionKeys.MANAGE_APPS)){;
		
		%>
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item anchorCssClass="addApp-link" iconCssClass="icon-plus" href="#" onClick='addApp()' id="addApp" label="add" />
				</aui:nav>

			</aui:nav-bar>
			
		<%} %>	
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
					name="applicationName"
					value='<%= ""+app.getApplicationName() %>'	/>
				<liferay-ui:search-container-column-text
					name="versions"
					value='<%=appVersions %>'/>
				
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/admin/apps_action.jsp" />
				</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
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
	
		Liferay.provide(window, 'addApp', function() {

			Liferay.Util.openWindow(
				{
					dialog: {
						height: 600,
						width: 1070
					},
					id: '<portlet:namespace />editAppDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "new-app") %>',
					uri: '<%= addAppUrl.toString() %>'
				}
			);
		});
	
		Liferay.provide(window, 'editApp', function(url, appName) {

			Liferay.Util.openWindow(
				{
					dialog: {
						height: 600,
						width: 1070
					},
					id: '<portlet:namespace />editAppDialog',
					title: '<%= UnicodeLanguageUtil.get(pageContext, "edit-app") %> '+appName,
					uri: url
				}
			);
		});
		
		
		Liferay.provide( window, '<portlet:namespace />closePopup',
				        function(data, popupIdToClose) {
			            var dialog = Liferay.Util.getWindow(popupIdToClose);
				            dialog.destroy(); // You can try toggle/hide whatever You want
				        },
				        ['aui-base','aui-dialog','aui-dialog-iframe']
				    );
				       
		
		Liferay.provide(window, 'refreshPortlet', function(data) {
	        var curPortlet = '#p_p_id<portlet:namespace/>';
	        	Liferay.Portlet.refresh(curPortlet, data);
	    	}, ['aui-dialog','aui-dialog-iframe'] );
</aui:script>
