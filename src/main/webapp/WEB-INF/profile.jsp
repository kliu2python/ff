<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	.mySlides {display:none}
	table, th, td {
	  border:1px solid black;
	}
</style>
<title>User Profile</title>
</head>
<body>
	<h1>Welcome to User Profile page for customer ${user.userId}</h1>
	<div class="w3-content" style="max-width:800px">
		<table>
			<tr>
			  <th>CompleteQuizID</th>
			  <th>QuizType</th>
			  <th>StartDate</th>
			  <th>FinishDate</th>
			  <th>Score</th>
			  <th>Details</th>
			</tr>
			<c:forEach var="tempCompletedQuiz" items="${allQuiz}">
			<tr>
				<th>${tempCompletedQuiz.id}</th>
				<th>${tempCompletedQuiz.templateId}</th>
				<th>${tempCompletedQuiz.startDate}</th>
				<th>${tempCompletedQuiz.finishDate}</th>
				<th>${tempCompletedQuiz.score}</th>
				<td>
					<form action="list" method="get">
					<button name="theId" type="submit" value="${tempQuiz.id}">GO
					</button>
					</form>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>