package ebe.DBMethhods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeesRangeQueries extends DBQueries {

    @Autowired
    public EmployeesRangeQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    } {

    }
}
