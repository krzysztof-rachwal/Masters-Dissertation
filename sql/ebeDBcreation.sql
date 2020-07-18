SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema c1976275_Spring_DB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema c1976275_Spring_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `c1976275_Spring_DB` DEFAULT CHARACTER SET latin1 ;
USE `c1976275_Spring_DB` ;

-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`StatusOfEmployer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`StatusOfEmployer` (
  `StatusOfEmployerID` INT NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NULL,
  PRIMARY KEY (`StatusOfEmployerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`EmployeesRange`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`EmployeesRange` (
  `EmployeesRangeID` INT NOT NULL AUTO_INCREMENT,
  `EmployeesRange` VARCHAR(45) NULL,
  PRIMARY KEY (`EmployeesRangeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Employer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Employer` (
  `EmployerID` INT NOT NULL AUTO_INCREMENT,
  `StatusOfEmployer` INT NULL,
  `EmployerName` VARCHAR(45) NULL,
  `EmployerAddressCity` VARCHAR(45) NULL,
  `EmployerAddressStreet` VARCHAR(45) NULL,
  `EmployerAddressNumber` VARCHAR(45) NULL,
  `EmployerPostcode` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Phone` VARCHAR(45) NULL,
  `Website` VARCHAR(45) NULL,
  `NumberOfEmployees` INT NULL,
  `CompanySummary` VARCHAR(45) NULL,
  `Notes` VARCHAR(45) NULL,
  `EmployerDocumentsAndVideos` VARCHAR(45) NULL,
  `EmployerLogo` VARCHAR(45) NULL,
  `GivesSiteExperience` TINYINT NULL,
  `GivesSiteVisits` TINYINT NULL,
  `GivesWorkshops` TINYINT NULL,
  `GivesPresentations` TINYINT NULL,
  `AttendsCareerFairs` TINYINT NULL,
  `GivesWebinars` TINYINT NULL,
  `WorksWithPrimaryPupils` TINYINT NULL,
  `UseOfModernForeignLanguage` TINYINT NULL,
  `RunsBusinessInWelsh` TINYINT NULL,
  `CanDeliverToSchoolsInWelsh` TINYINT NULL,
  `HasApprenticeshipProgramm` TINYINT NULL,
  `SchoolsPreferences` INT NULL,
  `Employerscol` VARCHAR(45) NULL,
  INDEX `EmployerStatus_idx` (`StatusOfEmployer` ASC),
  INDEX `EmployeesRange_idx` (`NumberOfEmployees` ASC),
  PRIMARY KEY (`EmployerID`),
  CONSTRAINT `EmployerStatus`
    FOREIGN KEY (`StatusOfEmployer`)
    REFERENCES `c1976275_Spring_DB`.`StatusOfEmployer` (`StatusOfEmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployeesRange`
    FOREIGN KEY (`NumberOfEmployees`)
    REFERENCES `c1976275_Spring_DB`.`EmployeesRange` (`EmployeesRangeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Languages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Languages` (
  `LanguagesID` INT NOT NULL AUTO_INCREMENT,
  `Language` VARCHAR(45) NULL,
  PRIMARY KEY (`LanguagesID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`AreasOfCurriculum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`AreasOfCurriculum` (
  `AreasOfCurriculumID` INT NOT NULL AUTO_INCREMENT,
  `AreasOfCurriculum` VARCHAR(45) NULL,
  PRIMARY KEY (`AreasOfCurriculumID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`LocalAuthority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`LocalAuthority` (
  `LocalAuthorityID` INT NOT NULL AUTO_INCREMENT,
  `LocalAuthority` VARCHAR(45) NULL,
  PRIMARY KEY (`LocalAuthorityID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersect_Employer_Language`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersect_Employer_Language` (
  `EmployerID` INT NOT NULL,
  `LanguageID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `LanguageID`),
  INDEX `LanguageEmployer_idx` (`LanguageID` ASC),
  CONSTRAINT `LanguageEmployer`
    FOREIGN KEY (`LanguageID`)
    REFERENCES `c1976275_Spring_DB`.`Languages` (`LanguagesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerLanguage`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersect_Employer_AreasOfCurriculum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersect_Employer_AreasOfCurriculum` (
  `EmployerID` INT NOT NULL,
  `AreasOfCurriculumID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `AreasOfCurriculumID`),
  INDEX `AreasOfCurriculumEmployer_idx` (`AreasOfCurriculumID` ASC),
  CONSTRAINT `AreasOfCurriculumEmployer`
    FOREIGN KEY (`AreasOfCurriculumID`)
    REFERENCES `c1976275_Spring_DB`.`AreasOfCurriculum` (`AreasOfCurriculumID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerAreasOfCurriculum`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersect_Employer_LocalAuthority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersect_Employer_LocalAuthority` (
  `EmployerID` INT NOT NULL,
  `LocalAuthorityID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `LocalAuthorityID`),
  INDEX `LocalAuthorityEmployer_idx` (`LocalAuthorityID` ASC),
  CONSTRAINT `LocalAuthorityEmployer`
    FOREIGN KEY (`LocalAuthorityID`)
    REFERENCES `c1976275_Spring_DB`.`LocalAuthority` (`LocalAuthorityID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerLocalAuthority`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`IndustrySector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`IndustrySector` (
  `IndustrySectorID` INT NOT NULL,
  `IndustrySectorName` VARCHAR(45) NULL,
  PRIMARY KEY (`IndustrySectorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersection_EmployerIndustrySector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersection_EmployerIndustrySector` (
  `EmployerID` INT NOT NULL,
  `IndustrySectorID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `IndustrySectorID`),
  INDEX `IndustryEmployer_idx` (`IndustrySectorID` ASC),
  CONSTRAINT `IndustryEmployer`
    FOREIGN KEY (`IndustrySectorID`)
    REFERENCES `c1976275_Spring_DB`.`IndustrySector` (`IndustrySectorID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerIndustry`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Alumni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Alumni` (
  `AlumniID` INT NOT NULL,
  `AlumniName` VARCHAR(45) NULL,
  `AlumniSurname` VARCHAR(45) NULL,
  `AlumniSchool` INT NULL,
  PRIMARY KEY (`AlumniID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersection_Employer_Alumni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersection_Employer_Alumni` (
  `EmployerID` INT NOT NULL,
  `AlumniID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `AlumniID`),
  INDEX `AlumniEmployer_idx` (`AlumniID` ASC),
  CONSTRAINT `AlumniEmployer`
    FOREIGN KEY (`AlumniID`)
    REFERENCES `c1976275_Spring_DB`.`Alumni` (`AlumniID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerAlumni`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`School`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`School` (
  `SchoolID` INT NOT NULL,
  `SchoolName` VARCHAR(45) NULL,
  `SchoolAddressCity` VARCHAR(45) NULL,
  `SchoolAddressStreet` VARCHAR(45) NULL,
  `SchoolAddressNumber` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Phone` VARCHAR(45) NULL,
  PRIMARY KEY (`SchoolID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Intersect_Employer_School_Preferences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Intersect_Employer_School_Preferences` (
  `EmployerID` INT NOT NULL,
  `SchoolID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `SchoolID`),
  INDEX `SchoolEmployer_idx` (`SchoolID` ASC),
  CONSTRAINT `SchoolEmployer`
    FOREIGN KEY (`SchoolID`)
    REFERENCES `c1976275_Spring_DB`.`School` (`SchoolID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerSchool`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`OccupationalCodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`OccupationalCodes` (
  `OccupationalCodeID` INT NOT NULL,
  `OccupationalCode` VARCHAR(45) NULL,
  `OccupationalCodName` VARCHAR(45) NULL,
  PRIMARY KEY (`OccupationalCodeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`TypeOfVacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`TypeOfVacancy` (
  `TypeOfVacancyID` INT NOT NULL,
  `TypeOfVacancyName` INT NULL,
  PRIMARY KEY (`TypeOfVacancyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`StatusOfVacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`StatusOfVacancy` (
  `StatusOfVacancyID` INT NOT NULL,
  `StatusOfVacancyName` VARCHAR(45) NULL,
  PRIMARY KEY (`StatusOfVacancyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Vacancy` (
  `VacancyID` INT NOT NULL,
  `Employer` INT NULL,
  `Details` VARCHAR(45) NULL,
  `Link` VARCHAR(45) NULL,
  `TypeOfVacancy` INT NULL,
  `StatusOfVacancy` INT NULL,
  `StartOfVacancy` DATETIME NULL,
  `ClosingDate` DATETIME NULL,
  `OccupationalCode` INT NULL,
  `ApplicationMethod` VARCHAR(45) NULL,
  `Postcode` VARCHAR(45) NULL,
  PRIMARY KEY (`VacancyID`),
  INDEX `VacancyOccupatonalCode_idx` (`OccupationalCode` ASC),
  INDEX `VacanctyType_idx` (`TypeOfVacancy` ASC),
  INDEX `VacancyStatus_idx` (`StatusOfVacancy` ASC),
  INDEX `VacancyEmployer_idx` (`Employer` ASC),
  CONSTRAINT `VacancyOccupatonalCode`
    FOREIGN KEY (`OccupationalCode`)
    REFERENCES `c1976275_Spring_DB`.`OccupationalCodes` (`OccupationalCodeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyType`
    FOREIGN KEY (`TypeOfVacancy`)
    REFERENCES `c1976275_Spring_DB`.`TypeOfVacancy` (`TypeOfVacancyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyStatus`
    FOREIGN KEY (`StatusOfVacancy`)
    REFERENCES `c1976275_Spring_DB`.`StatusOfVacancy` (`StatusOfVacancyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyEmployer`
    FOREIGN KEY (`Employer`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`TypeOfEvent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`TypeOfEvent` (
  `TypeOfEventID` INT NOT NULL,
  `TypeOfEvent` VARCHAR(45) NULL,
  PRIMARY KEY (`TypeOfEventID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Event` (
  `EventID` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `TypeOfEvent` INT NULL,
  `isPublic` TINYINT NULL,
  `isCancelled` TINYINT NULL,
  `Postcode` VARCHAR(45) NULL,
  `NameOfAdviser` VARCHAR(45) NULL,
  `NumberOfAteendees` VARCHAR(45) NULL,
  `AttendingSchools` INT NULL,
  `AttendingEmployers` INT NULL,
  `PromotesApprenticeships` TINYINT NULL,
  `PromotesWelshLanguage` TINYINT NULL,
  `ChalangesGenderStereotypes` TINYINT NULL,
  PRIMARY KEY (`EventID`),
  INDEX `EventTypeOfEvent_idx` (`TypeOfEvent` ASC),
  CONSTRAINT `EventTypeOfEvent`
    FOREIGN KEY (`TypeOfEvent`)
    REFERENCES `c1976275_Spring_DB`.`TypeOfEvent` (`TypeOfEventID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
