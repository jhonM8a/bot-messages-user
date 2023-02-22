package com.jochoa.bot.domain.service.broker;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("received :"
                    + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
