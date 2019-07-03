#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.config;

import cn.yzw.framework.core.web.EnableFeignBizError;
import cn.yzw.mro.common.log.EnableTraceLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 运行的配置类
 * @author : ryan.w.li
 * Date: 2018-09-04
 * Time: 下午1:56
 */
@Configuration
@EnableFeignBizError
@EnableTraceLog
// @EnableFeignClients(basePackages = {"${groupId}"})
@MapperScan(basePackages = {"${package}.business.dal.mappers"})
public class RuntimeConfig {
}
