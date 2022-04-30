
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spGetItemsByCondition`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spGetItemsByCondition`(
IN health varchar(45), IN allergy varchar(45)
)
BEGIN
Select * from DietItems where  HealthCondition NOT IN(health) AND Allergies NOT LIKE allergy; 
END$$

DELIMITER;
