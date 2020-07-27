package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Event {

    private int EventID;
    private String Name;
    private int TypeOfEvent;
    private String TypeOfEventString;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date Date;
    private Boolean isPublic;
    private Boolean isCancelled;
    private String PostCode;
    private String NameOfAdviser;
    private String NumberOfAttendees;
    private Boolean PromotesApprenticeships;
    private Boolean PromotesWelshLanguage;
    private Boolean ChallangesGenderStereotypes;

    public Event(int eventID, String name, int typeOfEvent, java.util.Date date, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAttendees, Boolean promotesApprenticeships, Boolean promotesWelshLanguage, Boolean challangesGenderStereotypes) {
        EventID = eventID;
        Name = name;
        TypeOfEvent = typeOfEvent;
        Date = date;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAttendees = numberOfAttendees;
        PromotesApprenticeships = promotesApprenticeships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChallangesGenderStereotypes = challangesGenderStereotypes;
    }

    public Event(String name, int typeOfEvent, java.util.Date date, Boolean isPublic, Boolean isCancelled, String postCode, String nameOfAdviser, String numberOfAttendees, Boolean promotesApprenticeships, Boolean promotesWelshLanguage, Boolean challangesGenderStereotypes) {
        Name = name;
        TypeOfEvent = typeOfEvent;
        Date = date;
        this.isPublic = isPublic;
        this.isCancelled = isCancelled;
        PostCode = postCode;
        NameOfAdviser = nameOfAdviser;
        NumberOfAttendees = numberOfAttendees;
        PromotesApprenticeships = promotesApprenticeships;
        PromotesWelshLanguage = promotesWelshLanguage;
        ChallangesGenderStereotypes = challangesGenderStereotypes;
    }

    public Event() {
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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
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

    public Boolean getChallangesGenderStereotypes() {
        return ChallangesGenderStereotypes;
    }

    public void setChallangesGenderStereotypes(Boolean challangesGenderStereotypes) {
        ChallangesGenderStereotypes = challangesGenderStereotypes;
    }

    public String getTypeOfEventString() {
        return TypeOfEventString;
    }

    public void setTypeOfEventString(String typeOfEventString) {
        TypeOfEventString = typeOfEventString;
    }
}
