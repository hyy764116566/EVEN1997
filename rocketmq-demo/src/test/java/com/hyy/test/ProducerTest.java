package com.hyy.test;

import com.alibaba.fastjson.JSON;
import com.hyy.RocketmqDemoApplication;
import com.hyy.utils.MassageDto;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Test
    public void sendMassage(){
        for (int i = 0; i < 10; i++) {
            rocketMQTemplate.syncSend("my-topic","first massage");
        }

        System.out.println("success");
    }
    @Test
    public void sendAsyncMsg() throws  InterruptedException{
        rocketMQTemplate.asyncSend("my-topic", "第一条异步",new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });
        Thread.sleep(3000);
    }
        @Test
    public void sendOneWayMsg(){
        rocketMQTemplate.sendOneWay("my-topic","第一条单向消息");
    }
    @Test
    public void sendJsonMsg(){
        MassageDto massageDto = new MassageDto(1,"小明","武汉");
        Message<MassageDto> build = MessageBuilder.withPayload(massageDto).build();
        rocketMQTemplate.syncSend("my-topic",build);


    }
    @Test
    public void sendDelayMsg() throws  Exception{
        MassageDto massageDto = new MassageDto(1,"小明","武汉");
        org.apache.rocketmq.common.message.Message message = new org.apache.rocketmq.common.message.Message("my-topic", JSON.toJSONBytes(massageDto));
        message.setDelayTimeLevel(5);
        rocketMQTemplate.getProducer().send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
        Thread.sleep(3000);

    }
}
