package com.jochoa.bot.domain.service;

import com.jochoa.bot.persistence.ProducerActiveMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    ProducerActiveMq producerActiveMq;

    public void setMessage(String message){
        try {
            producerActiveMq.enqueueMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
