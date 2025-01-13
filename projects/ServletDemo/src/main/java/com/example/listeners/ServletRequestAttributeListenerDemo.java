package com.example.listeners;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;

public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println(String.format("Attribute added to Request : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println(String.format("Attribute removed from Request : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println(String.format("Attribute replaced in Request : [ Attribute Name : %s | Attribute Value : %s ]", event.getName(), event.getValue()));
    }
}
