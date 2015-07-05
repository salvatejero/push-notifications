<%@page import="com.liferay.pushnotifications.model.Application"%>
<%@ include file="../../init.jsp" %>

<%

Long appId = (Long)request.getAttribute("appId");
Long versionId = (Long)request.getAttribute("versionId");

if(appId == null){
	appId =	ParamUtil.getLong(request, "appId", 0);
}
if(versionId == null){
	versionId = ParamUtil.getLong(request, "versionId", 0);
}
AppVersion appVersion = null;

if(versionId != null && versionId > 0){
	appVersion = AppVersionLocalServiceUtil.getAppVersion(versionId);
}

%>

<portlet:actionURL  var="updateVersionURL" name="editVersionApplication">
</portlet:actionURL>
<aui:form action="<%= updateVersionURL %>"  cssClass="sign-in-form" method="post" name="fm">
	<aui:input name="appId"  value="<%= (appId != null)?appId:0 %>" type="hidden"/>
	<aui:input name="versionId"  value="<%= (versionId != null)?versionId:0 %>" type="hidden"/>
	<aui:input name="cmd"  value='<%= (appVersion != null)? "update":"add" %>' type="hidden"/>
	<aui:fieldset>
		<aui:input autoFocus="true" cssClass="clearable" label="appVersionKey" name="appVersionKey" showRequiredLabel="<%= true %>" type="text" value='<%= (appVersion != null)?appVersion.getAppVersionKey(): "" %>'>
			<aui:validator name="required" />
		</aui:input>

		<aui:input label="structure" name="structure" rows="6" type="textarea" required="true" showRequiredLabel="true" value="<%=appVersion.getStructure() %>">
			<aui:validator name="required" />
		</aui:input>
		<div class="alert alert-info"> Debe introducir un JSON v&aacute;lido. <br /> 
			{ 
			     attr1: "STRING",
			     attr2: LONG
			}
		</div>
		<%
		
		String buttonLabel = "add";
		if(appVersion != null){
			buttonLabel = "update";
		}
		
		%>

		<aui:button-row>
			<aui:button type="submit" value="<%=buttonLabel %>" />
		</aui:button-row>

	</aui:fieldset>


</aui:form>

