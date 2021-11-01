package no.hvl.dat108.f15a;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class HashePassord {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

		String[] noenPassord = { "hei", "hallaien", "passord1", "paadoo" };

		for (String passord : noenPassord) {
			byte[] passordSomBytes = passord.getBytes("UTF-8");

			System.out.println();
			System.out.println(passord);
			System.out.println(Arrays.toString(passordSomBytes));

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] digest = md.digest(passordSomBytes);

			System.out.println(Arrays.toString(digest));
			
			String base64Digest = Base64.getEncoder().encodeToString(digest);
			String hexDigest = DatatypeConverter.printHexBinary(digest);
			
			System.out.println(base64Digest);
		}

	}

}
