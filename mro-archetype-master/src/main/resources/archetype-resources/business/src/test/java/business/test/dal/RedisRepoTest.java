#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test.dal;

import ${package}.business.dal.interfaces.RedisRepo;
import ${package}.business.test.TestStarter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 持久层领域单元测试
 *
 * @author : joy.x.wei
 * @Data : 2018/12/12
 * @Time : 12:11 PM
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class RedisRepoTest {

    @Autowired
    private RedisRepo redisRepo;

    @Test
    public void put() {
        redisRepo.put("test", "test");
        String value = redisRepo.get("test");
        Assert.assertEquals("test", value);
    }

}
