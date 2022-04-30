DELIMITER $$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spUpdateDietChart`(
IN chartID INT,
IN newChart BLOB
)
BEGIN
UPDATE DietChart SET chart = newChart, updated_at = current_timestamp() WHERE id = chartID;
END$$
DELIMITER ;
