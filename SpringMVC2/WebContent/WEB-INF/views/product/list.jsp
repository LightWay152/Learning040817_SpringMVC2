<%@ page pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Product</title>
</head>
<body>
	<h1>List of Product</h1>
	<c:forEach var="p" items="${list}">
		<li>${p.name}</li>
	</c:forEach>
</body>
</html>