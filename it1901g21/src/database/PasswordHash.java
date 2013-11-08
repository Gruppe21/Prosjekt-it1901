package database;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {
	
	public final int SALT_BYTE_SIZE = 8;
	
	/* PUBLIC METHODS */
	
	/**
	 * Creates a hash for given password. Also returns the used salt.
	 * @param password the password to hash
	 * @return the hashed password and the salt
	 */
	public String[] createHash(String password) {
		
		SecureRandom randomSalt = new SecureRandom();
		byte[] salt = new byte[SALT_BYTE_SIZE];
		randomSalt.nextBytes(salt);
		
		return generateHash(password, salt); 
	}
	
	/**
	 * Checks if given password is correct.
	 * @param password the given password.
	 * @param usedSalt the salt used for the correct password hash.
	 * @param correctHash the correct password hash to compare.
	 * @return true if correct
	 */
	public boolean isValidated(String password, String usedSalt, String correctHash) {
		
		// Generates the password hash with the chosen salt
		byte[] salt = convertFromHex(usedSalt);
		String[] hashAndSalt = generateHash(password, salt);
		
		// Checks if the password hashes are the same
		return hashAndSalt[0].equals(correctHash); 
	}
	
	/**
	 * isValidated (DEBUG VERSION), return the hash and salt instead of a boolean
	 * Only used for debugging!
	 */
	public String[] isValidatedDebug(String password, String usedSalt, String correctHash) {
		
		byte[] salt = convertFromHex(usedSalt);
		String[] hashAndSalt = generateHash(password, salt);
		
		if (hashAndSalt[0].equals(correctHash))
			System.out.println("They are equal!");
		else
			System.out.println("Nooo, they aren't equal...");
		
		return hashAndSalt;
	}
	
	/* INTERNAL PRIVATE METHODS */
	
	/**
	 * Creates a password hash from given password and salt.
	 * @param password the password to hash
	 * @param salt the salt to use
	 * @return the hash and salt
	 */
	private String[] generateHash(String password, byte[] salt) {
		
		try {
			PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1000, SALT_BYTE_SIZE * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); 
			byte[] hash = skf.generateSecret(spec).getEncoded();
			
			return new String[] { convertToHex(hash), convertToHex(salt) };
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Converts a byte[] array into hexadecimal string.
	 * @param the array to convert
	 * @return the hexadecimal string
	 */
	private String convertToHex(byte[] array) {
		
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		
		int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
            return String.format("%0" + paddingLength + "d", 0) + hex;
        else
            return hex;
	}
	
	/**
	 * Converts from string to byte[] array
	 * @param the string to convert
	 * @return the byte[] array
	 */
	private byte[] convertFromHex(String hex) {
		
		byte[] binary = new byte[hex.length() / 2];
        for(int i = 0; i < binary.length; i++)
        {
            binary[i] = (byte)Integer.parseInt(hex.substring(2*i, 2*i+2), 16);
        }
        return binary;
	}
}
