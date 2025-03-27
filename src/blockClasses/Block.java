package blockClasses;

import java.util.Date; //will be used for dates


/*This class is meant to be for the block objects
Each block contains a hash value, which in turn is calculated using the
previous hash. so one changes, all goes berserk
 */
public class Block {
      // Properties are the ones that start with caps
      public String Hash;
      public String PreviousHash; // helps calculate the current hash
      public String Data; // Data rn is just a msg
      private long TimeStamp; // ms sin 1970 (UNIX Time)

      //Constructor
      public Block(String data, String previousHash) {
            this.Data = data;
            this.PreviousHash = previousHash;
            this.TimeStamp = new Date().getTime(); // Time to long
            this.Hash = calculateHash(); //After getting all the values
      }

      //A helper for SHA 256
      public String calculateHash() {
            //String  tempHash = ;
            return StringUtil.applySHA256(PreviousHash + TimeStamp + Data);
      }

}
