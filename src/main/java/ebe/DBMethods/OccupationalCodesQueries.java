package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class OccupationalCodesQueries extends DBQueries {

    @Autowired
    public OccupationalCodesQueries(JdbcTemplate jdbctemplate)
    {
        super(jdbctemplate);
    }
}
