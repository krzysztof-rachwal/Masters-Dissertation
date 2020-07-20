package ebe.DBClasses;

public class Employer {

    private int EmployerID;
    private int StatusOfEmployer;
    private String EmployerName;
    private String EmployerAddressCity;
    private String EmployerAddressStreet;
    private String EmployerAddressNumber;
    private String EmployerPostcode;
    private String Email;
    private String Phone;
    private String Website;
    private int NumberOfEmployees;
    private String CompanySummary;
    private String EmployerDocumentsAndVideos;
    private String EmployerLogo;
    private Byte GivesSiteExperience;
    private Byte GivesSiteVisits;
    private Byte GivesWorkshops;
    private Byte GivesPresentations;
    private Byte AttendsCareerFairs;
    private Byte GivesWebinars;
    private Byte AttendsCreerFairs;
    private Byte WorksWithPrimaryPupils;
    private Byte UseOfModernForeignLanguage;
    private Byte RunsBusinessInWelsh;
    private Byte CanDeliverToSchoolsInWelsh;
    private Byte HasApprenticeshipProgramm;
    private int SchoolPreferences;
    private String Employerscol;


    public Employer(int employerID, int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber, String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary, String employerDocumentsAndVideos, String employerLogo, Byte givesSiteExperience, Byte givesSiteVisits, Byte givesWorkshops, Byte givesPresentations, Byte attendsCareerFairs, Byte givesWebinars, Byte attendsCreerFairs, Byte worksWithPrimaryPupils, Byte useOfModernForeignLanguage, Byte runsBusinessInWelsh, Byte canDeliverToSchoolsInWelsh, Byte hasApprenticeshipProgramm, int schoolPreferences, String employerscol) {
        EmployerID = employerID;
        StatusOfEmployer = statusOfEmployer;
        EmployerName = employerName;
        EmployerAddressCity = employerAddressCity;
        EmployerAddressStreet = employerAddressStreet;
        EmployerAddressNumber = employerAddressNumber;
        EmployerPostcode = employerPostcode;
        Email = email;
        Phone = phone;
        Website = website;
        NumberOfEmployees = numberOfEmployees;
        CompanySummary = companySummary;
        EmployerDocumentsAndVideos = employerDocumentsAndVideos;
        EmployerLogo = employerLogo;
        GivesSiteExperience = givesSiteExperience;
        GivesSiteVisits = givesSiteVisits;
        GivesWorkshops = givesWorkshops;
        GivesPresentations = givesPresentations;
        AttendsCareerFairs = attendsCareerFairs;
        GivesWebinars = givesWebinars;
        AttendsCreerFairs = attendsCreerFairs;
        WorksWithPrimaryPupils = worksWithPrimaryPupils;
        UseOfModernForeignLanguage = useOfModernForeignLanguage;
        RunsBusinessInWelsh = runsBusinessInWelsh;
        CanDeliverToSchoolsInWelsh = canDeliverToSchoolsInWelsh;
        HasApprenticeshipProgramm = hasApprenticeshipProgramm;
        SchoolPreferences = schoolPreferences;
        Employerscol = employerscol;
    }

    public int getEmployerID() {
        return EmployerID;
    }

    public void setEmployerID(int employerID) {
        EmployerID = employerID;
    }

    public int getStatusOfEmployer() {
        return StatusOfEmployer;
    }

    public void setStatusOfEmployer(int statusOfEmployer) {
        StatusOfEmployer = statusOfEmployer;
    }

    public String getEmployerName() {
        return EmployerName;
    }

    public void setEmployerName(String employerName) {
        EmployerName = employerName;
    }

    public String getEmployerAddressCity() {
        return EmployerAddressCity;
    }

    public void setEmployerAddressCity(String employerAddressCity) {
        EmployerAddressCity = employerAddressCity;
    }

    public String getEmployerAddressStreet() {
        return EmployerAddressStreet;
    }

    public void setEmployerAddressStreet(String employerAddressStreet) {
        EmployerAddressStreet = employerAddressStreet;
    }

    public String getEmployerAddressNumber() {
        return EmployerAddressNumber;
    }

    public void setEmployerAddressNumber(String employerAddressNumber) {
        EmployerAddressNumber = employerAddressNumber;
    }

    public String getEmployerPostcode() {
        return EmployerPostcode;
    }

    public void setEmployerPostcode(String employerPostcode) {
        EmployerPostcode = employerPostcode;
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

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public int getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        NumberOfEmployees = numberOfEmployees;
    }

    public String getCompanySummary() {
        return CompanySummary;
    }

    public void setCompanySummary(String companySummary) {
        CompanySummary = companySummary;
    }

    public String getEmployerDocumentsAndVideos() {
        return EmployerDocumentsAndVideos;
    }

    public void setEmployerDocumentsAndVideos(String employerDocumentsAndVideos) {
        EmployerDocumentsAndVideos = employerDocumentsAndVideos;
    }

    public String getEmployerLogo() {
        return EmployerLogo;
    }

    public void setEmployerLogo(String employerLogo) {
        EmployerLogo = employerLogo;
    }

    public Byte getGivesSiteExperience() {
        return GivesSiteExperience;
    }

    public void setGivesSiteExperience(Byte givesSiteExperience) {
        GivesSiteExperience = givesSiteExperience;
    }

    public Byte getGivesSiteVisits() {
        return GivesSiteVisits;
    }

    public void setGivesSiteVisits(Byte givesSiteVisits) {
        GivesSiteVisits = givesSiteVisits;
    }

    public Byte getGivesWorkshops() {
        return GivesWorkshops;
    }

    public void setGivesWorkshops(Byte givesWorkshops) {
        GivesWorkshops = givesWorkshops;
    }

    public Byte getGivesPresentations() {
        return GivesPresentations;
    }

    public void setGivesPresentations(Byte givesPresentations) {
        GivesPresentations = givesPresentations;
    }

    public Byte getAttendsCareerFairs() {
        return AttendsCareerFairs;
    }

    public void setAttendsCareerFairs(Byte attendsCareerFairs) {
        AttendsCareerFairs = attendsCareerFairs;
    }

    public Byte getGivesWebinars() {
        return GivesWebinars;
    }

    public void setGivesWebinars(Byte givesWebinars) {
        GivesWebinars = givesWebinars;
    }

    public Byte getAttendsCreerFairs() {
        return AttendsCreerFairs;
    }

    public void setAttendsCreerFairs(Byte attendsCreerFairs) {
        AttendsCreerFairs = attendsCreerFairs;
    }

    public Byte getWorksWithPrimaryPupils() {
        return WorksWithPrimaryPupils;
    }

    public void setWorksWithPrimaryPupils(Byte worksWithPrimaryPupils) {
        WorksWithPrimaryPupils = worksWithPrimaryPupils;
    }

    public Byte getUseOfModernForeignLanguage() {
        return UseOfModernForeignLanguage;
    }

    public void setUseOfModernForeignLanguage(Byte useOfModernForeignLanguage) {
        UseOfModernForeignLanguage = useOfModernForeignLanguage;
    }

    public Byte getRunsBusinessInWelsh() {
        return RunsBusinessInWelsh;
    }

    public void setRunsBusinessInWelsh(Byte runsBusinessInWelsh) {
        RunsBusinessInWelsh = runsBusinessInWelsh;
    }

    public Byte getCanDeliverToSchoolsInWelsh() {
        return CanDeliverToSchoolsInWelsh;
    }

    public void setCanDeliverToSchoolsInWelsh(Byte canDeliverToSchoolsInWelsh) {
        CanDeliverToSchoolsInWelsh = canDeliverToSchoolsInWelsh;
    }

    public Byte getHasApprenticeshipProgramm() {
        return HasApprenticeshipProgramm;
    }

    public void setHasApprenticeshipProgramm(Byte hasApprenticeshipProgramm) {
        HasApprenticeshipProgramm = hasApprenticeshipProgramm;
    }

    public int getSchoolPreferences() {
        return SchoolPreferences;
    }

    public void setSchoolPreferences(int schoolPreferences) {
        SchoolPreferences = schoolPreferences;
    }

    public String getEmployerscol() {
        return Employerscol;
    }

    public void setEmployerscol(String employerscol) {
        Employerscol = employerscol;
    }
}
