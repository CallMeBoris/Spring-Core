package my.study.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("my.study.javaConfig")
public class AppConfig {

    @Bean(name = "cust", initMethod = "customInit", destroyMethod = "customDestroy")
    public Customer customer(){
        return new Customer();
    }
}
