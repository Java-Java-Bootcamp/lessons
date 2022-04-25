package main.otus.jmm.enterprise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringContext {

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate();
    }


}
