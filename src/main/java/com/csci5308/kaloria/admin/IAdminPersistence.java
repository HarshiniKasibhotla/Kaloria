package com.csci5308.kaloria.admin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csci5308.kaloria.admin.dietItems.DietItems;
import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;
import com.csci5308.kaloria.admin.waitingDieticians.WaitingDieticians;

public interface IAdminPersistence {

	public ArrayList<DietItems> GetDietItems() throws SQLException;

	public void insertNewItem(IDietItems dietItem) throws SQLException;

	public void updateDietItem(Integer ItemId, String nutrientType, String itemName, int calories, String category,
			String health, String allergy, String meal) throws SQLException;

	public void deleteDietItem(Integer ItemId) throws SQLException;

	public void updateDieticianStatus(Integer dieticianId, Boolean approvalIndicator) throws SQLException;

	public ArrayList<VerifiedDietician> getVerifiedDieticians() throws SQLException;

	public ArrayList<WaitingDieticians> getWaitingDieticians() throws SQLException;

	List<DietItems> getDietItems(String healthAilment, String allergy) throws SQLException;

}
