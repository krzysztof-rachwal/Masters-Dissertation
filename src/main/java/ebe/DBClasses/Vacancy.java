package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;

public class Vacancy {

    private int vacancyID;
    private int employerID;
    private String position;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date applicationDeadline;
    private double salary;
    private String description;
    private String typeOfContract;
    private @DateTimeFormat(pattern = "HH:mm") Time duration;

    public Vacancy(int vacancyID, int employerID, String position, Date applicationDeadline, double salary, String description, String typeOfContract, Time duration) {
        this.vacancyID = vacancyID;
        this.employerID = employerID;
        this.position = position;
        this.applicationDeadline = applicationDeadline;
        this.salary = salary;
        this.description = description;
        this.typeOfContract = typeOfContract;
        this.duration = duration;
    }

    public int getVacancyID() {
        return vacancyID;
    }

    public void setVacancyID(int vacancyID) {
        this.vacancyID = vacancyID;
    }

    public int getEmployerID() {
        return employerID;
    }

    public void setEmployerID(int employerID) {
        this.employerID = employerID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getApplicationDeadline() {
        return applicationDeadline;
    }

    public void setApplicationDeadline(Date applicationDeadline) {
        this.applicationDeadline = applicationDeadline;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(String typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
