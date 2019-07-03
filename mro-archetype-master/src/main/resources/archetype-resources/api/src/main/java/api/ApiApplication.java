#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * 程序入口
 * @author : ryan.w.li
 * Date: 2018-08-28
 * Time: 下午4:09
 */
@SpringBootApplication
@ComponentScan(basePackages = {"${package}", "cn.yzw.mro.common.validation"})
public class ApiApplication {
    /**
     * 程序入口
     *
     * @param args 指定入参
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(ApiApplication.class).web(true).run(args);
    }

}
