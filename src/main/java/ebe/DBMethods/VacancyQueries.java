package ebe.DBMethods;

import ebe.DBClasses.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

public class VacancyQueries extends DBQueries {

    @Autowired
    public VacancyQueries(JdbcTemplate jdbctemplate) {
        super(jdbctemplate);
    }

}
