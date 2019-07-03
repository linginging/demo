#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * @author : ryan.w.li
 * Date: 2018-08-28
 * Time: 下午4:09
 */
@SpringBootApplication
public class JobApplication {

    /**
     * 程序入口
     *
     * @param args 指定入参
     */
    public static void main(String[] args) {
        SpringApplication.run(JobApplication.class, args);
    }

}

