#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.business.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Spring 工具类
 *
 * @author : joy.x.wei
 * @Data : 2018/12/12
 * @Time : 3:23 PM
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    /**
     *  spring 上下文
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    /**
     * 获取 ApplicationContext
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据 name 获取 Bean
     *
     * @param name bean名称
     * @return bean实例
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过 class 获取 Bean
     *
     * @param clazz 字节码
     * @param <T>   泛型
     * @return 泛型实例
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 获取环境变量
     *
     * @return 环境上下文
     */
    public static Environment getEnv() {
        return getBean(Environment.class);
    }

    /**
     * 获取当前profile环境
     *
     * @return 当前环境
     */
    public static String getActiveProfile() {
        return getEnv().getProperty("spring.profiles.active");
    }

}
