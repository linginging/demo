#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.model.order;

import cn.yzw.mro.common.model.BaseModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体信息
 * @author bean
 */
@Data
public class OrderModel extends BaseModel {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单名称
     */
    private String orderName;
    /**
     * 组织机构Id
     */
    private Long organizationId;
    /**
     * 组织机构code
     */
    private String organizationCode;
    /**
     * 组织机构名称
     */
    private String organizationName;
    /**
     * 供应商ID
     */
    private Long supplierId;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 订单创建时间
     */
    private Date orderDate;
    /**
     * 订单金额
     */
    private BigDecimal totalAmount;
}
