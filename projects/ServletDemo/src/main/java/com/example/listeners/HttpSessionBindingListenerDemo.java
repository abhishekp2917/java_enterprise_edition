package com.example.listeners;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class HttpSessionBindingListenerDemo implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(String.format("Object bound to Session : [ Name : %s ]", event.getName()));
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(String.format("Object unbound from Session : [ Name : %s ]", event.getName()));
    }
}

