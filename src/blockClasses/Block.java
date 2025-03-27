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
      private int Nonce; // number of 0s

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

      //Mine block for data
      //Takes an int diff whih is the amount of 0s to solve for. 1 -> 4 easy
      //Normal ones take thousands of numbers
      public void mineBlock(int difficulty) {
            // We create a string with difficulty 0, the number takes what it is to figure out the number
            String target = new String(new char[difficulty]).replace('\0', '0');
            while(!Hash.substring(0, difficulty).equals(target)) {
                  Nonce++;
                  Hash = calculateHash();
                  // it will recalculate the hast until it matches the target
            }
            System.out.println("Block has been successfully mined! :D - HASH: " + Hash);
      }
}
