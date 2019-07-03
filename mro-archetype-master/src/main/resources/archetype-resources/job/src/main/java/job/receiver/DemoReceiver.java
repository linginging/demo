#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.job.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import static ${package}.business.constant.MqConstant.EXCHANGE_NAME;
import static ${package}.business.constant.MqConstant.QUEUE_NAME;
import static ${package}.business.constant.MqConstant.ROUTE_KEY;

/**
 * 接受消息处理
 *
 * @author : joy.x.wei
 * @Data : 2018/12/21
 * @Time : 1:05 PM
 */
@Slf4j
@Component
@RabbitListener(bindings = {
        @QueueBinding(value = @Queue(value = QUEUE_NAME, durable = "true", autoDelete = "false"),
                key = ROUTE_KEY,
                exchange = @Exchange(type = ExchangeTypes.TOPIC,
                        value = EXCHANGE_NAME,
                        durable = "true", autoDelete = "false"))})
public class DemoReceiver {

    /**
     * 处理接受消息
     * @param bytes 消息内容
     */
    @RabbitHandler
    public void receiveMessage(byte[] bytes) {
        try {
            String body = new String(bytes, StandardCharsets.UTF_8);
            log.info("body -> " + body);
        } catch (Exception e) {
            log.error("消息处理异常", e);
            throw new RuntimeException(e);
        }
    }
}
