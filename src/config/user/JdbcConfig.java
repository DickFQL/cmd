package config.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class JdbcConfig {

    @Value("${db.url}")
    private String url;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;



    @Bean("JDbc")
    public Jdbc getJdbc(){
        Jdbc jdbc = new Jdbc();
        jdbc.setUrl(url);
        jdbc.setDriver(driver);
        jdbc.setUsername(username);
        jdbc.setPassword(password);

        return jdbc;
    }

}
