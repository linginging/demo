#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.mappers;


import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单 db mapper
 * @author joy
 */
public interface OrderMapper {
    /**
     *  分页查询订单列表
     * @param model 订单搜索条件
     * @return 订单集合
     */
    List<OrderModel> search(OrderSearchModel model);

    /**
     *  查询订单条数
     * @param model 订单搜索条件
     * @return 总数
     */
    Integer searchTotalCount(OrderSearchModel model);
    /**
     *  新增订单
     * @param orderModel 订单信息
     * @return 插入成功数量
     */
    int insertOrder(OrderModel orderModel);

    /**
     *  更新订单
     * @param orderModel 订单信息
     * @return 更新成功数量
     */
    int updateOrder(OrderModel orderModel);

    /**
     *  删除订单
     * @param orderCode 订单状态
     * @return 删除成功数量
     */
    int deleteOrder(@Param("orderCode") String orderCode);
}
