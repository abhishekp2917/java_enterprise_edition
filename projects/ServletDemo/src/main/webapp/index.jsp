<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="../../static/css/index.css">
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <c:if test="${not empty failedLoginMessage}">
            <div class="error-message">${failedLoginMessage}</div>
        </c:if>
        <form action="login" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" placeholder="Enter your username" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <button type="submit" class="login-btn">Login</button>
        </form>
        <a href="register.jsp" class="register-link">Don't have an account? Register</a>
    </div>
</body>
</html>
