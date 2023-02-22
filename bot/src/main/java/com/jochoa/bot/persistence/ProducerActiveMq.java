package com.jochoa.bot.persistence;

import com.jochoa.bot.domain.service.broker.ConsumerMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jms.*;
import java.net.URI;

@Repository
public class ProducerActiveMq{

    @Autowired
    private Session session;

    @Autowired
    private Queue queue;

    public ProducerActiveMq(){}

    private static final String QUEUE= "message";
    public void enqueueMessage(String message) throws Exception {

        try {
            Message messageQueue = session.createTextMessage(message);
            MessageProducer producer = session.createProducer(queue);
            producer.send(messageQueue);
            producer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
