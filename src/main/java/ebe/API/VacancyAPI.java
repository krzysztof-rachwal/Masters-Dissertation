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
            @RequestParam(name="employerName") int employerId,
            @RequestParam(name="VacancyTitle") String vacancyTitle,
            @RequestParam(name="Details") String details,
            @RequestParam(name="Link") String link,
            @RequestParam(name="TypeOfVacancy") int typeOfVacancy,
            @RequestParam(name="StatusOfVacancy") int StatusOfVacancy,
            @RequestParam(name="StartOfVacancy") String startOfVacancy,
            @RequestParam(name="ClosingDate") String closingDate,
            @RequestParam(name="OccupationalCode") int occupationalCode,
            @RequestParam(name="ApplicationMethod") String applicationMethod,
            @RequestParam(name="Postcode") String postCode) throws ParseException {

        return 1 == VacancyQrys.createVacancy(employerId,vacancyTitle,details,link,typeOfVacancy,StatusOfVacancy,
                startOfVacancy,closingDate,occupationalCode,applicationMethod,postCode);

    }

    ///////////////////////    DELETE     ////////////////////////////////
    //1. Delete Events
    @DeleteMapping("api/delete/vacancy")
    public boolean deleteVacancies(@RequestParam(value="vacancyId") Integer vacancyId){
        if (VacancyQrys.deleteVacancy(vacancyId) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
