#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ui.api.test.test.controller;

import cn.yzw.framework.core.auth.AuthUser;
import ${package}.api.controller.SimpleDataController;
import ${package}.contract.dto.SimpleDataReqDTO;
import ${package}.ui.api.test.TestStarter;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 演示如何单元测试带有获取认证用户的接口
 * User: ryan.w.li
 * Date: 2018-09-08
 * Time: 上午12:07
 */
@SpringBootTest(classes = TestStarter.class)
@RunWith(SpringRunner.class)
public class SimpleDataControllerTest {

    @Autowired
    SimpleDataController simpleDataController;

    @Before
    public void before(){
        AuthUser authUser = new AuthUser();
        authUser.setUserId(1L);
        authUser.setGender("1");
        authUser.setAuthorities(Lists.newArrayList("xx1"));
        authUser.setUniqueName("admin");

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        RequestContextHolder.getRequestAttributes().setAttribute("authUser", authUser, 0);
    }

    @Test
    public void testDemoInvoke() {
        SimpleDataReqDTO simpleDataReqDTO = new SimpleDataReqDTO();
        simpleDataReqDTO.setParam1("dddd");
        Assert.assertNotNull(simpleDataController.getSimpleData(simpleDataReqDTO));
    }

}
