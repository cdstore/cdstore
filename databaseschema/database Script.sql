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
  `categoryid` INT NOT NULL AUTO_INCREMENT ,
  `categoryname` VARCHAR(45) NULL ,
  PRIMARY KEY (`categoryid`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`CD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`CD` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`CD` (
  `cdid` VARCHAR(20) NOT NULL ,
  `title` VARCHAR(60) NULL ,
  `price` INT NULL ,
  `categoryid` INT NOT NULL ,
  `artist` VARCHAR(45) NULL ,
  `label` VARCHAR(45) NULL ,
  PRIMARY KEY (`cdid`) ,
  INDEX `fk_CD_Category` (`categoryid` ASC) ,
  CONSTRAINT `fk_CD_Category`
    FOREIGN KEY (`categoryid` )
    REFERENCES `cdstore`.`Category` (`categoryid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`Address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Address` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Address` (
  `addressid` INT NOT NULL AUTO_INCREMENT ,
  `street` VARCHAR(100) NOT NULL ,
  `province` VARCHAR(20) NOT NULL ,
  `country` VARCHAR(20) NOT NULL ,
  `postalcode` VARCHAR(20) NOT NULL ,
  `phone` VARCHAR(20) NULL ,
  PRIMARY KEY (`addressid`) )
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
  `addressid` INT NULL ,
  PRIMARY KEY (`username`) ,
  INDEX `fk_account_Address1` (`addressid` ASC) ,
  CONSTRAINT `fk_account_Address1`
    FOREIGN KEY (`addressid` )
    REFERENCES `cdstore`.`Address` (`addressid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`Order` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`Order` (
  `orderid` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(20) NOT NULL ,
  `amount` VARCHAR(20) NOT NULL ,
  `status` ENUM('ORDERED','PROCESSED','DENIED') NOT NULL ,
  `date` DATE NULL ,
  PRIMARY KEY (`orderid`) ,
  INDEX `fk_PO_account1` (`username` ASC) ,
  CONSTRAINT `fk_PO_account1`
    FOREIGN KEY (`username` )
    REFERENCES `cdstore`.`Account` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cdstore`.`OrderDetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`OrderDetails` ;

CREATE  TABLE IF NOT EXISTS `cdstore`.`OrderDetails` (
  `cdid` VARCHAR(20) NOT NULL ,
  `orderid` INT NOT NULL ,
  `quantity` INT NOT NULL ,
  `price` DOUBLE NOT NULL ,
  PRIMARY KEY (`cdid`, `orderid`) ,
  INDEX `fk_CD_has_PO_PO1` (`orderid` ASC) ,
  INDEX `fk_CD_has_PO_CD1` (`cdid` ASC) ,
  CONSTRAINT `fk_CD_has_PO_CD1`
    FOREIGN KEY (`cdid` )
    REFERENCES `cdstore`.`CD` (`cdid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CD_has_PO_PO1`
    FOREIGN KEY (`orderid` )
    REFERENCES `cdstore`.`Order` (`orderid` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
