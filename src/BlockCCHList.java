import blockClasses.Block;
import blockClasses.StringUtil;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/* This class will server similar to BlockCCHArray, but this time
instead of saving to an array, itll be to an ArrayList structure
Subsequently, sento to a GsonBuilder for JSON Formating
 */
public class BlockCCHList {
      public static ArrayList<Block> blockchain = new ArrayList<Block>();

      public static void main(String[] args){
            blockchain.add(new Block("Hello Pucca, I'm in the first block","0"));
            blockchain.add(new Block("Hello Ranger, I'm in the second block",
                    blockchain.get(blockchain.size()-1).Hash));
            // get(index of elements) so it takes the size -1,
            // so the last one at the time cus counting from 0
            blockchain.add(new Block("Hello Morris, I'm in the third block",
                    blockchain.get(blockchain.size()-1).Hash));

            //now to GSON
            String blockJSON = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
            System.out.println(blockJSON);
      }

}
