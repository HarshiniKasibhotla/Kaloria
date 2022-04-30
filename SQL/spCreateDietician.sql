DELIMITER $$
CREATE DEFINER=`CSCI5308_18_TEST_USER`@`%` PROCEDURE `spCreateDietician`(
IN Password varchar(45),
IN FirstName varchar(45),
IN LastName varchar(45),
IN Email varchar(45),
IN Mobile varchar(45),
IN DateOfBirth date,
IN City varchar(25),
IN ZipCode varchar(25),
IN Qualification varchar(45),
IN Areas_Of_Expertise varchar(45),
IN Address varchar(255),
IN Availability_Hours varchar(45),
IN RegistrationID varchar(45),
IN Age int,
IN Timestamp varchar(255),
IN Timeslot int,
IN Gender varchar(15),
IN Verified tinyint(4),
IN ApprovalIndicator tinyint(4)
)
BEGIN



INSERT INTO Dietitian(Password,FirstName,LastName,Email,Mobile,Qualification,Areas_Of_Expertise,Address,Availability_Hours,RegistrationID,Timestamp,Zipcode,DateOfBirth,City,Age,Timeslot,Gender,Verified,ApprovalIndicator)
values(Password,FirstName,LastName,Email,Mobile,Qualification,Areas_Of_Expertise,Address,Availability_Hours,RegistrationID,Timestamp,Zipcode,DateOfBirth,City,Age,Timeslot,Gender,Verified,ApprovalIndicator);



END$$
DELIMITER ;