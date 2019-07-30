package com.xerovit.io.assignment.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptoUtil {

	public static class Bcrypt {

		private static BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		public static String encrypt(String plainText) {
			return bcrypt.encode(plainText);
		}

		public static boolean match(String plainText, String encodedText) {
			return bcrypt.matches(plainText, encodedText);
		}
	}

	public static class SHA256 {

		private static MessageDigest digest;

		public static byte[] getBytes(String plainText) throws NoSuchAlgorithmException {
			digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(plainText.getBytes(StandardCharsets.UTF_8));
		}

		public static String encode(String plainText) throws NoSuchAlgorithmException {
			return toHexString(getBytes(plainText));
		}

		public static String toHexString(byte[] hashBytes) {
			StringBuilder sb = new StringBuilder();
			for (byte hashByte : hashBytes) {
				String tmp = Integer.toHexString(0xff & hashByte);
				if (tmp.length() == 1)
					sb.append('0');
				sb.append(tmp);
			}
			return sb.toString();
		}
	}

	public static String encryptPassword(String password) throws NoSuchAlgorithmException {
		return Bcrypt.encrypt(SHA256.encode(password));
	}

}
