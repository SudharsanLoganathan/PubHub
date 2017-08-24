<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="examples.pubhub.dao.TagDAOImpl"%>
<%@page import="examples.pubhub.model.BookTags"%>

<%@page import="java.util.List"%>

	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Tags</title>
</head>
<body>
<form action="ListTagsServlet">
		<br>Search Tag: <input type="text" name="tagName"
			class="search"  required>
		<button type="submit" name="tag">submit</button>
		<br>
		<hr>
		<%
			String var = request.getParameter("tag");
			if (var != null) {
		%>
		
<table border="1">
			<tr>
			<th>ISBN 13:</th>
			<th>tag name</th>
			</tr>
				<% 
		TagDAOImpl dao=new TagDAOImpl();
		List<BookTags> tagList =dao.getAllTagsByTagName("isbn13");
				
	
					for (BookTags c : tagList) {
						
				 %>
				 <tbody>
			<tr>
				<td><%=c.getIsbn13().getIsbn13()%></td>
				<td><%=c.getTagName()%></td>
				
			</tr>
		</tbody>
							<% }} %>
							
					
	</table>
	</form>
</body>
</html>

