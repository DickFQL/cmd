package jdbcTemplate.junit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigStu {

    @Bean("getstu")
    public Student getStudent(){
        return new Student();
    }
}
