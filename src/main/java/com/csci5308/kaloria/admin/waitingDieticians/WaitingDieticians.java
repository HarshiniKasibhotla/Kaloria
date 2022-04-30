package com.csci5308.kaloria.admin.waitingDieticians;

import java.sql.SQLException;

import com.csci5308.kaloria.admin.AdminPersistence;
import com.csci5308.kaloria.admin.IAdminPersistence;
import com.csci5308.kaloria.admin.verifiedDieticians.VerifiedDietician;

public class WaitingDieticians extends VerifiedDietician implements IWaitingDieticians {

	IAdminPersistence adminpersistence;
	private int dieticianId;

	public WaitingDieticians() {
		super();
		this.adminpersistence = new AdminPersistence();
	}

	@Override
	public void getWaitingDieticians() throws SQLException {
		adminpersistence.getWaitingDieticians();

	}

	@Override
	public void setDieticianId(int dieticianId) {
		this.dieticianId = dieticianId;

	}

	@Override
	public int getDieticianId() {
		return dieticianId;
	}

}
