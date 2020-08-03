package ebe.api;

import ebe.jdbcRepos.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(path = "/api")
public class VacancyAPI {
    private VacancyQueries vacancyQueries;

    @Autowired
    public VacancyAPI(VacancyQueries va){

        vacancyQueries = va;
    }

    // Create Vacancies
    @GetMapping(value="/create/vacancy")
    public boolean createVacancy(
            @RequestParam(name="EmployerID") int employerId,
            @RequestParam(name="VacancyName") String vacancyName,
            @RequestParam(name="VacancyLink") String vacancyLink,
            @RequestParam(name="VacancySummary") String vacancySummary,
            @RequestParam(name="TypeOfVacancyID") int typeOfVacancyID,
            @RequestParam(name="StatusOfVacancyID") int StatusOfVacancyID,
            @RequestParam(name="StartOfVacancy") String startOfVacancy,
            @RequestParam(name="DeadlineForApplication") String deadlineForApplication,
            @RequestParam(name="OccupationalCodeID") int occupationalCodeID,
            @RequestParam(name="ApplicationMethodID") String applicationMethodID,
            @RequestParam(name="VacancyPostcode") String vacancyPostCode) throws ParseException {

         return 1 == vacancyQueries.createVacancy(employerId,vacancyName,vacancySummary,vacancyLink,typeOfVacancyID,
                 StatusOfVacancyID, startOfVacancy,deadlineForApplication,occupationalCodeID,applicationMethodID,
                 vacancyPostCode);
    }

    // Update Vacancies
    @GetMapping(value="/update/vacancy")
    public boolean updateVacancy(
            @RequestParam(name="EmployerID") int employerId,
            @RequestParam(name="VacancyName") String vacancyName,
            @RequestParam(name="VacancyOldName") String vacancyOldName,
            @RequestParam(name="VacancyLink") String vacancyLink,
            @RequestParam(name="VacancySummary") String vacancySummary,
            @RequestParam(name="TypeOfVacancyID") int typeOfVacancyID,
            @RequestParam(name="StatusOfVacancyID") int StatusOfVacancyID,
            @RequestParam(name="StartOfVacancy") String startOfVacancy,
            @RequestParam(name="DeadlineForApplication") String deadlineForApplication,
            @RequestParam(name="OccupationalCodeID") int occupationalCodeID,
            @RequestParam(name="ApplicationMethodID") String applicationMethodID,
            @RequestParam(name="VacancyPostcode") String vacancyPostCode,
            @RequestParam(name="VacancyOldPostcode") String vacancyOldPostCode) throws ParseException {

        int vacancyId = vacancyQueries.getVacancyIdByNameAndPostCode(vacancyOldName,vacancyOldPostCode);
        return 1 == vacancyQueries.updateVacancy(vacancyId,employerId,vacancyName,vacancySummary,vacancyLink,typeOfVacancyID,
                StatusOfVacancyID, startOfVacancy,deadlineForApplication,occupationalCodeID,applicationMethodID,
                vacancyPostCode);
    }

    // Delete Vacancy
    @DeleteMapping("/delete/vacancy")
    public boolean deleteVacancies(@RequestParam(value="vacancyId") Integer vacancyId){
        if (vacancyQueries.deleteVacancy(vacancyId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
