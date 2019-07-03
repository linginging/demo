#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.dal;

import ${package}.business.test.TestStarter;
import ${package}.business.dal.interfaces.OrderRepo;
import ${package}.business.model.order.OrderModel;
import ${package}.business.model.order.OrderSearchModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 持久层领域单元测试
 *
 * @author : joy.x.wei
 * @Data : 2018/12/12
 * @Time : 12:11 PM
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class OrderRepoTest {

    @Autowired
    private OrderRepo orderRepo;

    @Test
    public void search(){
        OrderSearchModel searchModel = new OrderSearchModel();
        searchModel.setPageNo(1);
        searchModel.setPageSize(100);
        List<OrderModel> orderModels = orderRepo.search(searchModel);
        Assert.assertEquals(100,orderModels.size());
    }

}
