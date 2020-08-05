package ebe.API;

import ebe.DBClasses.Vacancy;
import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class VacancyAPI {
    private EmployerQueries EmployerQrys;
    private EventQueries EventQrys;
    private SchoolQueries SchoolQrys;
    private VacancyQueries VacancyQrys;

    @Autowired
    public VacancyAPI(EmployerQueries em, EventQueries ev, SchoolQueries sc, VacancyQueries va){
        EmployerQrys = em;
        EventQrys = ev;
        SchoolQrys = sc;
        VacancyQrys = va;
    }

    ///////////////////////    CREATE     ////////////////////////////////
    //1. Create Vacancies
    @RequestMapping(value="/api/create/vacancy", method= RequestMethod.GET)
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


         return 1 == VacancyQrys.createVacancy(employerId,vacancyName,vacancySummary,vacancyLink,typeOfVacancyID,
                 StatusOfVacancyID, startOfVacancy,deadlineForApplication,occupationalCodeID,applicationMethodID,
                 vacancyPostCode);

    }

    ///////////////////////    DELETE     ////////////////////////////////
    //2. Delete Events
    @DeleteMapping("api/delete/vacancy")
    public boolean deleteVacancies(@RequestParam(value="vacancyId") Integer vacancyId){
        if (VacancyQrys.deleteVacancy(vacancyId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
