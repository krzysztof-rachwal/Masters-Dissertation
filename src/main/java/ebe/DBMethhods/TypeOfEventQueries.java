package ebe.DBMethhods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TypeOfEventQueries extends DBQueries {

    @Autowired
    public TypeOfEventQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    } {

    }
}
