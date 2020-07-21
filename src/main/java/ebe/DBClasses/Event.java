package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Event {

    private int EventID;
    private String Name;
    private int TypeOfEvent;
    private Boolean isPublic;
    private Boolean isCancelled;
    private String PostCode;
    private String NameOfAdviser;
    private String NumberOfAteendees;
    private int AttendingSchools;
    private int AttendingEmployers;
    private Boolean PromotesApprentinceships;
    private Boolean PromotesWelshLanguage;
    private Boolean ChalangesGenderStereotypes;

    public Event(int eventID, String name, int typeOfEvent, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAteendees, int attendingSchools, int attendingEmployers, Boolean promotesApprentinceships, Boolean promotesWelshLanguage, Boolean chalangesGenderStereotypes) {
        EventID = eventID;
        Name = name;
        TypeOfEvent = typeOfEvent;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAteendees = numberOfAteendees;
        AttendingSchools = attendingSchools;
        AttendingEmployers = attendingEmployers;
        PromotesApprentinceships = promotesApprentinceships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChalangesGenderStereotypes = chalangesGenderStereotypes;
    }

    public Event(String name, int typeOfEvent, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAteendees, int attendingSchools, int attendingEmployers, Boolean promotesApprentinceships, Boolean promotesWelshLanguage, Boolean chalangesGenderStereotypes) {
        Name = name;
        TypeOfEvent = typeOfEvent;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAteendees = numberOfAteendees;
        AttendingSchools = attendingSchools;
        AttendingEmployers = attendingEmployers;
        PromotesApprentinceships = promotesApprentinceships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChalangesGenderStereotypes = chalangesGenderStereotypes;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int eventID) {
        EventID = eventID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getNumberOfAteendees() {
        return NumberOfAteendees;
    }

    public void setNumberOfAteendees(String numberOfAteendees) {
        NumberOfAteendees = numberOfAteendees;
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

    public Boolean getPromotesApprentinceships() {
        return PromotesApprentinceships;
    }

    public void setPromotesApprentinceships(Boolean promotesApprentinceships) {
        PromotesApprentinceships = promotesApprentinceships;
    }

    public Boolean getPromotesWelshLanguage() {
        return PromotesWelshLanguage;
    }

    public void setPromotesWelshLanguage(Boolean promotesWelshLanguage) {
        PromotesWelshLanguage = promotesWelshLanguage;
    }

    public Boolean getChalangesGenderStereotypes() {
        return ChalangesGenderStereotypes;
    }

    public void setChalangesGenderStereotypes(Boolean chalangesGenderStereotypes) {
        ChalangesGenderStereotypes = chalangesGenderStereotypes;
    }
}
