package com.giuliopulina;

import org.springframework.messaging.Message;

/**
 * Created by giuli_000 on 01/06/2015.
 */
public class MyServiceActivatorImpl implements ServiceActivator {
    public void handle(Message<Object> message) {
        System.out.println(this.getClass() + " handled " + message);
    }
}
