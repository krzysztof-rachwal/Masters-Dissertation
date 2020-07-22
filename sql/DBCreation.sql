-- MySQL Workbench Forward Engineering

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
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`StatusOfEmployerList` (
  `StatusOfEmployerID` INT NOT NULL AUTO_INCREMENT,
  `StatusOfEmployerName` VARCHAR(255) NULL,
  PRIMARY KEY (`StatusOfEmployerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`EmployeesRangeList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`EmployeesRangeList` (
  `EmployeesRangeID` INT NOT NULL AUTO_INCREMENT,
  `EmployeesRangeName` VARCHAR(255) NULL,
  PRIMARY KEY (`EmployeesRangeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Employer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Employer` (
  `EmployerID` INT NOT NULL AUTO_INCREMENT,
  `StatusOfEmployer` INT NULL,
  `Name` MEDIUMTEXT NULL,
  `AddressCity` MEDIUMTEXT NULL,
  `AddressStreet` MEDIUMTEXT NULL,
  `AddressNumber` MEDIUMTEXT NULL,
  `Postcode` MEDIUMTEXT NULL,
  `Email` LONGTEXT NULL,
  `Phone` MEDIUMTEXT NULL,
  `Website` MEDIUMTEXT NULL,
  `NumberOfEmployees` INT NULL,
  `CompanySummary` MEDIUMTEXT NULL,
  `Notes` MEDIUMTEXT NULL,
  `LogoLink` MEDIUMTEXT NULL,
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
  `HasApprenticeshipProgramme` TINYINT NULL,
  INDEX `EmployerStatus_idx` (`StatusOfEmployer` ASC),
  INDEX `EmployeesRange_idx` (`NumberOfEmployees` ASC),
  PRIMARY KEY (`EmployerID`),
  CONSTRAINT `EmployerStatus`
    FOREIGN KEY (`StatusOfEmployer`)
    REFERENCES `c1976275_Spring_DB`.`StatusOfEmployerList` (`StatusOfEmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployeesRange`
    FOREIGN KEY (`NumberOfEmployees`)
    REFERENCES `c1976275_Spring_DB`.`EmployeesRangeList` (`EmployeesRangeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`LanguagesList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`LanguagesList` (
  `LanguagesID` INT NOT NULL AUTO_INCREMENT,
  `LanguageName` VARCHAR(255) NULL,
  PRIMARY KEY (`LanguagesID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`AreasOfCurriculumList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`AreasOfCurriculumList` (
  `AreasOfCurriculumID` INT NOT NULL AUTO_INCREMENT,
  `AreasOfCurriculumName` MEDIUMTEXT NULL,
  PRIMARY KEY (`AreasOfCurriculumID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`LocalAuthorityList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`LocalAuthorityList` (
  `LocalAuthorityID` INT NOT NULL AUTO_INCREMENT,
  `LocalAuthorityName` MEDIUMTEXT NULL,
  PRIMARY KEY (`LocalAuthorityID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_LanguageUsedByEmployer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_LanguageUsedByEmployer` (
  `EmployerID` INT NOT NULL,
  `LanguageID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `LanguageID`),
  INDEX `LanguageEmployer_idx` (`LanguageID` ASC),
  CONSTRAINT `LanguageEmployer`
    FOREIGN KEY (`LanguageID`)
    REFERENCES `c1976275_Spring_DB`.`LanguagesList` (`LanguagesID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerLanguage`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_EmployerSupportOfAreasOfCurrriculum`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_EmployerSupportOfAreasOfCurrriculum` (
  `EmployerID` INT NOT NULL,
  `AreasOfCurriculumID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `AreasOfCurriculumID`),
  INDEX `AreasOfCurriculumEmployer_idx` (`AreasOfCurriculumID` ASC),
  CONSTRAINT `AreasOfCurriculumEmployer`
    FOREIGN KEY (`AreasOfCurriculumID`)
    REFERENCES `c1976275_Spring_DB`.`AreasOfCurriculumList` (`AreasOfCurriculumID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerAreasOfCurriculum`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_LocalAuthorityEmployerCanWorkWith`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_LocalAuthorityEmployerCanWorkWith` (
  `EmployerID` INT NOT NULL,
  `LocalAuthorityID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `LocalAuthorityID`),
  INDEX `LocalAuthorityEmployer_idx` (`LocalAuthorityID` ASC),
  CONSTRAINT `LocalAuthorityEmployer`
    FOREIGN KEY (`LocalAuthorityID`)
    REFERENCES `c1976275_Spring_DB`.`LocalAuthorityList` (`LocalAuthorityID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerLocalAuthority`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`IndustrySectorList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`IndustrySectorList` (
  `IndustrySectorID` INT NOT NULL AUTO_INCREMENT,
  `IndustrySectorName` MEDIUMTEXT NULL,
  PRIMARY KEY (`IndustrySectorID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_EmployerIndustrySector`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_EmployerIndustrySector` (
  `EmployerID` INT NOT NULL,
  `IndustrySectorID` INT NOT NULL,
  PRIMARY KEY (`EmployerID`, `IndustrySectorID`),
  INDEX `IndustryEmployer_idx` (`IndustrySectorID` ASC),
  CONSTRAINT `IndustryEmployer`
    FOREIGN KEY (`IndustrySectorID`)
    REFERENCES `c1976275_Spring_DB`.`IndustrySectorList` (`IndustrySectorID`)
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
  `AlumniID` INT NOT NULL AUTO_INCREMENT,
  `AlumniName` VARCHAR(255) NULL,
  `AlumniSurname` VARCHAR(255) NULL,
  `AlumniSchool` INT NULL,
  PRIMARY KEY (`AlumniID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_AlumniWorkingForEmployer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_AlumniWorkingForEmployer` (
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
  `SchoolID` INT NOT NULL AUTO_INCREMENT,
  `Name` MEDIUMTEXT NULL,
  `AddressCity` MEDIUMTEXT NULL,
  `AddressStreet` MEDIUMTEXT NULL,
  `AddressNumber` MEDIUMTEXT NULL,
  `Postcode` MEDIUMTEXT NULL,
  `Email` MEDIUMTEXT NULL,
  `Phone` MEDIUMTEXT NULL,
  PRIMARY KEY (`SchoolID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_EmployerSchoolPreferences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_EmployerSchoolPreferences` (
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
-- Table `c1976275_Spring_DB`.`OccupationalCodesList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`OccupationalCodesList` (
  `OccupationalCodeID` INT NOT NULL AUTO_INCREMENT,
  `OccupationalCodeName` MEDIUMTEXT NULL,
  PRIMARY KEY (`OccupationalCodeID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`TypeOfVacancyList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`TypeOfVacancyList` (
  `TypeOfVacancyID` INT NOT NULL AUTO_INCREMENT,
  `TypeOfVacancyName` MEDIUMTEXT NULL,
  PRIMARY KEY (`TypeOfVacancyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`StatusOfVacancyList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`StatusOfVacancyList` (
  `StatusOfVacancyID` INT NOT NULL AUTO_INCREMENT,
  `StatusOfVacancyName` VARCHAR(255) NULL,
  PRIMARY KEY (`StatusOfVacancyID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Vacancy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Vacancy` (
  `VacancyID` INT NOT NULL AUTO_INCREMENT,
  `EmployerID` INT NULL,
  `VacancyTitle` MEDIUMTEXT NULL,
  `Details` MEDIUMTEXT NULL,
  `Link` MEDIUMTEXT NULL,
  `TypeOfVacancy` INT NULL,
  `StatusOfVacancy` INT NULL,
  `StartOfVacancy` DATETIME NULL,
  `ClosingDate` DATETIME NULL,
  `OccupationalCode` INT NULL,
  `ApplicationMethod` MEDIUMTEXT NULL,
  `Postcode` MEDIUMTEXT NULL,
  PRIMARY KEY (`VacancyID`),
  INDEX `VacancyOccupatonalCode_idx` (`OccupationalCode` ASC),
  INDEX `VacanctyType_idx` (`TypeOfVacancy` ASC),
  INDEX `VacancyStatus_idx` (`StatusOfVacancy` ASC),
  INDEX `VacancyEmployer_idx` (`EmployerID` ASC),
  CONSTRAINT `VacancyOccupatonalCode`
    FOREIGN KEY (`OccupationalCode`)
    REFERENCES `c1976275_Spring_DB`.`OccupationalCodesList` (`OccupationalCodeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyType`
    FOREIGN KEY (`TypeOfVacancy`)
    REFERENCES `c1976275_Spring_DB`.`TypeOfVacancyList` (`TypeOfVacancyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyStatus`
    FOREIGN KEY (`StatusOfVacancy`)
    REFERENCES `c1976275_Spring_DB`.`StatusOfVacancyList` (`StatusOfVacancyID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `VacancyEmployer`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`TypeOfEventList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`TypeOfEventList` (
  `TypeOfEventID` INT NOT NULL AUTO_INCREMENT,
  `TypeOfEventName` VARCHAR(255) NULL,
  PRIMARY KEY (`TypeOfEventID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`Event` (
  `EventID` INT NOT NULL AUTO_INCREMENT,
  `Name` MEDIUMTEXT NULL,
  `TypeOfEvent` INT NULL,
  `Date` DATETIME NULL,
  `IsPublic` TINYINT NULL,
  `IsCancelled` TINYINT NULL,
  `Postcode` MEDIUMTEXT NULL,
  `NameOfAdviser` MEDIUMTEXT NULL,
  `NumberOfAttendees` INT NULL,
  `PromotesApprenticeships` TINYINT NULL,
  `PromotesWelshLanguage` TINYINT NULL,
  `ChallangesGenderStereotypes` TINYINT NULL,
  PRIMARY KEY (`EventID`),
  INDEX `EventTypeOfEvent_idx` (`TypeOfEvent` ASC),
  CONSTRAINT `EventTypeOfEvent`
    FOREIGN KEY (`TypeOfEvent`)
    REFERENCES `c1976275_Spring_DB`.`TypeOfEventList` (`TypeOfEventID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_AttendingSchoolsOnEvent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_AttendingSchoolsOnEvent` (
  `EventID` INT NOT NULL,
  `SchoolID` INT NOT NULL,
  PRIMARY KEY (`EventID`, `SchoolID`),
  INDEX `SchoolEvent_idx` (`SchoolID` ASC),
  CONSTRAINT `EventSchool`
    FOREIGN KEY (`EventID`)
    REFERENCES `c1976275_Spring_DB`.`Event` (`EventID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SchoolEvent`
    FOREIGN KEY (`SchoolID`)
    REFERENCES `c1976275_Spring_DB`.`School` (`SchoolID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`INT_AttendingEmployerOnEvent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`INT_AttendingEmployerOnEvent` (
  `EventID` INT NOT NULL,
  `EmployerID` INT NOT NULL,
  PRIMARY KEY (`EventID`, `EmployerID`),
  INDEX `EmployerEvent_idx` (`EmployerID` ASC),
  CONSTRAINT `EventEmployer`
    FOREIGN KEY (`EventID`)
    REFERENCES `c1976275_Spring_DB`.`Event` (`EventID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `EmployerEvent`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `c1976275_Spring_DB`.`EmployerDocumentLinks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `c1976275_Spring_DB`.`EmployerDocumentLinks` (
  `DocumentLinkID` INT NOT NULL AUTO_INCREMENT,
  `EmployerID` INT NULL,
  `Link` MEDIUMTEXT NULL,
  PRIMARY KEY (`DocumentLinkID`),
  INDEX `EmployerDocumentLink_idx` (`EmployerID` ASC),
  CONSTRAINT `EmployerDocumentLink`
    FOREIGN KEY (`EmployerID`)
    REFERENCES `c1976275_Spring_DB`.`Employer` (`EmployerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
