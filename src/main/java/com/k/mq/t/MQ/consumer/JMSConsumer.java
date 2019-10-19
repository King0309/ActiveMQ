package com.k.mq.t.MQ.consumer;

import com.k.mq.t.MQ.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSConsumer {

    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String msg) {
        System.out.println("接收到消息：" + msg);
    }

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage(String msg) {
        System.out.println("接收到topic消息：" + msg);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String msg) {
        System.out.println("接收到queue消息：" + msg);
    }

    @JmsListener(destination = JmsConfig.TOPIC,containerFactory = "jmsListenerContainerTopic")
    public void onTopicMessage2(String msg) {
        System.out.println("接收到topic消息2：" + msg);
    }

    @JmsListener(destination = JmsConfig.QUEUE,containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage2(String msg) {
        System.out.println("接收到queue消息2：" + msg);
    }
}
