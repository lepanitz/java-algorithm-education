<%@page import="jease.cms.domain.*,jease.site.*"%>
<%
	Content navigationContext = (Content) request.getAttribute("Node");
%>
<h1><a href="<%=request.getContextPath() %><%=navigationContext.getParent().getPath()%>"><%=((Content) navigationContext.getParent()).getTitle()%></a></h1>
<ul>
	<%
		for (Content content : Navigations.getItems((Content) navigationContext.getParent())) {
		if (content instanceof Topic) {
	%>
</ul>
<h1><%=content.getTitle()%></h1>
<ul>
	<%
		} else {
	%>
	<li <%=content == navigationContext ? " class=\"current\"" : ""%>>
		<a href="<%=request.getContextPath() %><%=content.getPath()%>"><%=content.getTitle()%></a>
	</li>
	<%
		}
		}
	%>
</ul>
