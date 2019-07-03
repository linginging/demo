#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.integration.interfaces;

/**
 * 消息发送集成接口
 *
 * @author : joy.x.wei
 * @Data : 2018/12/27
 * @Time : 10:22 AM
 */
public interface MqSendIntegration {
    /**
     * 消息发送
     *
     * @param topic   消息topic
     * @param routKey 路由键
     * @param content 发送内容
     * @return 发送是否成功
     */
    boolean send(String topic, String routKey, String content);
}
