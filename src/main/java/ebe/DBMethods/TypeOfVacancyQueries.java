package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TypeOfVacancyQueries extends DBQueries {

    @Autowired
    public TypeOfVacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
