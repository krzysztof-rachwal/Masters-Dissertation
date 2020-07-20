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
    private String Notes;
    private String EmployerDocumentsAndVideos;
    private String EmployerLogo;
    private Boolean GivesSiteExperience;
    private Boolean GivesSiteVisits;
    private Boolean GivesWorkshops;
    private Boolean GivesPresentations;
    private Boolean AttendsCareerFairs;
    private Boolean GivesWebinars;
    private Boolean WorksWithPrimaryPupils;
    private Boolean UseOfModernForeignLanguage;
    private Boolean RunsBusinessInWelsh;
    private Boolean CanDeliverToSchoolsInWelsh;
    private Boolean HasApprenticeshipProgramm;
    private int SchoolPreferences;
    private String Employerscol;

    public Employer(int employerID, int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber, String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary, String notes, String employerDocumentsAndVideos, String employerLogo, Boolean givesSiteExperience, Boolean givesSiteVisits, Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils, Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramm, int schoolPreferences, String employerscol) {
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
        Notes = notes;
        EmployerDocumentsAndVideos = employerDocumentsAndVideos;
        EmployerLogo = employerLogo;
        GivesSiteExperience = givesSiteExperience;
        GivesSiteVisits = givesSiteVisits;
        GivesWorkshops = givesWorkshops;
        GivesPresentations = givesPresentations;
        AttendsCareerFairs = attendsCareerFairs;
        GivesWebinars = givesWebinars;
        WorksWithPrimaryPupils = worksWithPrimaryPupils;
        UseOfModernForeignLanguage = useOfModernForeignLanguage;
        RunsBusinessInWelsh = runsBusinessInWelsh;
        CanDeliverToSchoolsInWelsh = canDeliverToSchoolsInWelsh;
        HasApprenticeshipProgramm = hasApprenticeshipProgramm;
        SchoolPreferences = schoolPreferences;
        Employerscol = employerscol;
    }

    public Employer(int statusOfEmployer, String employerName, String employerAddressCity, String employerAddressStreet, String employerAddressNumber, String employerPostcode, String email, String phone, String website, int numberOfEmployees, String companySummary, String notes, String employerDocumentsAndVideos, String employerLogo, Boolean givesSiteExperience, Boolean givesSiteVisits, Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils, Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramm, int schoolPreferences, String employerscol) {
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
        Notes = notes;
        EmployerDocumentsAndVideos = employerDocumentsAndVideos;
        EmployerLogo = employerLogo;
        GivesSiteExperience = givesSiteExperience;
        GivesSiteVisits = givesSiteVisits;
        GivesWorkshops = givesWorkshops;
        GivesPresentations = givesPresentations;
        AttendsCareerFairs = attendsCareerFairs;
        GivesWebinars = givesWebinars;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
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

    public Boolean getGivesSiteExperience() {
        return GivesSiteExperience;
    }

    public void setGivesSiteExperience(Boolean givesSiteExperience) {
        GivesSiteExperience = givesSiteExperience;
    }

    public Boolean getGivesSiteVisits() {
        return GivesSiteVisits;
    }

    public void setGivesSiteVisits(Boolean givesSiteVisits) {
        GivesSiteVisits = givesSiteVisits;
    }

    public Boolean getGivesWorkshops() {
        return GivesWorkshops;
    }

    public void setGivesWorkshops(Boolean givesWorkshops) {
        GivesWorkshops = givesWorkshops;
    }

    public Boolean getGivesPresentations() {
        return GivesPresentations;
    }

    public void setGivesPresentations(Boolean givesPresentations) {
        GivesPresentations = givesPresentations;
    }

    public Boolean getAttendsCareerFairs() {
        return AttendsCareerFairs;
    }

    public void setAttendsCareerFairs(Boolean attendsCareerFairs) {
        AttendsCareerFairs = attendsCareerFairs;
    }

    public Boolean getGivesWebinars() {
        return GivesWebinars;
    }

    public void setGivesWebinars(Boolean givesWebinars) {
        GivesWebinars = givesWebinars;
    }

    public Boolean getWorksWithPrimaryPupils() {
        return WorksWithPrimaryPupils;
    }

    public void setWorksWithPrimaryPupils(Boolean worksWithPrimaryPupils) {
        WorksWithPrimaryPupils = worksWithPrimaryPupils;
    }

    public Boolean getUseOfModernForeignLanguage() {
        return UseOfModernForeignLanguage;
    }

    public void setUseOfModernForeignLanguage(Boolean useOfModernForeignLanguage) {
        UseOfModernForeignLanguage = useOfModernForeignLanguage;
    }

    public Boolean getRunsBusinessInWelsh() {
        return RunsBusinessInWelsh;
    }

    public void setRunsBusinessInWelsh(Boolean runsBusinessInWelsh) {
        RunsBusinessInWelsh = runsBusinessInWelsh;
    }

    public Boolean getCanDeliverToSchoolsInWelsh() {
        return CanDeliverToSchoolsInWelsh;
    }

    public void setCanDeliverToSchoolsInWelsh(Boolean canDeliverToSchoolsInWelsh) {
        CanDeliverToSchoolsInWelsh = canDeliverToSchoolsInWelsh;
    }

    public Boolean getHasApprenticeshipProgramm() {
        return HasApprenticeshipProgramm;
    }

    public void setHasApprenticeshipProgramm(Boolean hasApprenticeshipProgramm) {
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


