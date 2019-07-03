#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.dal;

import ${package}.business.dal.interfaces.SimpleDataRepo;
import ${package}.business.model.ModuleDetailModel;
import ${package}.business.model.SimpleDataPageReqModel;
import ${package}.business.test.TestStarter;
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
public class SimpleDataRepoTest {

    @Autowired
    private SimpleDataRepo simpleDataRepo;

    @Test
    public void queryPageSimpleData() {
        SimpleDataPageReqModel pageReqModel = new SimpleDataPageReqModel();
        pageReqModel.setPageNo(1);
        pageReqModel.setPageSize(20);
        pageReqModel.setSortField("created");
        pageReqModel.setOrderBy(2);
        pageReqModel.setModule("order");
        List<ModuleDetailModel> modelList = simpleDataRepo.queryPageSimpleData(pageReqModel);
        Assert.assertTrue("查询成功", modelList.size() > 0);
    }

    @Test
    public void queryPageTotal() {
        SimpleDataPageReqModel pageReqModel = new SimpleDataPageReqModel();
        pageReqModel.setModule("order");
        int count = simpleDataRepo.queryPageTotal(pageReqModel);
        Assert.assertTrue("查询成功", count > 0);
    }

}
