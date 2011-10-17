SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `cdstore` ;
CREATE SCHEMA IF NOT EXISTS `cdstore` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `cdstore` ;

-- -----------------------------------------------------
-- Table `cdstore`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Category` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Category` (
  `CategoryID` INT NOT NULL AUTO_INCREMENT ,
  `CategoryName` VARCHAR(45) NULL ,
  PRIMARY KEY (`CategoryID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`CD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`CD` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`CD` (
  `cdid` VARCHAR(20) NOT NULL ,
  `title` VARCHAR(60) NULL ,
  `price` INT NULL ,
  `CategoryID` INT NOT NULL ,
  `artist` VARCHAR(45) NULL ,
  `label` VARCHAR(45) NULL ,
  PRIMARY KEY (`cdid`) ,
  INDEX `fk_CD_Category` (`CategoryID` ASC) ,
  CONSTRAINT `fk_CD_Category`
    FOREIGN KEY (`CategoryID` )
    REFERENCES `cdstore`.`Category` (`CategoryID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Address` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Address` (
  `AddressID` INT NOT NULL AUTO_INCREMENT ,
  `street` VARCHAR(100) NOT NULL ,
  `Province` VARCHAR(20) NOT NULL ,
  `country` VARCHAR(20) NOT NULL ,
  `Postalcode` VARCHAR(20) NOT NULL ,
  `Phone` VARCHAR(20) NULL ,
  PRIMARY KEY (`AddressID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`Account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Account` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Account` (
  `username` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NULL ,
  `firstname` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `AddressID` INT NULL ,
  PRIMARY KEY (`username`) ,
  INDEX `fk_account_Address1` (`AddressID` ASC) ,
  CONSTRAINT `fk_account_Address1`
    FOREIGN KEY (`AddressID` )
    REFERENCES `cdstore`.`Address` (`AddressID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Order` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Order` (
  `POID` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(20) NOT NULL ,
  `amount` VARCHAR(20) NOT NULL ,
  `Status` ENUM('ORDERED','PROCESSED','DENIED') NOT NULL ,
  `date` DATE NULL ,
  PRIMARY KEY (`POID`) ,
  INDEX `fk_PO_account1` (`username` ASC) ,
  CONSTRAINT `fk_PO_account1`
    FOREIGN KEY (`username` )
    REFERENCES `cdstore`.`Account` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`VisitEvent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`VisitEvent` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`VisitEvent` (
  `VisitEventID` INT NOT NULL AUTO_INCREMENT ,
  `day` VARCHAR(8) NULL ,
  `eventtype` ENUM('VIEW','CART','PURCHASE') NOT NULL ,
  `cdid` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`VisitEventID`) ,
  INDEX `fk_VisitEvent_CD1` (`cdid` ASC) ,
  CONSTRAINT `fk_VisitEvent_CD1`
    FOREIGN KEY (`cdid` )
    REFERENCES `cdstore`.`CD` (`cdid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`OrderDetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`OrderDetails` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`OrderDetails` (
  `cdid` VARCHAR(20) NOT NULL ,
  `POID` INT NOT NULL ,
  `Quantity` INT NOT NULL ,
  `Price` DOUBLE NOT NULL ,
  PRIMARY KEY (`cdid`, `POID`) ,
  INDEX `fk_CD_has_PO_PO1` (`POID` ASC) ,
  INDEX `fk_CD_has_PO_CD1` (`cdid` ASC) ,
  CONSTRAINT `fk_CD_has_PO_CD1`
    FOREIGN KEY (`cdid` )
    REFERENCES `cdstore`.`CD` (`cdid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CD_has_PO_PO1`
    FOREIGN KEY (`POID` )
    REFERENCES `cdstore`.`Order` (`POID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
