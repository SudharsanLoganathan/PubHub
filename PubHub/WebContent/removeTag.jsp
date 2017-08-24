<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


	<title>remove tag</title>
	</head>
	<body>
<form action="RemoveTagServlet">
ISBN 13:<input type="text"name="isbn13" required autofocus>
Tag:<input type="text"name="tagName"  required>
<button type="submit" value="Remove Tag">remove tag</button>
</form>
</body>
</html>