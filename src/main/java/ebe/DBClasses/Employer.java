package ebe.DBClasses;

public class Employer {

    private int employerID;
    private String name;
    private String locationCity;
    private String locationStreet;
    private String locationNumber;
    private String locationPostcode;
    private String contactPersonName;
    private String telephoneNumber;
    private String mobileNumber;
    private String email;
    private String twitter;
    private String website;
    private String sector;
    private int numberOfEmployers;
    private String localAuthList;
    private String companySummary;
    private Boolean workExperience;
    private Boolean siteVisits;
    private Boolean workshops;
    private Boolean careersFairs;
    private Boolean webinars;
    private Boolean workWithPrimarySchools;
    private Boolean workInForeignLanguage;
    private String ifYesWhichLanguage;
    private Boolean worksInWelsh;
    private Boolean hasApprenticeshipProgramme;
    private String curriculumAreas;
    private int schoolID;

    public Employer(int employerID, String name, String locationCity, String locationStreet, String locationNumber, String locationPostcode, String contactPersonName, String telephoneNumber, String mobileNumber, String email, String twitter, String website, String sector, int numberOfEmployers, String localAuthList, String companySummary, Boolean workExperience, Boolean siteVisits, Boolean workshops, Boolean careersFairs, Boolean webinars, Boolean workWithPrimarySchools, Boolean workInForeignLanguage, String ifYesWhichLanguage, Boolean worksInWelsh, Boolean hasApprenticeshipProgramme, String curriculumAreas, int schoolID) {
        this.employerID = employerID;
        this.name = name;
        this.locationCity = locationCity;
        this.locationStreet = locationStreet;
        this.locationNumber = locationNumber;
        this.locationPostcode = locationPostcode;
        this.contactPersonName = contactPersonName;
        this.telephoneNumber = telephoneNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.twitter = twitter;
        this.website = website;
        this.sector = sector;
        this.numberOfEmployers = numberOfEmployers;
        this.localAuthList = localAuthList;
        this.companySummary = companySummary;
        this.workExperience = workExperience;
        this.siteVisits = siteVisits;
        this.workshops = workshops;
        this.careersFairs = careersFairs;
        this.webinars = webinars;
        this.workWithPrimarySchools = workWithPrimarySchools;
        this.workInForeignLanguage = workInForeignLanguage;
        this.ifYesWhichLanguage = ifYesWhichLanguage;
        this.worksInWelsh = worksInWelsh;
        this.hasApprenticeshipProgramme = hasApprenticeshipProgramme;
        this.curriculumAreas = curriculumAreas;
        this.schoolID = schoolID;
    }

    public int getEmployerID() {
        return employerID;
    }

    public void setEmployerID(int employerID) {
        this.employerID = employerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getNumberOfEmployers() {
        return numberOfEmployers;
    }

    public void setNumberOfEmployers(int numberOfEmployers) {
        this.numberOfEmployers = numberOfEmployers;
    }

    public String getLocalAuthList() {
        return localAuthList;
    }

    public void setLocalAuthList(String localAuthList) {
        this.localAuthList = localAuthList;
    }

    public String getCompanySummary() {
        return companySummary;
    }

    public void setCompanySummary(String companySummary) {
        this.companySummary = companySummary;
    }

    public Boolean getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Boolean workExperience) {
        this.workExperience = workExperience;
    }

    public Boolean getSiteVisits() {
        return siteVisits;
    }

    public void setSiteVisits(Boolean siteVisits) {
        this.siteVisits = siteVisits;
    }

    public Boolean getWorkshops() {
        return workshops;
    }

    public void setWorkshops(Boolean workshops) {
        this.workshops = workshops;
    }

    public Boolean getCareersFairs() {
        return careersFairs;
    }

    public void setCareersFairs(Boolean careersFairs) {
        this.careersFairs = careersFairs;
    }

    public Boolean getWebinars() {
        return webinars;
    }

    public void setWebinars(Boolean webinars) {
        this.webinars = webinars;
    }

    public Boolean getWorkWithPrimarySchools() {
        return workWithPrimarySchools;
    }

    public void setWorkWithPrimarySchools(Boolean workWithPrimarySchools) {
        this.workWithPrimarySchools = workWithPrimarySchools;
    }

    public Boolean getWorkInForeignLanguage() {
        return workInForeignLanguage;
    }

    public void setWorkInForeignLanguage(Boolean workInForeignLanguage) {
        this.workInForeignLanguage = workInForeignLanguage;
    }

    public String getIfYesWhichLanguage() {
        return ifYesWhichLanguage;
    }

    public void setIfYesWhichLanguage(String ifYesWhichLanguage) {
        this.ifYesWhichLanguage = ifYesWhichLanguage;
    }

    public Boolean getWorksInWelsh() {
        return worksInWelsh;
    }

    public void setWorksInWelsh(Boolean worksInWelsh) {
        this.worksInWelsh = worksInWelsh;
    }

    public Boolean getHasApprenticeshipProgramme() {
        return hasApprenticeshipProgramme;
    }

    public void setHasApprenticeshipProgramme(Boolean hasApprenticeshipProgramme) {
        this.hasApprenticeshipProgramme = hasApprenticeshipProgramme;
    }

    public String getCurriculumAreas() {
        return curriculumAreas;
    }

    public void setCurriculumAreas(String curriculumAreas) {
        this.curriculumAreas = curriculumAreas;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }
}
