package com.giuliopulina;

import org.springframework.messaging.Message;

/**
 * Created by giuli_000 on 01/06/2015.
 */
public interface ServiceActivator {

    public void handle(Message<Object> message);
}
