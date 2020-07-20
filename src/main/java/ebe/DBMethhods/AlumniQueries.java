package ebe.DBMethhods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AlumniQueries extends DBQueries {

    @Autowired
    public AlumniQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    } {

    }
}
