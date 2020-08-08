<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
	<title>My HomePage</title>
	</head>
	<body>
		<h1>newLicense.jsp</h1>
		<form:form action="/licenses" method="post" modelAttribute="license">
			<p>Person:
				<form:select path="person">
				   <c:forEach items="${persons}" var="person">
            			<form:option value="${person.id}"> ${person.id} : ${person.firstName} ${person.lastName}</form:option>
        			</c:forEach>
				</form:select> 
		    </p>
		    <p>
		        <form:label path="state">State:</form:label>
		        <form:errors path="state"/>
		        <form:input path="state"/>
		    </p>
		    <p>
		        <form:label path="expiration_date">Expiration Date:</form:label>
		        <form:errors path="expiration_date"/>
		        <form:input path="expiration_date" type="Date"/>
		    </p>   
		    <p>
			    <button>Add License</button>
			 </p>
	</form:form>
	</body>
</html>