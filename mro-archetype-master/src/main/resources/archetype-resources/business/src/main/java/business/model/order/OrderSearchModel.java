#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.model.order;

import cn.yzw.mro.common.model.PageRequestBase;
import lombok.Data;

/**
 * 订单搜索条件实体
 * @author bean
 */
@Data
public class OrderSearchModel extends PageRequestBase {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 供应商名称
     */
    private String supplierName;
}
