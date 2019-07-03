#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 描述
 * @author : ryan.w.li
 * Date: 2018-10-28
 * Time: 下午5:04
 */
@Profile({"qa", "prd"})
@Configuration
@EnableApolloConfig
public class ApolloConfig {

}
