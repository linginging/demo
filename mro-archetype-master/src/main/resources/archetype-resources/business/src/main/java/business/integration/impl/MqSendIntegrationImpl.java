#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.integration.impl;

import ${package}.business.integration.interfaces.MqSendIntegration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

/**
 * 消息发送
 *
 * @author : joy.x.wei
 * @Data : 2018/12/27
 * @Time : 10:25 AM
 */
@Slf4j
@Service
public class MqSendIntegrationImpl implements MqSendIntegration {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public boolean send(String topic, String routKey, String content) {
        log.info("mq send topic={},content={}", topic, content);
        Message message = new Message(content.getBytes(Charset.forName("utf-8")), new MessageProperties());
        rabbitTemplate.send(topic, routKey, message);
        return true;
    }
}
