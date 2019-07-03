#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.controller;

import cn.yzw.framework.core.auth.AuthUser;
import ${package}.api.converter.OrderConverter;
import ${package}.contract.dto.order.OrderDTO;
import ${package}.contract.dto.order.OrderSearchDTO;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import ${package}.business.service.OrderService;
import cn.yzw.mro.common.model.Pagination;
import cn.yzw.mro.common.util.WrappedBeanCopier;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 订单controller
 *
 * @author : joy.x.wei
 * @Data : 2018/12/11
 * @Time : 4:30 PM
 */
@Api(tags = "order", description = "订单相关")
@Slf4j
@Validated
@RestController
@RequestMapping("v1/order")
public class OrderController {

    @Autowired
    private OrderConverter converter;

    @Autowired
    private OrderService orderService;

    @ApiOperation(notes = "订单查询接口", value = "")
    @PostMapping("/search")
    public Pagination<OrderDTO> search(@RequestBody @Valid OrderSearchDTO dto) {
        OrderSearchModel model = WrappedBeanCopier.copyProperties(dto, OrderSearchModel.class);
        List<OrderModel> rows = orderService.search(model);
        Pagination<OrderDTO> pagination = Pagination.create(converter.convert(rows), dto);
        if (dto.isQueryTotal()) {
            pagination.setTotal(orderService.searchTotalCount(model));
        }
        return pagination;
    }

    @ApiOperation(notes = "订单新增接口", value = "")
    @PostMapping("/add")
    public Boolean add(OrderDTO orderDTO) {
        OrderModel model = WrappedBeanCopier.copyProperties(orderDTO, OrderModel.class);
        model.setInDate(new Date());
        model.setInUserId(AuthUser.getCurrent().getUserId());
        model.setInUserName(AuthUser.getCurrent().getUniqueName());
        return orderService.add(model);
    }

    @ApiOperation(notes = "订单更新接口", value = "")
    @PostMapping("/update")
    public Boolean update(OrderDTO orderDTO) {
        OrderModel model = WrappedBeanCopier.copyProperties(orderDTO, OrderModel.class);
        model.setEditDate(new Date());
        model.setEditUserId(AuthUser.getCurrent().getUserId());
        model.setEditUserName(AuthUser.getCurrent().getUniqueName());
        return orderService.update(model);
    }

    @ApiOperation(notes = "通过订单code删除订单接口", value = "")
    @PostMapping("/deleteByOrderCode")
    public Boolean delete(@Valid @NotBlank(message = "订单code") String orderCode) {
        return orderService.deleteByOrderCode(orderCode);
    }
}
