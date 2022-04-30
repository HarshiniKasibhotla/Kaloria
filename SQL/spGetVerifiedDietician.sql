
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spGetVerifiedDietician`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spGetVerifiedDietician`(
)
BEGIN

Select DietitianId,FirstName,LastName,Address,Areas_Of_Expertise,RegistrationID,ZipCode,Rating from Dietitian
 where ApprovalIndicator = true and Verified=true ;

END$$

DELIMITER ;
;
