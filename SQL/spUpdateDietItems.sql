
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spUpdateDietItems`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spUpdateDietItems`(
IN Id Int,
IN type Varchar(45),
IN itemName Varchar (45),
IN calories Int
)
BEGIN
	Update DietItems set 
	Type = type , 
	ItemName = itemName , 
	Calories = calories 
	where ItemId = Id;
END$$

DELIMITER ;
;
