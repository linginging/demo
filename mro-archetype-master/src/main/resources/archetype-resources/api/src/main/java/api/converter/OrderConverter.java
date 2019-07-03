#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.converter;

import ${package}.contract.dto.order.OrderDTO;
import ${package}.business.model.order.OrderModel;
import cn.yzw.mro.common.util.WrappedBeanCopier;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 转换工具
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 5:46 PM
 */
@Component
public class OrderConverter {
    /**
     * orderModel 转换 OrderDTO
     * @param rows orderModel集合
     * @return OrderDTO转换结果
     */
    public List<OrderDTO> convert(List<OrderModel> rows) {
        return WrappedBeanCopier.copyPropertiesOfList(rows, OrderDTO.class);
    }
}
