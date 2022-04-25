package main.otus.jmm.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExternalStorage {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getData(String name){
       return jdbcTemplate.queryForObject("Select value from data where :name ", new Object[]{name}, String.class);
    }

    public void putData(String name, String value){
        jdbcTemplate.update(
                "INSERT INTO schema.value (name, value) VALUES (?, ?)",
                name, value
        );
    }


}
