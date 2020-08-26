package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AreasOfCurriculumQueries extends DBQueries {

    @Autowired
    public AreasOfCurriculumQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }
}
