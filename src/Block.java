import java.util.Date; //will be used for dates
import java.security.MessageDigest; // for our hashes

/*This class is meant to be for the block objects
Each block contains a hash value, which in turn is calculated using the
previous hash. so one changes, all goes berserk
 */
public class Block {
      public String hash;
      public String previousHash; // helps calculate the current hash
      public String data; // Data rn is just a msg
      private long timeStamp; // ms sin 1970 (UNIX Time)

      //Constructor
      public Block(String data, String previousHash) {
            this.data = data;
            this.previousHash = previousHash;
            this.timeStamp = new Date().getTime(); // Time to long
            this.hash = calculateHash(); //After getting all the values
      }

      //A helper for SHA 256
      public String calculateHash() {
            String  tempHash = StringUtil.applySHA256(previousHash + timeStamp + data);
            return tempHash;
      }

}
