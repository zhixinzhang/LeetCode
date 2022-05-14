package Company.Doordash;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 8/20/2021 2:56 PM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 * <p>
 * Data structure
 */

/**
 # Problem Statement

 At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree. When the merchant sends us the latest menu, can we calculate how many nodes has changed?

 Assume each Node structure is as below:

 # Java
 class Node {
 String key;
 int value;
 List<Node> children;
 }

 # Python
 class Node:
 def __init__(self, key, value):
 self.key = key
 self.value = value
 self.children = []

 We only do SOFT delete if an existing node in the new tree is null by marking the node inactive in our database.
 Assume there are no duplicate active nodes with the same key.

 ## Example 1

 Existing Menu in our system:

 Existing tree
 a(1)
 /     \
 b(2)     c(3)
 /   \       \
 d(4)  e(5)    f(6)

 ( Legend - a(1) a is the key, 1 is the value)

 // -> b(2) deleted
 // d(4) deleted
 // f(6) updated to f(66)

 New Menu sent by the Merchant:

 New tree
 a(1)
 \
 c(3)
 \
 f(66)

 Expected Answer: 4
 Explanation: Node b, Node d, Node e are automatically set to inactive. The value of Node f changed as well.

 ## Example 2

 Existing Menu in our system:

 Existing tree
 a(1)
 /    \
 b(2)   c(3)
 /    \    \
 d(4)   e(5)   g(7)

 New Menu sent by the Merchant:

 New tree
 a(1)
 /       \
 b(2)       c(8)
 /  |   \        \
 e(5) d(4) f(6)     g(7)

 Expected Answer: 2
 Explanation: There are a total of 5 changed nodes. Node f is a newly-added node. c(3) and old g(7) are deactivated; h(8) and new g(7) are newly added nodes
 **/

// order does't matter
// if Node key changed -> all subTree changed  Node value dont impact to subTree
//  unique Node

// DFS -> travel two menues compare all nodes based on diff judege
// time -> O(V + E) -> O(N)  n is the largest number of nodes in two menus Menu A 1000 Node, Menu B 100 Node  N -> 1000
// space-> O(N) Space

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node {
    public String key;
    public int value;
    public List<Node> children;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.children = new ArrayList<>();
    }
}

@SuppressWarnings({"ArraysAsListWithZeroOrOneArgument", "DuplicatedCode"})
public class CompareTwoTree {

    // do dfs in here
    public int countDifferentNodes(Node existingMenu, Node newMenu) {
        // return case
        if (existingMenu == null && newMenu == null) {
            return 0;
        }

        // left or right subTree is null or two node's key different
        if ((existingMenu != null && newMenu == null)
                || (existingMenu == null && newMenu != null)
                || !existingMenu.key.equals(newMenu.key)) {
            return countNodes(existingMenu, " deleted ") + countNodes(newMenu, " added ");
        }

        // node's value diff or not
        int diffCount = 0;
        if (existingMenu.value != newMenu.value) {
            diffCount = 1;
            System.out.println("Node  " + existingMenu.key  + "  "  + existingMenu.value + " updated to  " + newMenu.value);

        }

        Map<String, Node> mapA = new HashMap<>();
        Map<String, Node> mapB = new HashMap<>();
        for (Node node : existingMenu.children){
            mapA.put(node.key, node);               // key -> "c"   value -> Node
        }

        for (Node node : newMenu.children){
            mapB.put(node.key, node);
        }

        // compare children nodes
        for (Map.Entry entry : mapA.entrySet()){
            String keyA = (String) entry.getKey();
            Node nodeA = (Node) entry.getValue();

            // check keyA in mapB
            if (!mapB.containsKey(keyA)) {
                diffCount += countNodes(nodeA, "deleted");
            } else {
                Node nodeB = mapB.get(keyA);
                diffCount += countDifferentNodes(nodeA, nodeB);

                mapB.remove(keyA);
            }
        }

        // we have new nodes in MapB's
        for (Map.Entry entry : mapB.entrySet()){
            // String keyB = (String) entry.getKey();
            // if (!mapA.containsKey(keyB)) {          // we have new sub-menu in children
            Node nodeB = (Node) entry.getValue();
            diffCount += countNodes(nodeB, " added ");
            // }
        }

        return diffCount;
    }

    private int countNodes(Node root, String operation){
        if (root == null)
            return 0;

        int count = 1;
        System.out.println("Node  " + root.key  + "  "  + root.value + "   " + operation);

        for (Node node : root.children){
            count += countNodes(node, operation);
        }

        return count;
    }

    public static void main(String[] args) {
        CompareTwoTree solution = new CompareTwoTree();
        int expectedCount = 0;
        int actualCount = 0;

        // Example 1

        Node existingMenu1 = new Node("a", 1);
        Node existingMenu1b = new Node("b", 2);
        Node existingMenu1c = new Node("c", 3);
        Node existingMenu1d = new Node("d", 4);
        Node existingMenu1e = new Node("e", 5);
        Node existingMenu1f = new Node("f", 6);
        existingMenu1.children = Arrays.asList(existingMenu1b, existingMenu1c);
        existingMenu1b.children = Arrays.asList(existingMenu1d, existingMenu1e);
        existingMenu1c.children = Arrays.asList(existingMenu1f);

        Node newMenu1 = new Node("a", 1);
        Node newMenu1c = new Node("c", 3);
        Node newMenu1f = new Node("f", 66);
        newMenu1.children = Arrays.asList(newMenu1c);
        newMenu1c.children = Arrays.asList(newMenu1f);

        expectedCount = 4;
        actualCount = solution.countDifferentNodes(existingMenu1, newMenu1);
        System.out.printf("Example 1 : expected=%d, actual=%d%n", expectedCount, actualCount);

        // Example 2

        Node existingMenu2 = new Node("a", 1);
        Node existingMenu2b = new Node("b", 2);
        Node existingMenu2c = new Node("c", 3);
        Node existingMenu2d = new Node("d", 4);
        Node existingMenu2e = new Node("e", 5);
        Node existingMenu2g = new Node("g", 7);
        existingMenu2.children = Arrays.asList(existingMenu2b, existingMenu2c);
        existingMenu2b.children = Arrays.asList(existingMenu2d, existingMenu2e);
        existingMenu2c.children = Arrays.asList(existingMenu2g);

        Node newMenu2 = new Node("a", 1);
        Node newMenu2b = new Node("b", 2);
        Node newMenu2d = new Node("d", 4);
        Node newMenu2e = new Node("e", 5);
        Node newMenu2f = new Node("f", 6);
        Node newMenu2g = new Node("g", 7);
        Node newMenu2h = new Node("h", 8);
        newMenu2.children = Arrays.asList(newMenu2b, newMenu2h);
        newMenu2b.children = Arrays.asList(newMenu2e, newMenu2d, newMenu2f);
        newMenu2h.children = Arrays.asList(newMenu2g);

        expectedCount = 5;
        actualCount = solution.countDifferentNodes(existingMenu2, newMenu2);
        System.out.printf("Example 2 : expected=%d, actual=%d%n", expectedCount, actualCount);

        // Example 3
        Node existingMenu3 = new Node("a", 1);
        Node existingMenu3b = new Node("b", 2);
        Node existingMenu3c = new Node("c", 3);
        Node existingMenu3d = new Node("d", 4);
        existingMenu3.children = Arrays.asList(existingMenu3b);
        existingMenu3b.children = Arrays.asList(existingMenu3c);
        existingMenu3c.children = Arrays.asList(existingMenu3d);

        Node newMenu3 = new Node("a", 1);
        Node newMenu3e = new Node("e", 5);
        Node newMenu3c = new Node("c", 3);
        Node newMenu3d = new Node("d", 4);
        newMenu3.children = Arrays.asList(newMenu3e);
        newMenu3e.children = Arrays.asList(newMenu3c);
        newMenu3c.children = Arrays.asList(newMenu3d);

        expectedCount = 6;
        actualCount = solution.countDifferentNodes(existingMenu3, newMenu3);
        System.out.printf("Example 3 : expected=%d, actual=%d%n", expectedCount, actualCount);
    }
}
