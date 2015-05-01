<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil"%>
<%@ include file="/html/portlet/users_admin/init.jsp" %>

<%
User selUser = (User)request.getAttribute("user.selUser");

if (selUser != null) {
	
}
String orderByCol = ParamUtil.getString(request, "orderByCol", "platform");
String orderByType = ParamUtil.getString(request, "orderByType","ASC");
currentURLObj.setParameter("historyKey", renderResponse.getNamespace() + "devices");
%>


<h3><liferay-ui:message key="your-devices-register" /></h3>

<liferay-ui:message key="your-devices-info" />

<liferay-ui:search-container emptyResultsMessage="no-devices-were-found" delta="10"
			iteratorURL="<%= currentURLObj %>"
			orderByCol="<%= orderByCol %>"
			
			orderByType="<%= orderByType %>"
			total="<%=PushNotificationsDeviceLocalServiceUtil.getUserDevicesCount(selUser.getUserId()) %>">
			<liferay-ui:search-container-results
				results="<%= PushNotificationsDeviceLocalServiceUtil.getUserDevices(selUser.getUserId(), searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>
	
			<liferay-ui:search-container-row
			className="com.liferay.pushnotifications.model.PushNotificationsDevice"
			keyProperty="pushNotificationsDeviceId"
			modelVar="device">
			
			<liferay-ui:search-container-column-text
				name="platform"
				orderable="<%= false %>"
      			orderableProperty="platform"
				value="<%= device.getPlatform() %>"
			/>
			<liferay-ui:search-container-column-text
				name="model"
				orderable="<%= false %>"
      			orderableProperty="model"
				value="<%= device.getModel() %>"
			/>
			<liferay-ui:search-container-column-text
				name="osversion"
				orderable="<%= false %>"
      			orderableProperty="OSVersion"
				value="<%= device.getOSVersion() %>"
			/>
			<liferay-ui:search-container-column-text
				name="appversion" orderable="<%= false %>"
      			orderableProperty="appVersion"
				value="<%= device.getAppVersion() %>"
			/>
		</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
