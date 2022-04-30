package com.csci5308.kaloria.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csci5308.kaloria.admin.dietItems.DietItems;
import com.csci5308.kaloria.admin.dietItems.IDietItems;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;
import com.csci5308.kaloria.admin.waitingDieticians.WaitingDieticians;
import com.csci5308.kaloria.database.CallStoredProcedures;

public class AdminPersistence implements IAdminPersistence {

	@Override
	public ArrayList<DietItems> GetDietItems() throws SQLException {
		ArrayList<DietItems> dietItems = new ArrayList<DietItems>();

		CallStoredProcedures getDietItems = null;
		try {
			getDietItems = new CallStoredProcedures("spGetDietItems");
			ResultSet data = getDietItems.executeWithResults();

			while (data.next()) {
				DietItems dt = new DietItems();

				int ItemId = data.getInt("ItemId");
				String Type = data.getString("Type");
				String itemName = data.getString("ItemName");
				int calories = data.getInt("Calories");
				String category = data.getString("Category");
				String health = data.getString("HealthCondition");
				String allergy = data.getString("Allergies");
				String meal = data.getString("MealType");

				dt.setItemId(ItemId);
				dt.setItemName(itemName);
				dt.setNutrientType(Type);
				dt.setCalories(calories);
				dt.setCategory(category);
				dt.setHealth(health);
				dt.setAllergy(allergy);
				dt.setMeal(meal);
				dietItems.add(dt);
			}
		} catch (SQLException e) {

		} finally {
			if (null != getDietItems) {
				getDietItems.cleanup();
			}
		}
		return dietItems;
	}

	@Override
	public void insertNewItem(IDietItems dietItem) throws SQLException {
		CallStoredProcedures procedure = null;

		try {

			procedure = new CallStoredProcedures("spAddDietItems(?, ?, ?, ?, ?, ?, ?)");
			procedure.setParameter(1, dietItem.getNutrientType());
			procedure.setParameter(2, dietItem.getItemName());
			procedure.setParameter(3, dietItem.getCalories());
			procedure.setParameter(4, dietItem.getCategory());
			procedure.setParameter(5, dietItem.getHealth());
			procedure.setParameter(6, dietItem.getAllergy());
			procedure.setParameter(7, dietItem.getMeal());

			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}

	}

	@Override
	public void deleteDietItem(Integer ItemId) throws SQLException {
		CallStoredProcedures procedure = null;

		try {

			procedure = new CallStoredProcedures("spDeleteDietItem(?)");
			procedure.setParameter(1, ItemId);
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}

	}

	@Override
	public void updateDietItem(Integer ItemId, String nutrientType, String itemName, int calories, String category,
			String health, String allergy, String meal) throws SQLException {
		CallStoredProcedures procedure = null;

		try {
			procedure = new CallStoredProcedures("spUpdateDietItems(?, ?, ?, ?, ?, ?, ?, ?)");
			procedure.setParameter(1, ItemId);
			procedure.setParameter(2, nutrientType);
			procedure.setParameter(3, itemName);
			procedure.setParameter(4, calories);
			procedure.setParameter(5, category);
			procedure.setParameter(6, health);
			procedure.setParameter(7, allergy);
			procedure.setParameter(8, meal);
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}

	}

	@Override
	public void updateDieticianStatus(Integer dieticianId, Boolean approvalIndicator) throws SQLException {
		CallStoredProcedures procedure = null;

		try {

			procedure = new CallStoredProcedures("spUpdateDieticianApproval(?, ?)");
			procedure.setParameter(1, dieticianId);
			procedure.setParameter(2, approvalIndicator);
			procedure.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (procedure != null) {
				procedure.cleanup();
			}
		}

	}

	@Override
	public ArrayList<VerifiedDietician> getVerifiedDieticians() throws SQLException {
		ArrayList<VerifiedDietician> verifiedDieticians = new ArrayList<VerifiedDietician>();

		CallStoredProcedures getverifiedDietician = null;
		try {

			getverifiedDietician = new CallStoredProcedures("spGetVerifiedDietician");
			ResultSet data = getverifiedDietician.executeWithResults();

			while (data.next()) {
				VerifiedDietician verifiedDietician = new VerifiedDietician();

				String dieticianName = data.getString("FirstName");
				String dAddress = data.getString("Address");
				String expertise = data.getString("Areas_Of_Expertise");
				String license = data.getString("RegistrationID");
				String zipCode = data.getString("ZipCode");
				int rating = data.getInt("Rating");
				int dieticianId = data.getInt("DietitianId");

				verifiedDietician.setDieticianId(dieticianId);
				verifiedDietician.setDieticianName(dieticianName);
				verifiedDietician.setDieticianAddress(dAddress);
				verifiedDietician.setExpertise(expertise);
				verifiedDietician.setLicense(license);
				verifiedDietician.setDieticianZipCode(zipCode);
				verifiedDietician.setDieticianRating(rating);
				verifiedDieticians.add(verifiedDietician);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != getverifiedDietician) {
				getverifiedDietician.cleanup();
			}
		}

		return verifiedDieticians;
	}

	@Override
	public ArrayList<WaitingDieticians> getWaitingDieticians() throws SQLException {
		ArrayList<WaitingDieticians> waitingDieticians = new ArrayList<WaitingDieticians>();

		CallStoredProcedures getwaitingDieticians = null;

		getwaitingDieticians = new CallStoredProcedures("spGetWaitingDietitian");
		ResultSet data = getwaitingDieticians.executeWithResults();

		try {
			while (data.next()) {
				WaitingDieticians wd = new WaitingDieticians();

				String dieticianName = data.getString("FirstName");
				String dAddress = data.getString("Address");
				String expertise = data.getString("Areas_Of_Expertise");
				String license = data.getString("RegistrationID");
				int dieticianId = data.getInt("DietitianId");

				wd.setDieticianId(dieticianId);
				wd.setDieticianName(dieticianName);
				wd.setDieticianAddress(dAddress);
				wd.setExpertise(expertise);
				wd.setLicense(license);
				waitingDieticians.add(wd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != getwaitingDieticians) {
				getwaitingDieticians.cleanup();
			}
		}

		return waitingDieticians;
	}

	@Override
	public List<DietItems> getDietItems(String healthAilment, String allergy) throws SQLException {
		ArrayList<DietItems> dietItems = new ArrayList<DietItems>();

		CallStoredProcedures getDietItems = null;
		try {
			getDietItems = new CallStoredProcedures("spGetItemsByCondition(?,?)");
			getDietItems.setParameter(1, healthAilment);
			getDietItems.setParameter(2, allergy);
			ResultSet data = getDietItems.executeWithResults();

			while (data.next()) {
				DietItems dt = new DietItems();

				int ItemId = data.getInt("ItemId");
				String Type = data.getString("Type");
				String itemName = data.getString("ItemName");
				int calories = data.getInt("Calories");
				String category = data.getString("Category");
				String health = data.getString("HealthCondition");
				String allergyType = data.getString("Allergies");
				String meal = data.getString("MealType");

				dt.setItemId(ItemId);
				dt.setItemName(itemName);
				dt.setNutrientType(Type);
				dt.setCalories(calories);
				dt.setCategory(category);
				dt.setHealth(health);
				dt.setAllergy(allergyType);
				dt.setMeal(meal);
				dietItems.add(dt);
			}
		} catch (SQLException e) {

		} finally {
			if (null != getDietItems) {
				getDietItems.cleanup();
			}
		}
		return dietItems;
	}

}
