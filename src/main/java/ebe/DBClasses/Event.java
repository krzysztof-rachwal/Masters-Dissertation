package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Event {

    private int EventID;
    private String EventName;
    private int TypeOfEvent;
    private Boolean isPublic;
    private Boolean isCancelled;
    private String PostCode;
    private String NameOfAdviser;
    private String NumberOfAttendees;
    private int AttendingSchools;
    private int AttendingEmployers;
    private Boolean PromotesApprenticeships;
    private Boolean PromotesWelshLanguage;
    private Boolean ChallengesGenderStereotypes;

    public Event(int eventID, String eventName, int typeOfEvent, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAttendees, int attendingSchools, int attendingEmployers, Boolean promotesApprenticeships, Boolean promotesWelshLanguage, Boolean challengesGenderStereotypes) {
        EventID = eventID;
        EventName = eventName;
        TypeOfEvent = typeOfEvent;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAttendees = numberOfAttendees;
        AttendingSchools = attendingSchools;
        AttendingEmployers = attendingEmployers;
        PromotesApprenticeships = promotesApprenticeships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChallengesGenderStereotypes = challengesGenderStereotypes;
    }

    public Event(String eventName, int typeOfEvent, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAttendees, int attendingSchools, int attendingEmployers, Boolean promotesApprenticeships, Boolean promotesWelshLanguage, Boolean challengesGenderStereotypes) {
        EventName = eventName;
        TypeOfEvent = typeOfEvent;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAttendees = numberOfAttendees;
        AttendingSchools = attendingSchools;
        AttendingEmployers = attendingEmployers;
        PromotesApprenticeships = promotesApprenticeships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChallengesGenderStereotypes = challengesGenderStereotypes;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public int getTypeOfEvent() {
        return TypeOfEvent;
    }

    public void setTypeOfEvent(int typeOfEvent) {
        TypeOfEvent = typeOfEvent;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Boolean getCancelled() {
        return isCancelled;
    }

    public void setCancelled(Boolean cancelled) {
        isCancelled = cancelled;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getNameOfAdviser() {
        return NameOfAdviser;
    }

    public void setNameOfAdviser(String nameOfAdviser) {
        NameOfAdviser = nameOfAdviser;
    }

    public String getNumberOfAttendees() {
        return NumberOfAttendees;
    }

    public void setNumberOfAttendees(String numberOfAttendees) {
        NumberOfAttendees = numberOfAttendees;
    }

    public int getAttendingSchools() {
        return AttendingSchools;
    }

    public void setAttendingSchools(int attendingSchools) {
        AttendingSchools = attendingSchools;
    }

    public int getAttendingEmployers() {
        return AttendingEmployers;
    }

    public void setAttendingEmployers(int attendingEmployers) {
        AttendingEmployers = attendingEmployers;
    }

    public Boolean getPromotesApprenticeships() {
        return PromotesApprenticeships;
    }

    public void setPromotesApprenticeships(Boolean promotesApprenticeships) {
        PromotesApprenticeships = promotesApprenticeships;
    }

    public Boolean getPromotesWelshLanguage() {
        return PromotesWelshLanguage;
    }

    public void setPromotesWelshLanguage(Boolean promotesWelshLanguage) {
        PromotesWelshLanguage = promotesWelshLanguage;
    }

    public Boolean getChallengesGenderStereotypes() {
        return ChallengesGenderStereotypes;
    }

    public void setChallengesGenderStereotypes(Boolean challengesGenderStereotypes) {
        ChallengesGenderStereotypes = challengesGenderStereotypes;
    }
}
