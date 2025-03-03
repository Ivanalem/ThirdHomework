package com.academy.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("Session with id " + event.getSession().getId() + " added attribute " + event.getName() + " value: " + event.getValue());
    }


    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("Session with id " + event.getSession().getId() + " removed attribute " + event.getName() + " value: " + event.getValue());

    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Session with id " + event.getSession().getId() + " replaced attribute " + event.getName() + " value: " + event.getValue());

    }
}
