package ebe.DBMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class IndustrySectorQueries extends DBQueries {

    @Autowired
    public IndustrySectorQueries(JdbcTemplate jdbctemplate)
    {
        super(jdbctemplate);
    }
}
