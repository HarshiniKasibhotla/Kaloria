package com.csci5308.kaloria.access;

public class IdentifyCurrentUserFactory {

	public static IValidateCurrentUser getInstance(String userId) {

		if (userId.startsWith("DIET")) {
			return new ValidateDietician();
		} else {
			return new ValidateNormalUser();
		}
	}
}
