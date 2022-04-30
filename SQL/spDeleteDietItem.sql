
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spDeleteDietItem`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spDeleteDietItem`(
IN productId int(11)
)
BEGIN
Delete from DietItems where ItemId=productId ;
END$$

DELIMITER ;
;
