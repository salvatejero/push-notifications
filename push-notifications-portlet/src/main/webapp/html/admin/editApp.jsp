<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.pushnotifications.ValidationApplicationPreferencesException"%>
<%@page import="com.liferay.pushnotifications.IOSValidationApplicationPreferencesException"%>
<%@page import="com.liferay.pushnotifications.util.ActionKeys"%>
<%@page import="com.liferay.pushnotifications.service.permission.PushAppsNotificationsPermission"%>
<%@page import="com.liferay.portal.model.Repository"%>
<%@page import="com.liferay.portal.service.RepositoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RepositoryEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.pushnotifications.model.ApplicationPreferences"%>
<%@page import="com.liferay.pushnotifications.service.ApplicationPreferencesLocalServiceUtil"%>
<%@page import="com.liferay.pushnotifications.model.Application"%>
<%@ include file="../../init.jsp" %>

<%

Long appId = (Long)request.getAttribute("appId");

Application app = null;
String portletResource = ParamUtil.getString(request, "portletResource");
if(appId != null && appId > 0){
	app = ApplicationLocalServiceUtil.getApplication(appId);
}

ApplicationPreferences appPreferences = ApplicationPreferencesLocalServiceUtil.findApplicationPreferenceByApplicationId(appId);

boolean appleSandbox = false;
boolean editable = PushAppsNotificationsPermission.contains(permissionChecker, ActionKeys.MANAGE_APPS);
boolean editablePreferences = PushAppsNotificationsPermission.contains(permissionChecker, ActionKeys.MANAGE_APPS_PREFERENCES);
boolean viewPreferences = PushAppsNotificationsPermission.contains(permissionChecker, ActionKeys.VIEW_APPS_PREFERENCES);
%>

<portlet:actionURL  var="updateAppURL" name="updateApplication">
</portlet:actionURL>


<liferay-ui:error key="error-json" message="structure-no-json"/>
<liferay-ui:error exception="<%=ValidationApplicationPreferencesException.class %>" message="application-preferences-field-validation"/>
<liferay-ui:error exception="<%=IOSValidationApplicationPreferencesException.class %>" message="ios-application-preferences-field-validation"/>

<aui:form action="<%= updateAppURL %>"  cssClass="sign-in-form" method="post" name="fm">
	<aui:input name="appId"  value="<%= (appId != null)?appId:0 %>" type="hidden"/>
	<aui:input name="cmd"  value='<%= (app != null)? "update":"add" %>' type="hidden"/>
	<aui:row>
		<aui:column columnWidth="100">
			<aui:fieldset>
				<aui:input autoFocus="true" cssClass="clearable" label="applicationName" disabled="<%=!editable %>" name="applicationName" showRequiredLabel="<%= true %>" type="text" value='<%= (app != null)?app.getApplicationName(): "" %>'>
					<aui:validator name="required" />
				</aui:input>
				
			</aui:fieldset>
		</aui:column>
	</aui:row>
	<%if(viewPreferences){ %>
	<aui:row>
		<aui:column columnWidth="50">
			<aui:fieldset label="android">
				<aui:input helpMessage="android-api-key-help" disabled="<%=!editablePreferences %>" label="android-api-key" name="androidApiKey" type="text" value='<%=(appPreferences != null)? appPreferences.getAndroidApiKey():"" %>' wrapperCssClass="lfr-input-text-container" />
		
				<aui:input helpMessage="android-retries-help" disabled="<%=!editablePreferences %>" label="android-retries" name="androidRetries" type="number" value='<%=(appPreferences != null)? appPreferences.getAndroidRetries(): 0 %>' wrapperCssClass="lfr-input-text-container">
					<aui:validator name="digits" />
					<aui:validator name="min">0</aui:validator>
				</aui:input>
			</aui:fieldset>
		</aui:column>
		<aui:column columnWidth="50">
			<aui:fieldset label="ios">
				<div class="control-group control-group-inline lfr-input-text-container">
					<label><%=LanguageUtil.get(locale, "apple-certificate-sandbox-path") %> <span id="preDoc"></span>
						<span class="taglib-icon-help"><img tabindex="0" src="/html/themes/control_panel/images/portlet/help.png" onmouseover="Liferay.Portal.ToolTip.show(this);" onfocus="Liferay.Portal.ToolTip.show(this);" onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="xgqg" alt=""><span id="xgqg" class="hide-accessible tooltip-text">adasdasddfadsfdsafasdfasd2.</span></span>
					</label>
					<aui:button name="openFolderSelectorButton" disabled="<%=!editablePreferences %>" value="select" />
				</div>
				<aui:input helpMessage="apple-certificate-password-help" disabled="<%=!editablePreferences %>" label="apple-sandbox-certificate-password" name="appleCertificateSandBoxPassword" type="password" value='<%= (appPreferences != null)?appPreferences.getIosPasswordSandBoxCertificated():"" %>' wrapperCssClass="lfr-input-text-container" />
				<div class="control-group control-group-inline lfr-input-text-container">
					<label><%=LanguageUtil.get(locale, "apple-certificate-sandbox-path") %> <span id="preDoc"></span></label>
					<aui:button name="openFolderSelectorButton" disabled="<%=!editablePreferences %>" value="select" />
				</div>
				
				apple-certificate-pro-path
				<aui:input helpMessage="apple-certificate-path-help" label="apple-certificate-path" name="appleCertificateFile" type="number" value='<%= (appPreferences != null)?appPreferences.getIosProdCert() : 0%>' wrapperCssClass="lfr-input-text-container" />
		
				<aui:input helpMessage="apple-certificate-password-help" disabled="<%=!editablePreferences %>" label="apple-certificate-password" name="appleCertificatePassword" type="password" value='<%= (appPreferences != null)?appPreferences.getIosPasswordCertificated():"" %>' wrapperCssClass="lfr-input-text-container" />
				<aui:input helpMessage="apple-certificate-password-help" disabled="<%=!editablePreferences %>" label="apple-sandbox-certificate-password" name="appleCertificateSandBoxPassword" type="password" value='<%= (appPreferences != null)?appPreferences.getIosPasswordCertificated():"" %>' wrapperCssClass="lfr-input-text-container" />
		
			</aui:fieldset>
		</aui:column>
	</aui:row>
	<%} %>
	<%
		
	String buttonLabel = "add";
	if(app != null){
		buttonLabel = "update";
	}
	
	%>
<%if(editable || editablePreferences){ %>
	<aui:button-row>
		<aui:button type="submit" value="<%=buttonLabel %>" />
	</aui:button-row>
<%} %>
	<%
	
	PortletURL portletURL = renderResponse.createRenderURL();
	
	PortletURL editVersionURL = renderResponse.createRenderURL();
	editVersionURL.setParameter("appId", ""+((appId != null)?appId:0));
	editVersionURL.setParameter(Constants.CMD, Constants.ADD);
	editVersionURL.setParameter("type", "version");
	%>

	<liferay-ui:search-container emptyResultsMessage="no-versions-were-found" delta="20"
			iteratorURL="<%= portletURL %>"
			total="<%= AppVersionLocalServiceUtil.findAppVerionByAppId(appId).size() %>">
			
			<% 	if(PushAppsNotificationsPermission.contains(permissionChecker, ActionKeys.MANAGE_APPS_VERSIONS)){;
		
		%>
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item iconCssClass="icon-plus" anchorCssClass="staging-link" href="<%=editVersionURL.toString() %>" id="editApp" label="add" />
				</aui:nav>

			</aui:nav-bar>
			
			<%} %>
			<liferay-ui:search-container-results
				results="<%= AppVersionLocalServiceUtil.findAppVerionByAppId(appId, searchContainer.getStart(), searchContainer.getEnd()) %>"
			/>
	
			<liferay-ui:search-container-row
				className="com.liferay.pushnotifications.model.AppVersion"
				keyProperty="appVersionId"
				modelVar="appVerion">
				
				<liferay-ui:search-container-column-text
					name="key"
					value='<%=appVerion.getAppVersionKey() %>'/>
				<liferay-ui:search-container-column-text
					name="structure"
					value='<%=appVerion.getStructure()%>'/>
				
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/html/admin/appVersion_action.jsp" />
				</liferay-ui:search-container-row>
	
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>

</aui:form>
<%
String portletId = PortletKeys.DOCUMENT_LIBRARY;
%>
<liferay-portlet:renderURL portletName="<%= portletId %>" var="selectFileEntryURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="struts_action" value='/document_library/select_file_entry' />
	<portlet:param name="folderId" value='0' />
	<portlet:param name="groupId" value='<%=""+themeDisplay.getScopeGroupId() %>' />
</liferay-portlet:renderURL>
<aui:script use="aui-base">

A.one('#<portlet:namespace />openFolderSelectorButton').on(
	'click',
	function(event) {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true,
					width: 600
				},
				id: '_<%= HtmlUtil.escapeJS(portletResource) %>_select_file_entry',
				title: '<liferay-ui:message arguments="entry" key="select-x" />',
				uri: '<%= selectFileEntryURL.toString() %>'
			},
			function(event) {
				console.log(event);
				var folderFileData = {
					idString: 'rootFolderId',
					idValue: event.folderid,
					nameString: 'rootFolderName',
					nameValue: event.foldername
				};

				Liferay.Util.selectEntity(folderFileData, '<portlet:namespace />');
			}
		);
	}
);

var form = A.one('#<portlet:namespace />fm');

if(form){
	form.on('submit', function(event) {
		setTimeout(	Liferay.Util.getOpener().refreshPortlet({<portlet:namespace />tabSelected: 'applications'}), 3000);	
	});
}
</aui:script>
