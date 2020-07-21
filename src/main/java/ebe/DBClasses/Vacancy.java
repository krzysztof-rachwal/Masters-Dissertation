package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

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
    private int OccupationalCode;
    private String ApplicationMethod;
    private String Postcode;

    public Vacancy(int vacancyID, int employerID, String details, String link, int typeOfVacancy, int statusOfVacancy, Date startOfVacancy, Date closingDate, int occupationalCode, String applicationMethod, String postcode) {
        VacancyID = vacancyID;
        EmployerID = employerID;
        Details = details;
        Link = link;
        TypeOfVacancy = typeOfVacancy;
        StatusOfVacancy = statusOfVacancy;
        StartOfVacancy = startOfVacancy;
        ClosingDate = closingDate;
        OccupationalCode = occupationalCode;
        ApplicationMethod = applicationMethod;
        Postcode = postcode;
    }

    public Vacancy(int employerID, String details, String link, int typeOfVacancy, int statusOfVacancy, Date startOfVacancy, Date closingDate, int occupationalCode, String applicationMethod, String postcode) {
        EmployerID = employerID;
        Details = details;
        Link = link;
        TypeOfVacancy = typeOfVacancy;
        StatusOfVacancy = statusOfVacancy;
        StartOfVacancy = startOfVacancy;
        ClosingDate = closingDate;
        OccupationalCode = occupationalCode;
        ApplicationMethod = applicationMethod;
        Postcode = postcode;
    }

    public int getVacancyID() {
        return VacancyID;
    }

    public void setVacancyID(int vacancyID) {
        VacancyID = vacancyID;
    }

    public int getEmployerID() {
        return EmployerID;
    }

    public void setEmployerID(int employerID) {
        EmployerID = employerID;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public int getTypeOfVacancy() {
        return TypeOfVacancy;
    }

    public void setTypeOfVacancy(int typeOfVacancy) {
        TypeOfVacancy = typeOfVacancy;
    }

    public int getStatusOfVacancy() {
        return StatusOfVacancy;
    }

    public void setStatusOfVacancy(int statusOfVacancy) {
        StatusOfVacancy = statusOfVacancy;
    }

    public Date getStartOfVacancy() {
        return StartOfVacancy;
    }

    public void setStartOfVacancy(Date startOfVacancy) {
        StartOfVacancy = startOfVacancy;
    }

    public Date getClosingDate() {
        return ClosingDate;
    }

    public void setClosingDate(Date closingDate) {
        ClosingDate = closingDate;
    }

    public int getOccupationalCode() {
        return OccupationalCode;
    }

    public void setOccupationalCode(int occupationalCode) {
        OccupationalCode = occupationalCode;
    }

    public String getApplicationMethod() {
        return ApplicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        ApplicationMethod = applicationMethod;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }
}
