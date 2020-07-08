package ebe.DBClasses;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Event {

    private int eventID;
    private String eventName;
    private int schoolID;
    private String eventType;
    private String locationCity;
    private String locationStreet;
    private String locationNumber;
    private String locationPostcode;
    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date date;

    public Event(int eventID, String eventName, int schoolID, String eventType, String locationCity, String locationStreet, String locationNumber, String locationPostcode, Date date) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.schoolID = schoolID;
        this.eventType = eventType;
        this.locationCity = locationCity;
        this.locationStreet = locationStreet;
        this.locationNumber = locationNumber;
        this.locationPostcode = locationPostcode;
        this.date = date;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationStreet() {
        return locationStreet;
    }

    public void setLocationStreet(String locationStreet) {
        this.locationStreet = locationStreet;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public void setLocationNumber(String locationNumber) {
        this.locationNumber = locationNumber;
    }

    public String getLocationPostcode() {
        return locationPostcode;
    }

    public void setLocationPostcode(String locationPostcode) {
        this.locationPostcode = locationPostcode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
