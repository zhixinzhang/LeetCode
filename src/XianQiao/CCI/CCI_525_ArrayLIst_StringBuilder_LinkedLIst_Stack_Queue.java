package XianQiao.CCI;

import DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Xianqiao
 * @Date: 5/26/20 16:36
 */
public class CCI_525_ArrayLIst_StringBuilder_LinkedLIst_Stack_Queue {
//    /** ArrayList */
//    ArrayList<String> merge(String[] words, String[] more) {
//        ArrayList<String> sentence = new ArrayList<String>();
//        for (String w : words) sentence.add(w);
//        for (String w : more) sentence.add(w);
//        return sentence;
//    }
//
//    /** Compare String and StringBuilder--StringBuilder is used to save space*/
//    String joinWords(String[] words) {
//        String sentence = "";
//        for (String w : words) {
//            sentence = sentence + w;
//            /** first iterate x item, then iterate x + x = 2x item, and then 3x....
//             * needs O(xn^2) space */
//        }
//        return sentence;
//    }
//
//    String joinWords2(String[] words) {
//        StringBuilder sentence = new StringBuilder();
//        for (String w : words) {
//            sentence.append(w);
//        }
//        return sentence.toString();
//    }
//
//    /** Linked List */
//    //Creating a Linked List
//    class Node{
//        Node next = null;
//        int data;
//        public Node(int d){
//            data = d;
//        }
//        void appendToTail(int d){
//            Node end = new Node(d);
//            Node n = this;
//            while ( n.next != null) {
//                n = n.next;
//            }
//            n.next = end;
//        }
//    }
//
//    //Deleting a Node from a Singly Linked List
//    Node deleteNode(Node head, int d){
//        Node n = head;
//        if (n.data == d) {
//            return head.next; /*move head*/
//        }
//        while (n.next != null) {
//            if (n.next.data == d) {
//                n.next = n.next.next;
//                return head; /* head didn't change*/
//            }
//            n = n.next;
//        }
//        return head;
//    }
//
//    /** Stack and Queue */
//    public static void main(String[] args){
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        System.out.println(stack.peek());
//        stack.pop();
//        stack.isEmpty();
//
//        Queue<Integer> q = new Queue<>();
//        q.add(1);
//        q.add(2);
//        System.out.println(q.peek());
//        q.remove();
//        q.isEmpty();
//    }
//
//
//    /** 5.26 Tree and Graphs */
//    public class CCI_526_TreeandGraphs {
//        /** Binary Tree Traversal */
//        /* in order */
//        void inOrderTraversal(TreeNode node) {
//            if (node != null) {
//                inOrderTraversal(node.left);
//                visit(node);
//                inOrderTraversal(node.right);
//                }
//            }
//        }
//
//        /* pre order */
//        void preOrderTraversal(TreeNode node) {
//            if (node != null) {
//                visit(node);
//                preOrderTraversal(node.left);
//                preOrderTraversal(node.right);
//            }
//        }
//
//        /* post order */
//        void postOrderTraversal(TreeNode node) {
//            if (node != null) {
//                postOrderTraversal(node.left);
//                postOrderTraversal(node.right);
//                visit(node);
//            }
//        }
}
