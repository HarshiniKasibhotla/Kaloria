
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spGetWaitingDietitian`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spGetWaitingDietitian`(
)
BEGIN
Select DietitianId,FirstName,Address,Areas_Of_Expertise,RegistrationID from Dietitian where Verified = 0;
END$$

DELIMITER ;
;
