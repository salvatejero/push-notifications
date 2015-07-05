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

AppVersion appVersion = (AppVersion)row.getObject();

long appId = appVersion.getApplicationId();
long appVersionId = appVersion.getAppVersionId();
long userId = (Long)request.getAttribute(WebKeys.USER_ID);


PortletURL editAppUrl = renderResponse.createRenderURL();

editAppUrl.setPortletMode(PortletMode.VIEW);
editAppUrl.setParameter("appId", ""+appId);
editAppUrl.setParameter("versionId", ""+appVersionId);
editAppUrl.setParameter(Constants.CMD, Constants.ADD);
editAppUrl.setParameter("type", "version");


String method = "editApp('"+editAppUrl.toString() +"')";
%>

<liferay-ui:icon-menu>
	
	<liferay-portlet:actionURL name="deleteApp" var="deleteApplicationUrl">
		<portlet:param name="appId" value="<%= String.valueOf(appId) %>" />
	</liferay-portlet:actionURL>

	<liferay-ui:icon image="edit" url="<%=editAppUrl.toString() %>" />
	<c:if test="<%= UserPermissionUtil.contains(permissionChecker, userId, ActionKeys.DELETE) %>">
		<liferay-ui:icon-delete url="<%= deleteApplicationUrl %>" />
	</c:if>
</liferay-ui:icon-menu>