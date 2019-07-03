#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 描述
 * User: ryan.w.li
 * Date: 2018-09-13
 * Time: 下午8:07
 */
@SpringBootApplication
@ComponentScan(basePackages = "${package}.business")
@MapperScan(basePackages =
        {
                "${package}.business.dal.mappers"
        })
public class TestStarter {

    public static void main(String[] args) {
        SpringApplication.run(TestStarter.class, args);
    }

}
