package Company.Thumbtack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Luke Zhang
 * @Date 2021-06-07 16:22
 *
 * https://www.1point3acres.com/bbs/thread-570239-1-1.html
 *
 * 2. 给一个person标号的数组[1,2,3,4,5,6,7,8],给许多rankers list，
 * base:[1,2,3,4,5,6,7,8]
 * newPros = [5,6]
 * price = [1,3,5,2,7,6,4]
 * 选person的顺序是[base,newPros,base,price]
 * 返回一个list表示person rank的结果。
 * 第一个从base里挑，1，
 * 第二个从newPros里  5
 * 第三个从base  2
 * 第四个从price里  3 （1已经在结果里了）
 * 然后重复在base里
 * 。。。
 * 所以上述返回（1，5，2，3，4，6，7，8）
 */
public class _RankersList_Node {
    public static void main(String[] args){
        helperList();
    }

    static class RankNode {
        String rankName = "";
        int index = 0;
        RankNode next;
        int[] curVal;

        public RankNode(String name, int[] curVal){
            this.rankName = name;
            this.curVal = curVal;
        }
    }

    private static void helperList(){
        HashSet<Integer> cache = new HashSet<>();
        RankNode rankNode1 = new RankNode("base", new int[]{1,2,3,4,5,6,7,8});
        RankNode rankNode2 = new RankNode("newPros", new int[]{5,6});
        RankNode rankNode3 = new RankNode("price", new int[]{1,3,5,2,7,6,4});
        List<RankNode> nodes = new ArrayList<>();
        nodes.add(rankNode1);
        nodes.add(rankNode2);
        nodes.add(rankNode1);
        nodes.add(rankNode3);

        List<Integer> ans = new ArrayList<>();
        int seq = 0;
        int totalLen = rankNode1.curVal.length + rankNode2.curVal.length + rankNode3.curVal.length;
        for (int i = 0; i < totalLen; ){

            seq = seq % nodes.size();
            String name = nodes.get(seq).rankName;
            int curIndex = nodes.get(seq).index;
            int[] curArr = nodes.get(seq).curVal;

            while (curIndex < curArr.length){
                nodes.get(seq).index++;
                if (cache.add(curArr[curIndex])){
                    ans.add(curArr[curIndex]);
                    i++;

                    System.out.println(name + "  index of  " + curIndex + " value " + curArr[curIndex]  + "  seq  is  "  + seq);
                    break;
                } else {
                    curIndex++;
                }
            }

            seq++;
            if (seq == nodes.size()) {
                seq = 0;
            }

        }

        System.out.println(ans);
    }

}
