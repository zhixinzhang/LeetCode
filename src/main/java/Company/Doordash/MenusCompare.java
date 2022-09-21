package Company.Doordash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luke Zhang
 * @Date 2021-08-11 15:21
 *
 * https://www.1point3acres.com/bbs/thread-779975-1-1.html
 *
 * Simliar ques : https://leetcode.com/discuss/interview-question/1367130/doordash-phone-interview
 */
public class MenusCompare {
    static class TreeNode{
         String key;
         String value;
         List<TreeNode> children;

        public TreeNode(String key, String value){
            this.key = key;
            this.value = value;
            this.children = new ArrayList<>();
        }

        public List<TreeNode> getChildren(){
            return children;
        }
    }

    public static void main(String[] args){
        TreeNode rootA = new TreeNode("A", "4");
        rootA.getChildren().add(new TreeNode("B", "1"));
        rootA.getChildren().add(new TreeNode("C", "5"));
        rootA.getChildren().get(0).children.add(new TreeNode("D", "3"));
        rootA.getChildren().get(0).children.add(new TreeNode("E", "5"));
        rootA.getChildren().get(0).children.add(new TreeNode("F", "8"));
        rootA.getChildren().get(1).children.add(new TreeNode("G", "12"));


        TreeNode rootB = new TreeNode("A", "4");
        rootB.getChildren().add(new TreeNode("B", "1"));
        rootB.getChildren().add(new TreeNode("M", "5"));
        rootB.getChildren().get(0).children.add(new TreeNode("E", "5"));
        rootB.getChildren().get(0).children.add(new TreeNode("D", "3"));
        rootB.getChildren().get(0).children.add(new TreeNode("W", "8"));

        rootB.getChildren().get(1).children.add(new TreeNode("G", "12"));


        int ans = compareTwoTree(rootA, rootB);
        System.out.println("ans is  " + ans);
    }


    private static int compareTwoTree(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return 0;
        }

        if ((rootA != null && rootB == null) ||
            (rootA == null && rootB != null) ||
            !rootA.key.equals(rootB.key)) {
            return countNodes(rootA) + countNodes(rootB);
        }

        int diffCount = 0;
        if (!rootA.value.equals(rootB.value)){
            diffCount = 2;
        }
        Map<String, TreeNode> mapA = new HashMap<>();
        Map<String, TreeNode> mapB = new HashMap<>();
        for (TreeNode nodeA : rootA.getChildren()) {
            mapA.put(nodeA.key, nodeA);
        }

        for (TreeNode nodeB : rootB.getChildren()) {
            mapB.put(nodeB.key, nodeB);
        }

        for (Map.Entry<String, TreeNode> entry : mapA.entrySet()){
            String keyA = entry.getKey();
            TreeNode nodeA = entry.getValue();

            if (!mapB.containsKey(keyA)){
                diffCount += countNodes(nodeA);
            } else {
                TreeNode nodeB = mapB.get(keyA);
                diffCount += compareTwoTree(nodeA, nodeB);

                mapB.remove(keyA);
            }
        }

        for (Map.Entry<String, TreeNode> entry : mapB.entrySet()){
            String keyB = entry.getKey();
            TreeNode nodeB = entry.getValue();
            diffCount += countNodes(nodeB);
        }

        return diffCount;
    }

    private static int countNodes(TreeNode root){
        if (root == null) {
            return 0;
        }
        int count = 1;
        for (TreeNode node : root.getChildren()){
            count += countNodes(node);
        }

        return count;
    }
}
