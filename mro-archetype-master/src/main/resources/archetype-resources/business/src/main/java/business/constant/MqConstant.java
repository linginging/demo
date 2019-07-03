#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.constant;

/**
 * 消息业务常量
 *
 * @author : joy.x.wei
 * @Data : 2018/12/21
 * @Time : 1:09 PM
 */
public class MqConstant {
    /**
     *  QUEUE_NAME
     */
    public static final String QUEUE_NAME = "mro.ware.queue";
    /**
     * EXCHANGE_NAME
     */
    public static final String EXCHANGE_NAME = "mro.ware.topic";
    /**
     * ROUTE_KEY
     */
    public static final String ROUTE_KEY = "mro.ware";
}
