DELIMITER $$
CREATE DEFINER=`CSCI5308_18_TEST_USER`@`%` PROCEDURE `spCreateUser`(
IN Password varchar(15),
IN FirstName varchar(15),
IN LastName varchar(15),
IN Email varchar(30),
IN Mobile varchar(15),
IN DateOfBirth date,
IN City varchar(25),
IN ZipCode varchar(25),
IN Timestamp varchar(255),
IN Gender varchar(15),
IN Age int
)
BEGIN
INSERT INTO Users(Password,FirstName,LastName,Email,Mobile,DateOfBirth,City,ZipCode,Timestamp,Age,Gender)
values(Password,FirstName,LastName,Email,Mobile,DateOfBirth,City,ZipCode,Timestamp,Age,Gender);



END$$
DELIMITER ;