package com.example.controllers;

import jakarta.servlet.*;
import java.io.IOException;

public  class SquareServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Creating SquareServlet object...");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        num1 *= num1;
        num2 *= num2;
        request.setAttribute("squareNum1", num1);
        request.setAttribute("squareNum2", num2);
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