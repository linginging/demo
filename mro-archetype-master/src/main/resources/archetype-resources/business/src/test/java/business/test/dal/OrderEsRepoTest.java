#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.dal;

import ${package}.business.dal.interfaces.EsRepo;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import ${package}.business.test.TestStarter;
import cn.yzw.mro.common.model.Pagination;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

/**
 * es 单元测试
 *
 * @author : joy.x.wei
 * @Data : 2018-12-28
 * @Time : 14:59
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class OrderEsRepoTest {
    @Autowired
    private EsRepo orderEsRepo;

    @Test
    public void updateOrder() {
        OrderModel orderModel = new OrderModel();
        orderModel.setOrderCode("1112");
        orderModel.setOrderDate(new Date());
        orderModel.setOrganizationId(102L);
        orderModel.setSysStatus((byte)1);
        orderModel.setId(1L);
        orderModel.setSupplierName("测试12");
        orderModel.setOrderName("订单名称2");
        orderModel.setOrderDate(new Date());
        orderModel.setInDate(new Date());
        orderModel.setInUserName("admin");
        orderModel.setTotalAmount(new BigDecimal(12.12));
        orderModel.setInUserId(1L);
        boolean updateOrder = orderEsRepo.updateOrder(orderModel);
        Assert.assertTrue(updateOrder);
    }

    //@Test
    public void deleteOrder() {
        boolean deleteOrder = orderEsRepo.deleteOrder("1112");
        Assert.assertTrue(deleteOrder);
    }

    @Test
    public void searchOrder() {
        OrderSearchModel searchModel = new OrderSearchModel();
        searchModel.setOrderCode("1112");
        Pagination<OrderModel> pagination = orderEsRepo.searchOrder(searchModel);
        Assert.assertEquals(1,pagination.getTotal());
    }
}
