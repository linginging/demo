#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.integration;

import ${package}.business.integration.interfaces.MqSendIntegration;
import ${package}.business.test.TestStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消息发送
 *
 * @author : joy.x.wei
 * @Data : 2018-12-28
 * @Time : 11:46
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class MqSendIntegrationTest {
    @Autowired
    private MqSendIntegration mqSendIntegration;

    @Test
    public void send() {
        boolean result = mqSendIntegration.send("mro.ware.topic", "mro.ware", "hello mro1111");
        Assert.assertTrue(result);
    }
}
