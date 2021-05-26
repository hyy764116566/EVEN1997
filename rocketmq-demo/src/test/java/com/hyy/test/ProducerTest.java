package com.hyy.test;

import com.hyy.RocketmqDemoApplication;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    @Test
    public void sendMassage(){
        rocketMQTemplate.syncSend("my-topic","first massage");
        System.out.println("success");
    }
}
