package com.giuliopulina.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWith10ServiceActivatorsNotWorking {

    public static void main(String... args) throws Exception {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context-with-10-service-activators.xml");

    }
}


