package com.example.controllers;

import jakarta.servlet.*;
import java.io.IOException;

public class CalculateServlet extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        RequestDispatcher resultRequestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/views/result.jsp");
        RequestDispatcher squareRequestDispatcher = servletContext.getNamedDispatcher("SquareServlet");
        squareRequestDispatcher.include(request, response);
        resultRequestDispatcher.forward(request, response);
    }
}
