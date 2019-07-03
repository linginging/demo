#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.dal;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.net.InetAddress;

/**
 * 描述
 * @author : ryan.w.li
 * Date: 2018-09-13
 * Time: 下午7:12
 */
@Configuration
public class DalConfig {

    @Value("${symbol_dollar}{mro.elasticsearch.host:}")
    private String esHost;

    @Value("${symbol_dollar}{mro.elasticsearch.port:9300}")
    private int esPort;

    @Value("${symbol_dollar}{mro.elasticsearch.cluster-name:}")
    private String esClusterName;

    /**
     * 创建 es client bean
     * @return client 实例
     * @throws Exception 创建失败异常
     */
    @Bean
    public Client client() throws Exception {
        Settings settings = Settings.builder().put("cluster.name", esClusterName).build();
        String[]  hosts = esHost.split(",");
        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
        for (String host : hosts) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(StringUtils.trimAllWhitespace(host)), esPort));
        }
        return client;
    }
}
