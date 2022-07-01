<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
       <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<style>
		.mySlides {display:none}
		table, th, td {
		  border:1px solid black;
		}
		</style>
</head>
<body>
	<div class="w3-content" style="max-width:800px">
		<table>
			<tr>
			  <th>QuizID</th>
			  <th>QuizName</th> 
			  <th>QuizType</th>
			  <th>Ready?</th>
			</tr>
			<c:forEach var="tempQuiz" items="${quizes}">
				
				<tr>
					<td>${tempQuiz.id}</td>
					<td>${tempQuiz.quizName}</td>
					<td>${tempQuiz.quizType}</td>
					<td>
					<form action="list" method="get">
					<button name="theId" type="submit" value="${tempQuiz.id}">GO
					</button>
					</form>
					</td>
			    </tr>
		    </c:forEach>
	    </table>
	    
		Hello, User	${userId}. Welcome to QuizLet. 
		<form action="logout" method="get">
			<button name="logout" type="submit" value="true">Logout
			</button>
		</form>
		<form action="profile" method="get">
			<button name="userId" type="submit" value="${userId}">Profile
			</button>
		</form>
	</div>
	
</body>
</html>