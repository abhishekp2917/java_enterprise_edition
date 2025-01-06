package com.example.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession session = httpRequest.getSession(false);
            if(session==null || session.getAttribute("username")==null) {
                httpResponse.sendRedirect("/");
                return;
            }
            httpRequest.setAttribute("username", session.getAttribute("username"));
            chain.doFilter(request, response);
        }
        else {
            throw new ServletException("Request is not of type HTTP");
        }
    }
}
