#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.interfaces;


import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import cn.yzw.mro.common.model.Pagination;

/**
 * es ${parentArtifactId} 测试
 *
 * @author : joy.x.wei
 * @Data : 2018/12/20
 * @Time : 5:45 PM
 */
public interface EsRepo {
    /**
     * 分页查询订单信息
     *
     * @param orderSearchModel 分页查询条件
     * @return 分页结果
     */
    Pagination<OrderModel> searchOrder(OrderSearchModel orderSearchModel);

    /**
     * 更新订单信息
     *
     * @param orderModel 更新订单
     * @return 更新是否成功
     */
    boolean updateOrder(OrderModel orderModel);

    /**
     * 删除订单
     *
     * @param orderCode 订单code
     * @return 删除是否成功
     */
    boolean deleteOrder(String orderCode);
}
