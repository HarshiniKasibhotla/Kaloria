DELIMITER $$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spCreateDietChart`(
IN userID INT,
IN chart BLOB
)
BEGIN
INSERT INTO DietChart(userId, chart) VALUES(userID, chart);
END$$
DELIMITER ;
