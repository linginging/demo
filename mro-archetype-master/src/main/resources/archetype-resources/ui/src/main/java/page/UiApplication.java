#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.page;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 程序入口
 * @author : ryan.w.li
 * Date: 2018-08-28
 * Time: 下午4:10
 */
@SpringBootApplication(scanBasePackages = {"${package}.page"})
public class UiApplication {

    /**
     * 程序入口
     *
     * @param args 指定入参
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(UiApplication.class).web(true).run(args);
    }

}