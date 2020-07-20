package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EventQueries extends DBQueries {

    @Autowired
    public EventQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
