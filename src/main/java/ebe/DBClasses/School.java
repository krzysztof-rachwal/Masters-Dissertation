package ebe.DBClasses;

public class School {

    private int SchoolID;
    private String SchoolName;
    private String SchoolAddressCity;
    private String SchoolAddressStreet;
    private String SchoolAddressNumber;
    private String Email;
    private String Phone;

    public School(int schoolID, String schoolName, String schoolAddressCity, String schoolAddressStreet, String schoolAddressNumber, String email, String phone) {
        SchoolID = schoolID;
        SchoolName = schoolName;
        SchoolAddressCity = schoolAddressCity;
        SchoolAddressStreet = schoolAddressStreet;
        SchoolAddressNumber = schoolAddressNumber;
        Email = email;
        Phone = phone;
    }

    public School(String schoolName, String schoolAddressCity, String schoolAddressStreet, String schoolAddressNumber, String email, String phone) {
        SchoolName = schoolName;
        SchoolAddressCity = schoolAddressCity;
        SchoolAddressStreet = schoolAddressStreet;
        SchoolAddressNumber = schoolAddressNumber;
        Email = email;
        Phone = phone;
    }

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int schoolID) {
        SchoolID = schoolID;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getSchoolAddressCity() {
        return SchoolAddressCity;
    }

    public void setSchoolAddressCity(String schoolAddressCity) {
        SchoolAddressCity = schoolAddressCity;
    }

    public String getSchoolAddressStreet() {
        return SchoolAddressStreet;
    }

    public void setSchoolAddressStreet(String schoolAddressStreet) {
        SchoolAddressStreet = schoolAddressStreet;
    }

    public String getSchoolAddressNumber() {
        return SchoolAddressNumber;
    }

    public void setSchoolAddressNumber(String schoolAddressNumber) {
        SchoolAddressNumber = schoolAddressNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
