<%@page import="com.liferay.pushnotifications.model.Application"%>
<%@page import="com.liferay.pushnotifications.model.PushNotificationsDevice"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.permission.UserPermissionUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../../init.jsp" %>
<% 
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Application app = (Application)row.getObject();

long appId = app.getApplicationId();

long userId = (Long)request.getAttribute(WebKeys.USER_ID);
%>

<liferay-ui:icon-menu>
	
		<liferay-portlet:actionURL name="deleteApp" var="deleteApplicationUrl">
			<portlet:param name="appId" value="<%= String.valueOf(appId) %>" />
		</liferay-portlet:actionURL>

		<liferay-portlet:renderURL var="editAppUrl">
			<portlet:param name="appId" value="<%= String.valueOf(appId) %>" />
		</liferay-portlet:renderURL>

	<liferay-ui:icon image="edit" url="<%= editAppUrl %>" />
	<c:if test="<%= UserPermissionUtil.contains(permissionChecker, userId, ActionKeys.DELETE) %>">
		<liferay-ui:icon-delete url="<%= deleteApplicationUrl %>" />
	</c:if>
</liferay-ui:icon-menu>