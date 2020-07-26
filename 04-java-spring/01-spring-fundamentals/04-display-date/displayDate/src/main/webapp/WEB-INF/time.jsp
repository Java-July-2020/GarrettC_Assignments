<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/timeStyle.css">
	<script src="js/time.js"></script>
	
</head>
<body>
<%
	Date time = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("HH:mm a");
	out.print( "<h2 align=\"center\">" + ft.format(time) + "</h2>");
%>
</body>
</html>