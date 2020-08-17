package ebe.api;

import ebe.DBMethods.EmployerQueries;
import ebe.DBMethods.EventQueries;
import ebe.DBMethods.SchoolQueries;
import ebe.DBMethods.VacancyQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


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
    @GetMapping(value="/api/create/vacancy")
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

    ///////////////////////    Update     ////////////////////////////////
    //2. Update Vacancies
    @GetMapping(value="/api/update/vacancy")
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

        int vacancyId = VacancyQrys.getVacancyIdByNameAndPostCode(vacancyOldName,vacancyOldPostCode);
        return 1 == VacancyQrys.updateVacancy(vacancyId,employerId,vacancyName,vacancySummary,vacancyLink,typeOfVacancyID,
                StatusOfVacancyID, startOfVacancy,deadlineForApplication,occupationalCodeID,applicationMethodID,
                vacancyPostCode);
    }

    ///////////////////////    DELETE     ////////////////////////////////
    //3. Delete Vacancy
    @DeleteMapping("api/delete/vacancy")
    public boolean deleteVacancies(@RequestParam(value="vacancyId") Integer vacancyId){
        if (VacancyQrys.deleteVacancy(vacancyId) == 1) {
            return true;
        } else {
            return false;
        }
    }

    ///////////////////////    SORT BY     ////////////////////////////////
    @GetMapping("api/vacancy/sortBy")
    public List<Integer> SortBy(@RequestParam(value="sortBy") String sortBy,
                                @RequestParam(value="orderBy") String orderBy){

        List<Integer> orderVacancyIds = new ArrayList<Integer>();

        if(sortBy.equals("Name") && orderBy.equals("ASC")){
            orderVacancyIds = VacancyQrys.sortByVacancyByNameASC();
        }

        if(sortBy.equals("Name") && orderBy.equals("DESC")){
            orderVacancyIds = VacancyQrys.sortByVacancyByNameDESC();
        }

        if(sortBy.equals("Date") && orderBy.equals("ASC")){
            orderVacancyIds = VacancyQrys.sortByVacancyByDateASC();
        }

        if(sortBy.equals("Date") && orderBy.equals("DESC")){
            orderVacancyIds = VacancyQrys.sortByVacancyByDateDESC();
        }

        return orderVacancyIds;
    }
}
