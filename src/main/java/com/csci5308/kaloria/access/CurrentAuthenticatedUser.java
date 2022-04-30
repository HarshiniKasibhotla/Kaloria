package com.csci5308.kaloria.access;

import java.sql.SQLException;

import com.csci5308.kaloria.access.user.IUser;
import com.csci5308.kaloria.access.user.IUserPersistance;
import com.csci5308.kaloria.access.user.UserPersistance;

public class CurrentAuthenticatedUser {

	private static IUser user;

	public static IUser getAuthenticatedUser() {
		return user;
	}

	public static void setAuthenticatedUser(String userName) {
		IUserPersistance userPersistence = new UserPersistance();
		try {
			user = userPersistence.getUserDetails(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean isUserLoggedIn() {
		IUser currentUser = CurrentAuthenticatedUser.getAuthenticatedUser();
		if (currentUser == null) {
			return false;
		}
		return true;
	}

}
