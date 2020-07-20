package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StatusOfVacancyQueries extends DBQueries {

    @Autowired
    public StatusOfVacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
