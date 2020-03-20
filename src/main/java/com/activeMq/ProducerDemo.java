package com.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.activeMq
 * @ClassName: ProductorDemo
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/1/19 17:36
 */
@Service
public class ProducerDemo {

    @Resource
    private ActiveMQProperties activeMQProperties;

    public void productMessage(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMQProperties.getBrokerUrl());
        try {
            //create JMS connection
            Connection connection = factory.createConnection(activeMQProperties.getUser(), activeMQProperties.getPassword());
            connection.start();

            //two ways to send message
            //1.JMS producer
            //create session
            Session session = connection.createSession(false, JmsProperties.AcknowledgeMode.AUTO.getMode());

            //create Destination
            Queue producerQ = session.createQueue("producer");
            MessageProducer producer = session.createProducer(producerQ);
            producer.send(session.createTextMessage("producer test"));

            //2.ActiveMQ sender
            ActiveMQSession activeMQSession = (ActiveMQSession) connection.createSession(false, JmsProperties.AcknowledgeMode.AUTO.getMode());
            Queue senderQ = activeMQSession.createQueue("sender");
            QueueSender sender = activeMQSession.createSender(senderQ);
            ActiveMQTextMessage activeMQTextMessage = new ActiveMQTextMessage();
            activeMQTextMessage.setText("sender test");
            sender.send(activeMQTextMessage);

            //close connection, otherwise consumer/receiver can not get message
            connection.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
