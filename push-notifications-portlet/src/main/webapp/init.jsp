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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %><%@
page import="com.liferay.pushnotifications.util.PortletPropsKeys" %><%@
page import="com.liferay.pushnotifications.util.PortletPropsValues" %>


<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.pushnotifications.service.AppVersionLocalServiceUtil"%>
<%@page import="com.liferay.pushnotifications.service.ApplicationLocalServiceUtil"%>
<%@page import="com.liferay.pushnotifications.model.AppVersion"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.pushnotifications.util.PushNotificationsDeviceComparatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.pushnotifications.service.persistence.PushNotificationsDeviceUtil"%>
<%@page import="java.util.Random"%>
<%@page import="com.liferay.pushnotifications.service.PushNotificationsDeviceServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.pushnotifications.service.PushNotificationsDeviceLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>

<portlet:defineObjects />

<liferay-theme:defineObjects />