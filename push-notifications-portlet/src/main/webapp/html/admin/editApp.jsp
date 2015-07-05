<%@ include file="../../init.jsp" %>

<portlet:actionURL  var="newAppURL">
</portlet:actionURL>
<aui:form action="<%= newAppURL %>"  cssClass="sign-in-form" method="post" name="fm">

	<aui:fieldset>
		<aui:input autoFocus="true" cssClass="clearable" label="applicationName" name="applicationName" showRequiredLabel="<%= true %>" type="text" value="">
			<aui:validator name="required" />
		</aui:input>

	</aui:fieldset>

</aui:form>