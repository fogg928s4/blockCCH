import blockClasses.Block;

public class BlockCCH {
      //this will be our main
      public static void main(String[] args) {
            // the first chain block with 0 as previus Hash
            Block genesisBlock = new Block("Hello Pucca, I'm in the first block","0");
            //Just on terminal for now, GUI is coming
            System.out.println("Block 0 Hash is >>: "+ genesisBlock.Hash);

            Block[] blocks = new Block[10]; // 10 blocks
            blocks[0] = genesisBlock; // first block
            //create and print each block
            for(int i=1; i<10; i++) {
                  String msg = "This is block N #" + i;
                  blocks[i] = new Block(msg,blocks[i-1].Hash);
                  System.out.println("Block N #" + i + " Hash is >>: "+ blocks[i].Hash);
            }
      }

      
}
