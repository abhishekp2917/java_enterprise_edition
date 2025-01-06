package com.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String requestMethod = httpRequest.getMethod();
            String requestUri = httpRequest.getRequestURI();
            System.out.println(String.format("[ Request Method : %s | Request URI : %s ]", requestMethod, requestUri));
            chain.doFilter(request, response);
        }
        else {
            throw new ServletException("Request is not of type HTTP");
        }
    }
}
