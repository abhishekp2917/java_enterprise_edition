package com.example.listeners;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class ServletRequestListenerDemo implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletRequest request =  sre.getServletRequest();
        String remoteAddress = request.getRemoteAddr();
        String protocol = request.getProtocol();
        System.out.println(String.format("Request initialized [ Remote address : %s | Protocol : %s ]",  remoteAddress, protocol));
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequest request =  sre.getServletRequest();
        String remoteAddress = request.getRemoteAddr();
        String protocol = request.getProtocol();
        System.out.println(String.format("Request destroyed [ Remote address : %s | Protocol : %s ]",  remoteAddress, protocol));
    }
}

