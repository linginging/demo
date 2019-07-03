#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.integration;

import ${package}.business.integration.interfaces.SimpleDataIntegration;
import ${package}.business.model.SimpleDataModel;
import ${package}.business.model.SimpleDataReqModel;
import ${package}.business.test.TestStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 外部层领域单元测试
 *
 * @author : joy.x.wei
 * @Data : 2018/12/12
 * @Time : 12:11 PM
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class SimpleDataIntegrationTest {

    @Autowired
    private SimpleDataIntegration simpleDataIntegration;

    @Test
    public void getScoreByUniqueName() {
        SimpleDataModel simpleData = simpleDataIntegration.getSimpleData(new SimpleDataReqModel());
        Assert.assertEquals(simpleData.getParam4(),"test4");
    }

}
