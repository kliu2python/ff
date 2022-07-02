<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Result Session</title>
       <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
    </head>

    <body>
    	<div class="w3-content" style="max-width:800px">
			<c:forEach var="tempMap" items="${questionMap}">
	    	<div class="mySlides"> 
	    	  <p>${tempMap[]}</p>
	    	  <br>
	    	</div>
		</c:forEach>
		</div>
</body>
</html>