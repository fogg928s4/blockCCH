import blockClasses.Block;
import blockClasses.StringUtil;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/* This class will server similar to BlockCCHArray, but this time
instead of saving to an array, itll be to an ArrayList structure
Subsequently, sento to a GsonBuilder for JSON Formating
 */
public class BlockCCHList {
      //The list that all methods will use at class level declaration
      public static ArrayList<Block> blockchain = new ArrayList<Block>();
      //difficulty level, tamper to test (my pc is suffering rn)
      public static int difficulty = 1;

      public static void main(String[] args){
            // get(index of elements) so it takes the size -1,
            // so the last one at the time cus counting from 0
            blockchain.add(new Block("Hello Pucca, I'm in the first block","0"));
            blockchain.add(new Block("Hello Ranger, I'm in the second block",
                    blockchain.get(blockchain.size()-1).Hash));
            blockchain.add(new Block("Hello Morris, I'm in the third block",
                    blockchain.get(blockchain.size()-1).Hash));

            //now to GSON
            String blockJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
            System.out.println(blockJSON);

            //Mining
            for(int i = 0; i<blockchain.size(); i++){
                  System.out.println("Trying to mine block #" + i + " ->>");
                  blockchain.get(i).mineBlock(difficulty);
            }
            System.out.println("Blockchain is Valid?: " + isChainValid());
      }
      // Method to check integrity of chain
      public static Boolean isChainValid(){
            Block currentBlock, previousBlock;
            String hasTarget = new String(new char[difficulty]).replace('\0', '0');

            //loop through chain to check all hashes
            for(int i = 0; i < blockchain.size(); i++){
                  currentBlock = blockchain.get(i);
                  previousBlock = blockchain.get(i-1);
                  //compare hashes. since Hash is type String it inherits all String methods
                  if(!currentBlock.Hash.equals(currentBlock.calculateHash())){
                        System.out.println("Hash does not match");
                        return false;
                  }
                  if(!previousBlock.Hash.equals(previousBlock.calculateHash())){
                        System.out.println("Hash does not match");
                        return false;
                  }

                  //Now check if hash is solved or has been mined
                  if(!currentBlock.Hash.substring(0, difficulty).equals(hasTarget)){
                        System.out.println("This particular block has not been mined");
                        return false;
                  }
            }
            return true; //if didnt exit is bc hashes match and all is good :D
      }
}
