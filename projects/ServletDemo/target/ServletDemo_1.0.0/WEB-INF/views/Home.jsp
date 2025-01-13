<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page errorPage="/WEB-INF/views/error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="../../static/css/home.css">
</head>
<body>
    <div class="container">
        <%
            String welcomeMessage = (String) request.getAttribute("welcomeMessage");
            String username = (String) request.getAttribute("username");
        %>
        <h2>Current Date and Time:</h2>
        <p><%= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) %></p>
        <h2>User Information:</h2>
        <h4>User: <%= username != null ? username : "Guest" %></h4>
        <p><%= welcomeMessage != null ? welcomeMessage : "Welcome to the application!" %></p>

        <div class="calculation-panel">
            <h3>Division of Square Calculator</h3>
            <form action="/calculate" method="post">
                <label for="num1">Number 1:</label>
                <input type="number" id="num1" name="num1" required>
                <label for="num2">Number 2:</label>
                <input type="number" id="num2" name="num2" required>
                <button type="submit">Calculate</button>
            </form>
        </div>

        <form action="/logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>
</body>
</html>
