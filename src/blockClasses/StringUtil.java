package blockClasses;

import java.security.MessageDigest;

/* This class is meant to help in the hashing process
It is an extension of a similarly named class
 */
public class StringUtil {
      //For SHA256
      public  static String applySHA256(String input) {
            try{
                  MessageDigest dig = MessageDigest.getInstance("SHA-256");
                  byte[] hash = dig.digest(input.getBytes()); //applies on a byte array
                  StringBuffer hexString = new StringBuffer(); //hash as buffer on what will be returned

                  for (int i = 0; i < hash.length; i++) {
                        // a string to hexadecimal value
                        // uses a & bitwise operator, copies a bit to result if exists in both
                        // takes an int as argument and returns it in hex form
                        String hex = Integer.toHexString(0xff & hash[i]);

                        if(hex.length() == 1) hexString.append('0');
                        hexString.append(hex);
                  }
                  return hexString.toString();
            }
            catch (Exception e) {
                  throw new RuntimeException(e);
            }

      }
}
