<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuizLet</title>
<link href="<c:url value="../resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="../resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="../resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Quiz - Best place to practice your knowledge</h2>
   <hr />

    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Questions List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Question</th>
       <th>Option1</th>
       <th>Option2</th>
       <th>Option3</th>
       <th>Option4</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempQuestion" items="${questions}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/customer/updateForm">
        <c:param name="customerId" value="${tempQuestion.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/customer/delete">
        <c:param name="customerId" value="${tempQuestion.id}" />
       </c:url>

       <tr>
        <td>${tempQuestion.questionDesc}</td>
        <td>${tempQuestion.option1}</td>
        <td>${tempQuestion.option2}</td>
        <td>${tempQuestion.option3}</td>
        <td>${tempQuestion.option4}</td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>