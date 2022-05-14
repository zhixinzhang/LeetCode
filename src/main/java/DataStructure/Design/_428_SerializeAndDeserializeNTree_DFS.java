package DataStructure.Design;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 5/4/2021 12:48 AM
 * <p>
 * Source Link:
 * <p>  https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/discuss/190318/Serialize-and-Deserialize-Binary-and-N-ary-Tree-Summary
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

public class _428_SerializeAndDeserializeNTree_DFS {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Encodes a tree to a single string.
    String NN = "x";
    String spliter = ",";
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb){
        if (node == null) {
            sb.append(NN);
            sb.append(spliter);
        } else {
            sb.append(node.val);
            sb.append(spliter);
            sb.append(node.children.size());
            sb.append(spliter);
            for (Node child:node.children){
                buildString(child,sb);
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(data.split(spliter)));
        return buildTree(deque);
    }

    private Node buildTree(Deque<String> deque){
        String s1 = deque.removeFirst();
        if (s1.equals(NN))
            return null;

        int rootVal = Integer.valueOf(s1);
        int childrenNumber = Integer.valueOf(deque.poll());

        Node root = new Node(rootVal);
        root.children = new ArrayList<>();
        for (int i = 0; i < childrenNumber; i++){
            root.children.add(buildTree(deque));
        }

        return root;
    }
}
