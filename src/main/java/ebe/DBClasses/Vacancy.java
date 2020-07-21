package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public class Vacancy {

    private int VacancyID;
    private int EmployerID;
    private String Details;
    private String Link;
    private int  TypeOfVacancy;
    private int StatusOfVacancy;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date StartOfVacancy;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date ClosingDate;
    private int OcupationalCode;
    private String ApplicationMethod;
    private String Postcode;

    public Vacancy(int vacancyID, int employerID, String details, String link, int typeOfVacancy, int statusOfVacancy, Date startOfVacancy, Date closingDate, int ocupationalCode, String applicationMethod, String postcode) {
        VacancyID = vacancyID;
        EmployerID = employerID;
        Details = details;
        Link = link;
        TypeOfVacancy = typeOfVacancy;
        StatusOfVacancy = statusOfVacancy;
        StartOfVacancy = startOfVacancy;
        ClosingDate = closingDate;
        OcupationalCode = ocupationalCode;
        ApplicationMethod = applicationMethod;
        Postcode = postcode;
    }

    public Vacancy(int employerID, String details, String link, int typeOfVacancy, int statusOfVacancy, Date startOfVacancy, Date closingDate, int ocupationalCode, String applicationMethod, String postcode) {
        EmployerID = employerID;
        Details = details;
        Link = link;
        TypeOfVacancy = typeOfVacancy;
        StatusOfVacancy = statusOfVacancy;
        StartOfVacancy = startOfVacancy;
        ClosingDate = closingDate;
        OcupationalCode = ocupationalCode;
        ApplicationMethod = applicationMethod;
        Postcode = postcode;
    }
}
