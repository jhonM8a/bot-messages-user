package com.jochoa.bot.conf;

import com.jochoa.bot.domain.service.broker.ConsumerMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.*;

@Configuration
public class Config {
    @Autowired
    ConsumerMessageListener consumerMessageListener;

    private static final String QUEUE= "message";


    @Bean
    public Session sessionBean() throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        connection.start();
        return session;

    }

    @Bean
    public MessageConsumer messageConsumerBean() throws JMSException {
        MessageConsumer consume = this.sessionBean().createConsumer(this.queueBean());
        consume.setMessageListener(consumerMessageListener);
        return consume;
    }

    @Bean
    public Queue queueBean() throws JMSException {
        Queue queue = this.sessionBean().createQueue(QUEUE);
        return queue;

    }

    /*@Bean
    public ConsumerMessageListener consumerMessageListenerBean(){
        return new ConsumerMessageListener("consumer");
    }*/
}
