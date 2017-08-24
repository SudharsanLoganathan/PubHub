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

<table border="1">
			<tr>
			<th>ISBN 13:</th>
			<th>tag name</th>
			</tr>
				<% 
		TagDAOImpl dao=new TagDAOImpl();
		List<BookTags> bookList = dao.getAllTags();
	
					for (BookTags c : bookList) {
						
				 %>
				 <tbody>
			<tr>
				<td><%=c.getIsbn13().getIsbn13()%></td>
				<td><%=c.getTagName()%></td>
				
			</tr>
			<%} %>
		</tbody>
					
	</table>
	<a href="../addTag.jsp">Add tag</a> 
	<a href="../removeTag.jsp">Remove tag</a>
	<a href="../searchTag.jsp">Search tag</a>
</body>
</html>

