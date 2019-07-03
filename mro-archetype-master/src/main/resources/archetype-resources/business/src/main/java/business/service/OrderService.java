#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.service;

import ${package}.business.dal.interfaces.OrderRepo;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务处理接口
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 5:52 PM
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    /**
     * 搜索订单
     * @param model 搜索条件
     * @return 订单列表
     */
    public List<OrderModel> search(OrderSearchModel model) {
        return orderRepo.search(model);
    }

    /**
     * 搜索订单总条数
     * @param model 搜索条件
     * @return 总条数
     */
    public Integer searchTotalCount(OrderSearchModel model) {
        return orderRepo.searchTotalCount(model);
    }

    /**
     *  创建订单
     * @param model 订单实体
     * @return 是创建成功
     */
    public Boolean add(OrderModel model) {
        return orderRepo.add(model);
    }

    /**
     * 更新订单
     * @param model 订单实体
     * @return 是否更新成功
     */
    public Boolean update(OrderModel model) {
        return orderRepo.update(model);
    }

    /**
     * 根据订单编号删除订单
     * @param orderCode 订单编号
     * @return 是否删除成功
     */
    public Boolean deleteByOrderCode(String orderCode) {
        return orderRepo.deleteByOrderCode(orderCode);
    }
}
