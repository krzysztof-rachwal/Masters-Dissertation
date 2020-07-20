package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StatusEmployerQueries extends DBQueries {

    @Autowired
    public StatusEmployerQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
