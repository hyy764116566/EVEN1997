package com.hyy.listener;

import com.hyy.utils.MassageDto;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "my-topic",consumerGroup = "demo-producer-group")
public class ConsumerSimple implements RocketMQListener<MassageDto> {

    @Override
    public void onMessage(MassageDto s) {


        System.out.println(s);
    }
}
