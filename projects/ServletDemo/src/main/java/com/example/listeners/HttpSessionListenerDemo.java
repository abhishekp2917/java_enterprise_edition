package com.example.listeners;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class HttpSessionListenerDemo implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionID = session.getId();
        long sessionCreationTime = session.getCreationTime();
        System.out.println(String.format("Session Created : [ Session ID : %s | Session Creation Time : %s ]", sessionID, sessionCreationTime));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionID = session.getId();
        long sessionCreationTime = session.getCreationTime();
        System.out.println(String.format("Session Destroyed : [ Session ID : %s | Session Creation Time : %s ]", sessionID, sessionCreationTime));
    }
}

