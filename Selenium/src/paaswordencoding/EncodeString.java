package paaswordencoding;

import org.apache.commons.codec.binary.Base64;

public class EncodeString {

	public static void main(String[] args) {
		
		String str = "Parag123";
		
		byte[] encodedstring = Base64.encodeBase64(str.getBytes());
		System.out.println(encodedstring);
		String encodedstr = new String(encodedstring);
		System.out.println("Encoded string is" + encodedstr);
		
		byte[] decodedstrbyte = Base64.decodeBase64(encodedstring);
		String decodedString = new String(decodedstrbyte);
		
		System.out.println("Decoded string is " + decodedString );

	}

}
