USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `spGetDietician`;

USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spGetDietician`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spGetDietician`(
IN DietitianId int
)
BEGIN
SELECT D.DietitianId as id,
	D.FirstName, D.LastName, D.Email, D.Mobile, D.Qualification, D.Specialization, D.Address, D.Availability_Hours, D.RegistrationID ,D.Zipcode , D.Timeslot
    FROM Dietitian D
	where id = DietitianId;
END$$

DELIMITER ;
;