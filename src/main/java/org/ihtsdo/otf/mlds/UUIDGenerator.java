package org.ihtsdo.otf.mlds;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class UUIDGenerator {

	public static final String encoding = "UTF-8";

	public static UUID get(final String name) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		MessageDigest sha1Algorithm = MessageDigest.getInstance("SHA-1");

		sha1Algorithm.reset();

		sha1Algorithm.update(name.getBytes(encoding));
		byte[] sha1digest = sha1Algorithm.digest();

		sha1digest[6] &= 0x0f; /* clear version */
		sha1digest[6] |= 0x50; /* set to version 5 */
		sha1digest[8] &= 0x3f; /* clear variant */
		sha1digest[8] |= 0x80; /* set to IETF variant */

		long msb = 0;
		long lsb = 0;
		for (int i = 0; i < 8; i++)
			msb = (msb << 8) | (sha1digest[i] & 0xff);
		for (int i = 8; i < 16; i++)
			lsb = (lsb << 8) | (sha1digest[i] & 0xff);

		return new UUID(msb, lsb);
	}

}
