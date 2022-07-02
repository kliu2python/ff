<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Question Session</title>
       <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
		<style>
		.mySlides {display:none}
		</style>
    </head>

    <body>
    	<div class="w3-content" style="max-width:800px">
	    	<c:forEach var="tempQuestion" items="${questions}">
		    	<div class="mySlides"> 
		    	  <p>${tempQuestion.questionDesc}</p>
		    	  
		    	  <input type="radio" id="1" name="options" value="${tempQuestion.option1}">
				  ${tempQuestion.option1}
				  <br>
				  <input type="radio" id="2" name="options" value="${tempQuestion.option2}">
				  ${tempQuestion.option2}
				  <br>
				  <input type="radio" id="3" name="options" value="${tempQuestion.option3}">
				  ${tempQuestion.option3}
				  <br>
				  <input type="radio" id="4" name="options" value="${tempQuestion.option4}">
				  ${tempQuestion.option4}
				  <br><br><br>
				  <button id="confirmBtn" onClick="generateJson(${tempQuestion.id})">
				  Confirm
				  </button>
				  <br><br>
		    	</div>
			</c:forEach>
		</div>
        <div class="w3-center">
        	<button class="w3-button" onclick="plusDivs(-1)">&#10094; Prev</button>
			<button class="w3-button" onclick="plusDivs(1)">Next &#10095;</button>
			<c:forEach var="tempSection" begin="1" end="10">
				<button class="w3-button demo" onclick="currentDiv(${tempSection})">${tempSection}</button>
			</c:forEach>
		</div>
		<form action="result" method="get">
			<button type="submit">Submit
			</button>
		</form>
		<script>
		var slideIndex = 1;
        
		showDivs(slideIndex);
		
		function plusDivs(n) {
			showDivs(slideIndex += n);
		}
		
		function currentDiv(n) {
		  showDivs(slideIndex = n);
		}
		
		function showDivs(n) {
		  var i;
		  var x = document.getElementsByClassName("mySlides");
		  var dots = document.getElementsByClassName("demo");
		  if (n > x.length) {slideIndex = 1}    
		  if (n < 1) {slideIndex = x.length}
		  for (i = 0; i < x.length; i++) {
		    x[i].style.display = "none";  
		  }
		  for (i = 0; i < dots.length; i++) {
		    dots[i].className = dots[i].className.replace(" w3-red", "");
		  }
		  x[slideIndex-1].style.display = "block";  
		  dots[slideIndex-1].className += " w3-red";
		}
		
		function generateJson(qId){
			
		 	var btn = document.getElementById('confirmBtn');
	        var output = document.getElementById('output');
	        var options = document.getElementsByName('options');
	        for (var i = 0; i < options.length; i++)	
	        {
	        	if (options[i].checked)
	        	{
	        		$.ajax({
	    				type : 'POST',
	    				url : 'saveAnswer',
	    				contentType : "application/json;charset=utf-8",
	    				data : JSON.stringify({
	    					"questionId": qId,
	    					"chosenOption": options[i].value 
	    				}),
	    				// the expected return type
	    				dataType : "json",
	    				success : plusDivs(1)
	    			});
	        	}
	        }
		} 
		</script>
    </body>
</html>