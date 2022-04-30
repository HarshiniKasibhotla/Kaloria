package com.csci5308.kaloria.admin.waitingDieticians;

import java.sql.SQLException;

public interface IWaitingDieticians {

	public void setDieticianId(int dietcianId);

	public int getDieticianId();

	public void getWaitingDieticians() throws SQLException;

}
