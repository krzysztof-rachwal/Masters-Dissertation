package ebe.DBMethhods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class LanguagesQueries extends DBQueries {

    @Autowired
    public LanguagesQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    } {

    }
}
