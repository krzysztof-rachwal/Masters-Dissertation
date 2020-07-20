package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class VacancyQueries extends DBQueries {

    @Autowired
    public VacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
