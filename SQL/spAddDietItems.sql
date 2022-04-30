
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spAddDietItems`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spAddDietItems`(
IN Type Varchar(45),
IN ItemName Varchar (45),
IN Calories Varchar (10)
)
BEGIN

Insert into DietItems(type, itemName , calories) 
Values(Type, ItemName, Calories);

END$$

DELIMITER ;
;
