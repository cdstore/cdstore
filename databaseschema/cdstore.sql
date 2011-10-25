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
  `price` DECIMAL(8,2) NULL ,
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
  `phone` VARCHAR(20) NOT NULL ,
  `city` VARCHAR(20) NOT NULL,
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
  `amount` DECIMAL(12,2) NOT NULL ,
  `orderstatus` ENUM('ORDERED','PROCESSED','DENIED') NOT NULL ,
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
  `price` DECIMAL(8,2) NOT NULL ,
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

INSERT INTO `cdstore`.`category` (categoryid,categoryname) values(1,'POP');
INSERT INTO `cdstore`.`category` (categoryid,categoryname) values(2,'JAZZ');
INSERT INTO `cdstore`.`category` (categoryid,categoryname) values(3,'COUNTRY');
INSERT INTO `cdstore`.`category` (categoryid,categoryname) values(4,'ROCK');
INSERT INTO `cdstore`.`category` (categoryid,categoryname) values(5,'GOSPEL');
INSERT INTO `cdstore`.`address`(`addressid`,`street`,`province`,`country`,`postalcode`,`phone`,`city`)VALUES(1,'3882 Carling','ON','Canada','k2h3d9','6135679876','Ottawa');
INSERT INTO `cdstore`.`account` (`username`, `lastname`, `firstname`, `password`, `addressid`) VALUES ('test', 'John', 'FT', 'test', 1);
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('1', 'The Way Of The Fist ', 5.29, 4, 'Five Finger', 'Prospect Pack');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('2', 'Stereo Hearts', 14.99, 1, 'Gym Class Heroes', 'Stero Hearts');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('3', 'The Good, The Bad', 19.99, 1, 'Joe', 'Kedar');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('5', 'Where It all Begins', 17.89, 1, 'Lalah Hathaway', 'Hallway');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('6', 'The Sideline Story', 10.59, 1, 'Cole', 'Colombia(USA)');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('7', 'Condensate', 9.99, 2, 'The original 7ven', 'Kader');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('8', 'Hello Fear', 10, 5, 'Kirk Franklin', 'Gospo Centric');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('9', 'God is Able', 11.99, 5, 'Hill Song', 'HillSong');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('10', 'Blessing', 10.99, 5, 'Laura Story', 'Fair Trade');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('11', 'Peace on Earth', 11.94, 5, 'Castle Crown', 'Reunion Records');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('12', 'The Road?', 9.99, 2, 'Keiko Matsui', 'Shanachie');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('13', 'Voice of My Beautiful Country', 7.99, 2, 'Rene Marie', 'Motema Music');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('14', 'For True', 4.93, 2, 'Trombone Shortly', 'Verve Forecast');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('15', 'Guitar Man', 7.83, 2, 'George Benson', 'Concord Jazz');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('16', 'In the Zone', 8.99, 2, 'Richard Elliot', 'Artistry Music');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('17', 'Baggage Claim', 2.25, 3, 'Miranda Lambert', 'Columbia Nashville');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('18', 'Beyond The Sun', 14.88, 3, 'Chris Isaak', 'VANGUARD');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('19', 'Let\'s Don\'t Call It A Night', 1.29, 3, 'Casey James', 'BNA Recordings');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('20', 'Best Of', 5.99, 3, 'Josh Turner', 'MCA Nashville');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('21', 'Paper Airplane', 7.99, 3, 'Alisson Kraus and Union Station', 'New Rounder');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('22', 'Never Really Wanted', 3.99, 3, 'Eric Pasley', 'EMI RECORDS NASHVILLE');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('23', 'Irresisble Force', 5.20, 4, 'Janes Addiction', 'Capitol');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('24', 'Junk Of The Heart', 14.55, 4, 'The Cooks', 'VANGUARD');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('25', 'Conditions of My Parole', 8.99, 4, 'Puscifer', 'Puscifer Entertainment LLC');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('26', 'New Blood', 7.99, 4, 'Peter Gabriel', 'The Real World Production ltd');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('27', 'Bottoms Up', 8.99, 4, 'Nickleback', 'Road Runner Records');
INSERT INTO `cdstore`.`cd` (`cdid`, `title`, `price`, `categoryid`, `artist`, `label`) VALUES ('28', 'Under and Over It', 4.99, 4, 'Five Finger', 'Prospect Pack');

