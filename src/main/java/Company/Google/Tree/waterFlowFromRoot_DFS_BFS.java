package Company.Google.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhixinzhang
 * Date: 4/25/19
 * Time: 7:31 PM
 * Description:
 */


public class waterFlowFromRoot_DFS_BFS {
    static class WaterTreeNode{
        int stickiness;
        List<WaterTreeNode> childrens;
        public WaterTreeNode(int val){
            this.stickiness = val;
            childrens = new ArrayList<>();
        }
    }
    static int ans = 0;
    public static void main(String[] args){
        WaterTreeNode root = new WaterTreeNode(3);
        WaterTreeNode root1 = new WaterTreeNode(1);
        WaterTreeNode root2 = new WaterTreeNode(1);
        WaterTreeNode root11 = new WaterTreeNode(1);
        WaterTreeNode root12 = new WaterTreeNode(9);

        root1.childrens.add(root11);
        root1.childrens.add(root12);

        root.childrens.add(root1);
        root.childrens.add(root2);

        LongestTime(root,0);
        System.out.println(ans);

    }
    public static void LongestTime(WaterTreeNode root, int sumVal){
        int curVal = root.stickiness;
        if(root.childrens.size() == 0)
            ans = Math.max(ans, sumVal + curVal);
        for (WaterTreeNode node : root.childrens){
            LongestTime(node, sumVal + curVal);
        }
    }
}
