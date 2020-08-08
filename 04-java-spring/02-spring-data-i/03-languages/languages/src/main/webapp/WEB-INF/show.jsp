
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css" />
<title>Languages</title>
</head>
<body>
	<div class="container">
		<h1>Details for Languages #${ languages.id }</h1>
		<hr />
		<h1><c:out value="${languages.name}"/></h1>
		<p>Creator: <c:out value="${languages.creator}"/></p>
		<p>Current Version: <c:out value="${languages.version}"/></p>
		<a href="/edit/${languages.id}">Edit </a>
		<p></p>
		<a href="/delete/${languages.id}"> Delete</a>
	</div>
</body>
</html>