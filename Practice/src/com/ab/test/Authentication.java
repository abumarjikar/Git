package com.ab.test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;

public class Authentication {

	public static String getSaltedHashedValue(String pwd) {
		final Random r = new SecureRandom();
		byte[] salt = new byte[32];
		r.nextBytes(salt);
		String saltBase64 = Base64.encodeBase64String(salt);
		String val = sha256(pwd, saltBase64) + " " + saltBase64;
		return val;
	}

	public static String sha256(String password, String saltKey) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return null;// should not happen
		}
		if (saltKey != null) {
			digest.reset();
			digest.update(Base64.decodeBase64(saltKey));
		}

		byte[] btPass = digest.digest(password.getBytes(StandardCharsets.UTF_8));
		digest.reset();
		btPass = digest.digest(btPass);
		return Base64.encodeBase64String(btPass);
	}
}
