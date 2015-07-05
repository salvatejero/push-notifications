<%@page import="com.liferay.pushnotifications.model.Application"%>
<%@ include file="../../init.jsp" %>

<%

Long appId = (Long)request.getAttribute("appId");

Application app = null;

if(appId != null && appId > 0){
	app = ApplicationLocalServiceUtil.getApplication(appId);
}

%>

<portlet:actionURL  var="updateAppURL" name="updateApplication">
</portlet:actionURL>


<liferay-ui:error key="error-json" message="structure-no-json"/>


<aui:form action="<%= updateAppURL %>"  cssClass="sign-in-form" method="post" name="fm">
	<aui:input name="appId"  value="<%= (appId != null)?appId:0 %>" type="hidden"/>
	<aui:input name="cmd"  value='<%= (app != null)? "update":"add" %>' type="hidden"/>
	<aui:fieldset>
		<aui:input autoFocus="true" cssClass="clearable" label="applicationName" name="applicationName" showRequiredLabel="<%= true %>" type="text" value='<%= (app != null)?app.getApplicationName(): "" %>'>
			<aui:validator name="required" />
		</aui:input>
		
		<%
		
		String buttonLabel = "add";
		if(app != null){
			buttonLabel = "update";
		}
		
		%>

		<aui:button-row>
			<aui:button type="submit" value="<%=buttonLabel %>" />
		</aui:button-row>

	</aui:fieldset>

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
			
			<aui:nav-bar>
				<aui:nav>
					<aui:nav-item iconCssClass="icon-plus" anchorCssClass="staging-link" href="<%=editVersionURL.toString() %>" id="editApp" label="add" />
				</aui:nav>

			</aui:nav-bar>
			
			
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

<aui:script use="aui-base">

var form = A.one('#<portlet:namespace />fm');

if(form){
	form.on('submit', function(event) {
		setTimeout(	Liferay.Util.getOpener().refreshPortlet({<portlet:namespace />tabSelected: 'applications'}), 3000);	
	});
}
</aui:script>
