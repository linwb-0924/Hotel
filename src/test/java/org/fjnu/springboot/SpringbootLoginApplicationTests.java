package org.fjnu.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootLoginApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    //创建exchange和queue并建立连接
    void testcreaterabbit(){
        //创建exchange
        amqpAdmin.declareExchange(new DirectExchange("hotel"));
        //创建queue
        amqpAdmin.declareQueue(new Queue("addroom"));
        //建立queue和exchange的链接
        amqpAdmin.declareBinding(new Binding("addroom", Binding.DestinationType.QUEUE,"hotel","addroom",null));
    }


}
