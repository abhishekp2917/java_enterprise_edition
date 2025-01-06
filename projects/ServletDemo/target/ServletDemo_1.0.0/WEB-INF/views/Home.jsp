<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

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
        <h2>User Information:</h3>
        <h4>User: ${username}</h3>
        <p><%= welcomeMessage %></p>
        <form action="/logout" method="post">
            <button type="submit" class="logout-btn">Logout</button>
        </form>
    </div>
</body>
</html>
