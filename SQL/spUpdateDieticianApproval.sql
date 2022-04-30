
USE `CSCI5308_18_DEVINT`;
DROP procedure IF EXISTS `CSCI5308_18_DEVINT`.`spUpdateDieticianApproval`;
;

DELIMITER $$
USE `CSCI5308_18_DEVINT`$$
CREATE DEFINER=`CSCI5308_18_DEVINT_USER`@`%` PROCEDURE `spUpdateDieticianApproval`(
IN dieticianId int ,
IN approvalIndicator tinyint(1)
)
BEGIN
Update Dietitian set ApprovalIndicator=approvalIndicator , Verified=1 where DietitianId=dieticianId;
END$$

DELIMITER ;
;
