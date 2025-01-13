<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <link rel="stylesheet" href="../../static/css/error.css">
</head>
<body>
    <div class="error-container">
        <h1>Oops! Something went wrong.</h1>
        <p><strong>Error Code:</strong> <%= request.getAttribute("javax.servlet.error.status_code") %></p>
        <p><strong>Error Message:</strong> ${exception.getMessage()}</p>
        <p><strong>Requested URI:</strong> <%= request.getAttribute("javax.servlet.error.request_uri") %></p>
        <p><strong>Exception Type:</strong> <%= request.getAttribute("javax.servlet.error.exception_type") %></p>
        <p><strong>Servlet Name:</strong> <%= request.getAttribute("javax.servlet.error.servlet_name") %></p>
        <p><a href="/home">Go to Homepage</a></p>
    </div>
</body>
</html>
