package com.giuliopulina.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWith5ServiceActivatorsWorking {

    public static void main(String... args) throws Exception {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context-with-5-service-activators.xml");

    }
}


