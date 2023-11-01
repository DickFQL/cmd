package config;


import config.user.Emp;
import config.user.JdbcConfig;
import config.user.WebConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @Configuration声明当前的类为核心配置类
 * @Bean 修饰方法，可以将方法的返回值作为一份实例装载进spring的核心容器中
 * @ComponentScan 可以基于核心配置类开启扫描包
 * @PropertySource
 * @Import 引入别的核心配置类
 */
@Configuration
@PropertySource("classpath:db.properties")
@Import({JdbcConfig.class, WebConfig.class})
public class SpringConfig {

    @Bean
    public Emp getEmp(){
        Emp emp = new Emp();
        emp.setId(123);
        emp.setName("dick");
        return emp;
    }


}
