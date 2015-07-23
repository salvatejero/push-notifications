<%@page import="com.liferay.pushnotifications.service.permission.PushNotificationsPermission"%>
<%@page import="com.liferay.pushnotifications.util.ActionKeys"%>
<%@page import="com.liferay.pushnotifications.service.permission.PushAppsNotificationsPermission"%>
<%@page import="com.liferay.pushnotifications.model.PushNotificationsDevice"%>
<%@page import="com.liferay.portal.service.permission.UserPermissionUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../../init.jsp" %>
<% 
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

PushNotificationsDevice pushObject = (PushNotificationsDevice)row.getObject();

long pushid = pushObject.getPushNotificationsDeviceId();
long userId = pushObject.getUserId();
%>

<liferay-ui:icon-menu>

	<c:if test="<%= PushNotificationsPermission.contains(permissionChecker, ActionKeys.DELETE_DEVICES) %>">

		<liferay-portlet:actionURL name="deleteDevice" var="deleteDeviceUrl">
			<portlet:param name="pushId" value="<%= String.valueOf(pushid) %>" />
		</liferay-portlet:actionURL>


		<liferay-ui:icon-delete url="<%= deleteDeviceUrl %>" />
	</c:if>
</liferay-ui:icon-menu>