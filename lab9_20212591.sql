-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`recetafavorita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`recetafavorita` (
  `idreceta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `area` VARCHAR(45) NULL DEFAULT NULL,
  `tags` VARCHAR(100) NULL DEFAULT NULL,
  `foto` VARCHAR(500) NULL DEFAULT NULL,
  `instrucciones` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`idreceta`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ingrediente` (
  `idingrediente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `idreceta` INT NOT NULL,
  PRIMARY KEY (`idingrediente`),
  INDEX `fk_ingrediente_recetaFavorita1_idx` (`idreceta` ASC) VISIBLE,
  CONSTRAINT `fk_ingrediente_recetaFavorita1`
    FOREIGN KEY (`idreceta`)
    REFERENCES `mydb`.`recetafavorita` (`idreceta`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `mydb`.`medida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`medida` (
  `idmedida` INT NOT NULL AUTO_INCREMENT,
  `mishur` VARCHAR(100) NULL DEFAULT NULL,
  `idreceta` INT NOT NULL,
  `idingrediente` INT NOT NULL,
  PRIMARY KEY (`idmedida`),
  INDEX `fk_medida_recetaFavorita_idx` (`idreceta` ASC) VISIBLE,
  INDEX `fk_medida_ingrediente1_idx` (`idingrediente` ASC) VISIBLE,
  CONSTRAINT `fk_medida_ingrediente1`
    FOREIGN KEY (`idingrediente`)
    REFERENCES `mydb`.`ingrediente` (`idingrediente`),
  CONSTRAINT `fk_medida_recetaFavorita`
    FOREIGN KEY (`idreceta`)
    REFERENCES `mydb`.`recetafavorita` (`idreceta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
