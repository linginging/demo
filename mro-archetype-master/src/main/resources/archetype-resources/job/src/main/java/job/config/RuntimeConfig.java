#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.job.config;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 运行的配置类
 * User: ryan.w.li
 * Date: 2018-09-04
 * Time: 下午1:56
 */
@Slf4j
@Configuration
@MapperScan(basePackages = {"${package}.dal.mappers"})
public class RuntimeConfig {
    /**
     * xxl 管理中心地址
     */
    @Value("${symbol_dollar}{xxl.job.admin.addresses}")
    private String adminAddresses;
    /**
     * job 名称
     */
    @Value("${symbol_dollar}{xxl.job.executor.appname}")
    private String appName;
    /**
     *  自定义本地IP
     */
    @Value("${symbol_dollar}{xxl.job.executor.ip}")
    private String ip;
    /**
     * 自定义本地端口号
     */
    @Value("${symbol_dollar}{xxl.job.executor.port}")
    private int port;

    /**
     * 初始化XxlJobSpringExecutor bean
     * @return XxlJobSpringExecutor实例
     */
    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        xxlJobSpringExecutor.setAppName(appName);
        xxlJobSpringExecutor.setIp(ip);
        xxlJobSpringExecutor.setPort(port);

        return xxlJobSpringExecutor;
    }
}
