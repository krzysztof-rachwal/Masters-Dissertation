package ebe.DBMethhods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LocalAuthorityQueries extends DBQueries {

    @Autowired
    public LocalAuthorityQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    } {

    }
}
