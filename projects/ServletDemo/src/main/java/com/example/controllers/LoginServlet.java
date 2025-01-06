package com.example.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        ServletConfig servletConfig = this.getServletConfig();
        String validUsername = servletContext.getInitParameter("username");
        String validPassword = servletContext.getInitParameter("password");
        String failedLoginRequestDispatcherPath = servletConfig.getInitParameter("failedLoginRequestDispatcherPath");
        String failedLoginMessage = servletConfig.getInitParameter("failedLoginMessage");
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(failedLoginRequestDispatcherPath);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals(validUsername) && password.equals(validPassword)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(60);
            response.sendRedirect("/home");
        }
        else {
            request.setAttribute("failedLoginMessage", failedLoginMessage);
            requestDispatcher.forward(request, response);
        }
    }
}



