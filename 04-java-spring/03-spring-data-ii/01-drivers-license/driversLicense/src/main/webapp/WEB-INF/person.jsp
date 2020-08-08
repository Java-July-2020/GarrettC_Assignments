<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<title>My HomePage</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	</head>
	<body>
		<h1>Persons</h1>
		<a href="/persons/new">Create a new person for our Database</a>
		<table class="table table-dark">
		<thead>
			<tr>
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
			</tr>
		</thead>
		<tbody><c:forEach items="${persons}" var="person">
			<tr>
				<td><a href="/persons/${person.id}">${person.id}</a></td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
		
	</body>
</html>