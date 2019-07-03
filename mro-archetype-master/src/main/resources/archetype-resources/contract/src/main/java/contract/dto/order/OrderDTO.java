#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.contract.dto.order;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单提供对外实体DTO
 *
 * @author bean
 */
@Data
public class OrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    @NotBlank(message = "订单code不能为空")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;
    /**
     * 订单金额
     */
    private BigDecimal totalAmount;
}
