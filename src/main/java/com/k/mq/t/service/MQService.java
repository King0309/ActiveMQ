package com.k.mq.t.service;

import com.k.mq.t.MQ.producer.JMSProducer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class MQService {

    @Autowired
    private JMSProducer producer;

    @Autowired
    private Topic topic;
    @Autowired
    private Queue queue;

    public void sendMessage(String msg){
        Destination destination = new ActiveMQQueue("springboot.queue.test");
        producer.sendMessage(destination, msg);
    }

    public void sendTopicMessage(String msg){
        producer.sendMessage(topic, msg);
    }

    public void sendQueueMessage(String msg){
        producer.sendMessage(queue, msg);
    }

}
