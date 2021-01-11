package DataStructure.Tree;

import java.util.*;

/**
 * @author Luke(New Man) Zhang
 * @Date 2021-01-09 16:23
 * <p>
 * Description: https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/
 * Key Point: Another way is to do inOrder traversal and add all nodes to a arrayList. Then do linkage later.
 * Best way is in place
 */

public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList_DFS {
    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        // Solution 1 : O(1)
        // the smallest (first) and the largest (last) nodes
        Node first = null;
        Node last = null;
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;

            helper(root);
            // close DLL
            last.right = first;
            first.left = last;
            return first;
        }

        private void helper(Node node) {
            if (node == null) return;

            // travel left
            helper(node.left);

            if (last != null) {
                // link the previous node(last) to current one (node)
                last.right = node;
                node.left = last;
            } else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;

            // travel right
            helper(node.right);
        }




        // Solution 2 O(n), O(n)
        public List<Node> list = new ArrayList<>();
        public Node treeToDoublyList_WithExtraArrayList(Node root) {
            dfsInOrder(root);

            // build double linked list
            if (list.size() == 1) {
                root.left = root;
                root.right = right;
                return root;
            }

            for (int i = 0, j = list.size() - 1; i < list.size() - 1 && j >= 1;  i++, j--){
                Node curNodeL = list.get(i);
                Node nextNode = list.get(i+1);
                curNodeL.right = nextNode;

                Node curNodeR = list.get(j);
                Node nextNodeL = list.get(j-1);
                curNodeR.left = nextNodeL;
            }

            // connect leftmost and right most node
            list.get(0).left = list.get(list.size() - 1);
            list.get(list.size() - 1).right = list.get(0);

            return list.get(0);
        }

        private void dfsInOrder(Node root){
            if (root == null) {
                return;
            }

            dfsInOrder(root.left);
            list.add(root);
            dfsInOrder(root.right);
        }
    }
}
