package br.com.wamais.houseCare.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public static String md5(final String in) throws NoSuchAlgorithmException {

		final MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(in.getBytes(), 0, in.length());
		return new BigInteger(1, m.digest()).toString(16);
	}
}
