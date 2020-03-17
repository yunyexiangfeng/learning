package com.activeMq;

import org.apache.activemq.*;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import javax.jms.Message;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.activeMq
 * @ClassName: ConsumerDemo
 * @Description: Test ActiveMQ Consumer
 *               For queue, after consumed, the message will be deleted
 *               there are three ways to consumer message
 *               1.JMS:Connection, Session and MessageConsumer
 *               2.ActiveMQ:ActiveMQConnection, ActiveMQSession and ActiveMQQueueReceiver
 *               3.ActiveMQ:ActiveMQConnection, ActiveMQSession and MessageListener
 * @Author: Administrator
 * @CreateDate: 2020/1/19 16:22
 */
@Service
public class ConsumerDemo {

    @Resource
    private ActiveMQProperties activeMQProperties;
    public String consumeMessage(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMQProperties.getBrokerUrl());
        try {
            //create JMS connection
            Connection connection = factory.createConnection(activeMQProperties.getUser(), activeMQProperties.getPassword());
            //create JMS connection
            /*Connection connection = factory.createConnection("admin", "admin");
            connection.start();
            //create JMS session
            Session session = connection.createSession(false, JmsProperties.AcknowledgeMode.AUTO.getMode());
            Queue consumerQ = session.createQueue("producer");

            //get JMS consumer
            MessageConsumer consumer = session.createConsumer(consumerQ);
            //receive message
            TextMessage jmsMessage = (TextMessage) consumer.receive();
            System.out.println("consume message : " + jmsMessage.getText());
            session.close();
            connection.stop();*/


            ActiveMQConnection activeMQConnection = (ActiveMQConnection) factory.createConnection("admin", "admin");
            activeMQConnection.start();
            //create activemq session
            ActiveMQSession activeMQSession = (ActiveMQSession) activeMQConnection.createSession(false, JmsProperties.AcknowledgeMode.AUTO.getMode());
            //create activemq destination
            ActiveMQQueue des = (ActiveMQQueue) activeMQSession.createQueue("sender");

            //create activemq consumer
            /*ActiveMQQueueReceiver receiver = (ActiveMQQueueReceiver) activeMQSession.createReceiver(des);
            //consume message, the receive() method is sync and block
            ActiveMQTextMessage activeMQTextMessage = (ActiveMQTextMessage) receiver.receive();
            System.out.println("receive message : " + activeMQTextMessage.getText());
            activeMQConnection.stop();*/

            ActiveMQMessageConsumer activeMQSessionConsumer = (ActiveMQMessageConsumer) activeMQSession.createConsumer(des);
            activeMQSessionConsumer.setMessageListener(message -> {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("receive message : " + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });

            return "";
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

}
