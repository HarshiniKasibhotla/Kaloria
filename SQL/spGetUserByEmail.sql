DELIMITER $$
CREATE DEFINER=`CSCI5308_18_TEST_USER`@`%` PROCEDURE `spGetUserByEmail`(
IN email varchar(45)
)
BEGIN
Select Password from Users where Email=email;
END$$
DELIMITER ;