package Company.Square.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://www.1point3acres.com/bbs/thread-953016-1-1.html
public class BlockRule {

    static class Block {
        String name;
        String color;
        int size;
        public Block(String name, String color, int size){
            this.color = color;
            this.name = name;
            this.size = size;
        }
    }

    static class Rule {
        int size;
        String color;
        int total;
        public  Rule(int size, int total, String color) {
            this.total = total;
            this.size = size;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        Block b1 = new Block("1", "Red", 12); 
        Block b2 = new Block("2", "Red", 7);  
        Block b3 = new Block("3", "Red", 8);  
        Block b4 = new Block("4","Yellow", 6);  
        Block b5 = new Block("5","White", 6);  
        Block b6 = new Block("6","Orange", 6);  
        Block b7 = new Block("7","Red", 11);     

        List<Block> blocks = Arrays.asList(b1, b2, b3, b4, b5, b6, b7);
        Collections.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block b1, Block b2){
                return b2.size - b1.size;
            }
        });

        matchBlock(blocks, new Rule(6, 3, "Red"));
    }

    private static List<Block> matchBlock(List<Block> blocks, Rule rule){
        List<Block> ans = new ArrayList<>();
        for (int i = 0; i < blocks.size(); i++){
            Block curBlock = blocks.get(i);
            if (curBlock.size < rule.size || ans.size() == rule.total)
                break;
            if (curBlock.color.equals(rule.color)) {
                ans.add(curBlock);
            }
        }
        return ans;
    }
    
}
