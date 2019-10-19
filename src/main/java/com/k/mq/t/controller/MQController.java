package com.k.mq.t.controller;

import com.k.mq.t.service.MQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/mq")
public class MQController {

    @Autowired
    private MQService mqService;

    @RequestMapping(value = "/send")
    public String sendStr(String name){
        mqService.sendMessage("dfd" + name);
        return "abc-" + name;
    }

    @RequestMapping(value = "/send/topic")
    public String sendTopic(String name){
        mqService.sendTopicMessage("hello" + name);
        return "topic-" + name;
    }

    @RequestMapping(value = "/send/queue")
    public String sendQueue(String name){
        mqService.sendQueueMessage("hello " + name);
        return "queue-" + name;
    }

}
