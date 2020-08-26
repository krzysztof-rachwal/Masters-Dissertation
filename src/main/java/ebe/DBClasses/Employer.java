package ebe.DBClasses;

public class Employer {

    private int EmployerID;
    private int StatusOfEmployer;
    private String Name;
    private String AddressCity;
    private String AddressStreet;
    private String AddressNumber;
    private String Postcode;
    private String Email;
    private String Phone;
    private String Website;
    private int NumberOfEmployees;
    private String CompanySummary;
    private String Notes;
    private String LogoLink;
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
    private Boolean HasApprenticeshipProgramme;

    public Employer(int employerID, int statusOfEmployer, String name, String addressCity, String addressStreet, String addressNumber, String postcode, String email, String phone, String website, int numberOfEmployees, String companySummary, String notes, String logoLink, Boolean givesSiteExperience, Boolean givesSiteVisits, Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils, Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme) {
        EmployerID = employerID;
        StatusOfEmployer = statusOfEmployer;
        Name = name;
        AddressCity = addressCity;
        AddressStreet = addressStreet;
        AddressNumber = addressNumber;
        Postcode = postcode;
        Email = email;
        Phone = phone;
        Website = website;
        NumberOfEmployees = numberOfEmployees;
        CompanySummary = companySummary;
        Notes = notes;
        LogoLink = logoLink;
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
        HasApprenticeshipProgramme = hasApprenticeshipProgramme;
    }

    public Employer(int statusOfEmployer, String name, String addressCity, String addressStreet, String addressNumber, String postcode, String email, String phone, String website, int numberOfEmployees, String companySummary, String notes, String logoLink, Boolean givesSiteExperience, Boolean givesSiteVisits, Boolean givesWorkshops, Boolean givesPresentations, Boolean attendsCareerFairs, Boolean givesWebinars, Boolean worksWithPrimaryPupils, Boolean useOfModernForeignLanguage, Boolean runsBusinessInWelsh, Boolean canDeliverToSchoolsInWelsh, Boolean hasApprenticeshipProgramme) {
        StatusOfEmployer = statusOfEmployer;
        Name = name;
        AddressCity = addressCity;
        AddressStreet = addressStreet;
        AddressNumber = addressNumber;
        Postcode = postcode;
        Email = email;
        Phone = phone;
        Website = website;
        NumberOfEmployees = numberOfEmployees;
        CompanySummary = companySummary;
        Notes = notes;
        LogoLink = logoLink;
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
        HasApprenticeshipProgramme = hasApprenticeshipProgramme;
    }

    public Employer() {

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

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
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

    public String getLogoLink() {
        return LogoLink;
    }

    public void setLogoLink(String logoLink) {
        LogoLink = logoLink;
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

    public Boolean getHasApprenticeshipProgramme() {
        return HasApprenticeshipProgramme;
    }

    public void setHasApprenticeshipProgramme(Boolean hasApprenticeshipProgramme) {
        HasApprenticeshipProgramme = hasApprenticeshipProgramme;
    }
}


