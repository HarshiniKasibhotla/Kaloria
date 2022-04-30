package com.csci5308.kaloria.access.calculators;

public class PasswordEncryption implements IPasswordEncryption {

	@Override
	public String encryptPassword(String rawPassword) {

		String encodedPassword = "";
		char[] ch = rawPassword.toCharArray();
		for (char c : ch) {
			encodedPassword += (char) (c + 3);
		}
		return encodedPassword;
	}

}
