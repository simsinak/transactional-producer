package com.sina;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.messaging.MessageChannel;

public class TestTransactionalProducer {
    public static void main(String[] args) {
        GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("beans.xml");
        applicationContext.close();
        System.out.println("Context Closed, waiting 60 seconds to check JMX before reloading it");
        // wait to check JMX Mbeans
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        applicationContext = new GenericXmlApplicationContext("beans.xml");
        System.out.println("Context Reloaded Successfully");
        //In this point JMX error must raise after message receive.
    }
}
