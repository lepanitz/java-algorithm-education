<%@page import="jfix.util.*,jease.cms.domain.*"%>
<% Content content = (Content) request.getAttribute("Node"); %>
<p>
<% 
	Content[] parents = content.getParents(Content.class);
 	if (Validations.isNotEmpty(parents)) {
		for (Content parent : parents) {
%> 	
			<a href="<%= request.getContextPath() %><%=parent.getPath()%>"><%=parent.getTitle()%></a>&nbsp;&raquo; 
	<% } %>
		<br />
<% } %>	
<a href="<%= request.getContextPath() %><%=content.getPath()%>"><b><%=content.getTitle()%></b></a>
</p>
