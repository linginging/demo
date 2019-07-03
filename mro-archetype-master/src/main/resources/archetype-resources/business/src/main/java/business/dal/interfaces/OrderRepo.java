#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.interfaces;



import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;

import java.util.List;

/**
 * 订单db操作接口
 * @author joy
 */
public interface OrderRepo {

    /**
     *  分页查询订单列表
     * @param model 订单搜索条件
     * @return 订单集合
     */
    List<OrderModel> search(OrderSearchModel model);

    /**
     *  查询订单条数
     * @param model 订单搜索条件
     * @return 总条数
     */
    Integer searchTotalCount(OrderSearchModel model);
    /**
     *  新增订单
     * @param model 订单信息
     * @return 是否新增成功
     */
    Boolean add(OrderModel model);
    /**
     *  更新订单
     * @param model 订单信息
     * @return 是否更新成功
     */
    Boolean update(OrderModel model);
    /**
     *  通过订单code删除订单
     * @param orderCode 订单code
     * @return 是否删除成功
     */
    Boolean deleteByOrderCode(String orderCode);
}
