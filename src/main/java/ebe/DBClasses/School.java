package ebe.DBClasses;

public class School {

    private int SchoolID;
    private String Name;
    private String AddressCity;
    private String AddressStreet;
    private String AddressNumber;
    private String Email;
    private String Phone;

    public School(int schoolID, String name, String addressCity, String addressStreet, String addressNumber, String email, String phone) {
        SchoolID = schoolID;
        Name = name;
        AddressCity = addressCity;
        AddressStreet = addressStreet;
        AddressNumber = addressNumber;
        Email = email;
        Phone = phone;
    }

    public School(String name, String addressCity, String addressStreet, String addressNumber, String email, String phone) {
        Name = name;
        AddressCity = addressCity;
        AddressStreet = addressStreet;
        AddressNumber = addressNumber;
        Email = email;
        Phone = phone;
    }

    public School() {
    }

    public int getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(int schoolID) {
        SchoolID = schoolID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddressCity() {
        return AddressCity;
    }

    public void setAddressCity(String addressCity) {
        AddressCity = addressCity;
    }

    public String getAddressStreet() {
        return AddressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        AddressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        AddressNumber = addressNumber;
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
