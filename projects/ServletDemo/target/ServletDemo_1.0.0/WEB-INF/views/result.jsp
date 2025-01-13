<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page errorPage="/WEB-INF/views/error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Division Result</title>
    <link rel="stylesheet" href="../../static/css/result.css">
</head>
<body>
    <div class="result-container">
        <h1>Division of Square Result</h1>
        <%
            double squareNum1 = Double.parseDouble(request.getParameter("squareNum1"));
            double squareNum2 = Double.parseDouble(request.getParameter("squareNum2"));
            if(squareNum2==0) {
                throw new Exception("Division by Zero");
            }
            double result = squareNum1/squareNum2;
        %>
        <p>Result : <%= result %></p>
        <a href="/home" class="back-btn">Go Back</a>
    </div>
</body>
</html>
