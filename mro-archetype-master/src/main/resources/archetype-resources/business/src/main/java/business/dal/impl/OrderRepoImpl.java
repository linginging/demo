#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal.impl;

import ${package}.business.dal.interfaces.OrderRepo;
import ${package}.business.dal.mappers.OrderMapper;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单db操作实现类
 *
 * @author joy
 */
@Service
public class OrderRepoImpl implements OrderRepo {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer searchTotalCount(OrderSearchModel model) {
        return orderMapper.searchTotalCount(model);
    }

    @Override
    public List<OrderModel> search(OrderSearchModel model) {
        return orderMapper.search(model);
    }

    @Override
    public Boolean add(OrderModel model) {
        return orderMapper.insertOrder(model) > 0;
    }

    @Override
    public Boolean update(OrderModel model) {
        return orderMapper.updateOrder(model) > 0;
    }

    @Override
    public Boolean deleteByOrderCode(String orderCode) {
        return orderMapper.deleteOrder(orderCode) > 0;
    }
}
