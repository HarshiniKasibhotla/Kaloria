USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `getUser`;

USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`getUser`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `getUser`(
IN UserID int
)
BEGIN
SELECT U.UserID as uid,
	U.FirstName,
    U.LastName,
    U.Email,
    U.Mobile,
    U.DateOfBirth,
    U.City 
    FROM User U
	where uid = UserID;
    
END$$

DELIMITER ;
;