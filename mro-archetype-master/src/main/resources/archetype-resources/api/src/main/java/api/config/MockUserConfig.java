#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.config;

import cn.yzw.framework.core.auth.AuthUser;
import cn.yzw.mro.common.mock.EnableMockAuthUser;
import cn.yzw.mro.common.mock.MockUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 模拟权限用户
 *
 * @author : joy.x.wei
 * @Data : 2018/12/17
 * @Time : 9:34 AM
 */
@Profile({"dev"})
@Configuration
@EnableMockAuthUser
public class MockUserConfig {
    /**
     * 创建MockUserService bean
     *
     * @return MockUserService实例
     */
    @Bean
    public MockUserService mockUserService() {
        return new MockUserServiceImpl();
    }

    /**
     * 创建MockUserService实现类
     */
    public class MockUserServiceImpl implements MockUserService {
        /**
         * 用户ID
         */
        private final Long userId = 281165L;

        @Override
        public AuthUser createAuthUser() {
            AuthUser authUser = new AuthUser();
            authUser.setUniqueName("mro-test1");
            authUser.setUserId(userId);
            authUser.setDisplayName("模拟用户");
            authUser.setEmail("test@yzw.com");
            authUser.setCellPhone("13551370987");
            return authUser;
        }
    }
}
