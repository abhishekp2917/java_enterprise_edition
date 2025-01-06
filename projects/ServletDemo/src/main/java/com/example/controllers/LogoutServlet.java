package com.example.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String redirectURL = servletConfig.getInitParameter("redirectURL");
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("username")!=null) {
            session.invalidate();
        }
        response.sendRedirect(redirectURL);
    }
}



