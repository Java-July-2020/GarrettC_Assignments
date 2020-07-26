<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/dateStyle.css">
	<script src="js/date.js"></script>
</head>
<body>
<%
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("EEEEE, 'the' dd ' of ' MMMMM, y ");
	out.print( "<h2 align=\"center\">" + ft.format(date) + "</h2>");
%>
</body>
</html>