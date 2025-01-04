package com.example.controllers;

import jakarta.servlet.*;
import java.io.IOException;

public  class UserServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Creating UserServlet object...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        System.out.println(String.format("Username : %s , Password : %s", username, password));
        servletResponse.getWriter().println(String.format("Welcome! %s.", username));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying UserServlet object...");
    }
}