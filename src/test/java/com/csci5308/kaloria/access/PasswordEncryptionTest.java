package com.csci5308.kaloria.access;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.csci5308.kaloria.access.calculators.IPasswordEncryption;
import com.csci5308.kaloria.access.calculators.PasswordEncryption;

public class PasswordEncryptionTest {

	IPasswordEncryption passwordEncryption = new PasswordEncryption();

	@Test
	public void encryptPasswordTest() {
		String expectedResult = "khoorzruog";
		String actualResult = passwordEncryption.encryptPassword("helloworld");
		assertEquals(expectedResult, actualResult);
	}

}
