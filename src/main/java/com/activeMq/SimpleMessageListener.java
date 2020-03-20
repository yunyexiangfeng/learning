package com.activeMq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.activeMq
 * @ClassName: SimpleMessageListener
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/1/19 18:28
 */
public class SimpleMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
