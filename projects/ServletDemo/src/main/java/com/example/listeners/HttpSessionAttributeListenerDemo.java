package com.example.listeners;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListenerDemo implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(String.format("Attribute added to Session : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(String.format("Attribute removed from Session : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(String.format("Attribute replaced in Session : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }
}
