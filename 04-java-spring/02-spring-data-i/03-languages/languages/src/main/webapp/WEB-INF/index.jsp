  
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
<link rel="stylesheet" href="css/main.css" />
<title>Languages</title>
</head>
<body>
	<div class="container">
		<h1>Languages</h1>
		<a href="/new">Add a language</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ languages }" var="lang">
				<tr>
					<td><a href="/${ lang.id }">${ lang.name }</a></td>
					<td>${ lang.creator }</td>
					<td>${ lang.version }</td>
					<td>
						<a href="/edit/${ lang.id }">Edit </a>
						<a href="/delete/${lang.id}"> Delete</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>