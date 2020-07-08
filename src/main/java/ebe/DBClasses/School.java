package ebe.DBClasses;

public class School {

    private int schoolID;
    private String schoolName;
    private String description;
    private String locationCity;
    private String locationStreet;
    private String locationNumber;
    private String locationPostcode;

    public School(int schoolID, String schoolName, String description, String locationCity, String locationStreet, String locationNumber, String locationPostcode) {
        this.schoolID = schoolID;
        this.schoolName = schoolName;
        this.description = description;
        this.locationCity = locationCity;
        this.locationStreet = locationStreet;
        this.locationNumber = locationNumber;
        this.locationPostcode = locationPostcode;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
