package com.example.listeners;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

public class HttpSessionActivationListenerDemo implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionID = session.toString();
        System.out.println(String.format("[ Session will passivate with ID: %s ]", sessionID));
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        String sessionID = session.toString();
        System.out.println(String.format("[ Session activated with ID: %s ]", sessionID));
    }
}

