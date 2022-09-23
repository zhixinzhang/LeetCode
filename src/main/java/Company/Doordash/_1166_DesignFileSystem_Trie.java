package Company.Doordash;

import java.util.HashMap;
import java.util.Map;

public class _1166_DesignFileSystem_Trie {


    class TrieNode {
        Map<String, TrieNode> children;
        Integer value;

        public TrieNode() {
            this.children = new HashMap<>();
            this.value = null;
        }
    }

    private TrieNode root;

    public _1166_DesignFileSystem_Trie() {
        // Trie + HashMap
        root = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        if (path.isEmpty()) {
            throw new RuntimeException("path should not be empty");
        }
        String[] pathArr = path.split("/");
        return dfsCreate(pathArr, 0, root, value);
    }

    public int get(String path) {
        if (path.isEmpty()) {
            throw new RuntimeException("path should not be empty");
        }
        String[] pathArr = path.split("/");
        TrieNode findNode = dfsFind(pathArr, 0, root);
        if (findNode == null || findNode.value == null) return -1;
        return findNode.value;
    }

    private boolean dfsCreate(String[] pathArr, int curIndex, TrieNode curNode, int value) {
        if (curIndex == pathArr.length) {
            if (curNode.value != null) return false;
            curNode.value = value;
            return true;
        } else {
            if (pathArr[curIndex] == "") { // curIndex == 0
                return dfsCreate(pathArr, curIndex+1, curNode, value);
            }
            TrieNode nextNode = null;
            if (!curNode.children.containsKey(pathArr[curIndex])) {
                if (curIndex != pathArr.length-1) return false;
                nextNode = new TrieNode();
                curNode.children.put(pathArr[curIndex], nextNode);
            }
            nextNode = curNode.children.get(pathArr[curIndex]);
            return dfsCreate(pathArr, curIndex+1, nextNode, value);
        }
    }

    private TrieNode dfsFind(String[] pathArr, int curIndex, TrieNode curNode) {
        if (curIndex == pathArr.length) return curNode;
        TrieNode nextNode = null;
        if (pathArr[curIndex] == "") nextNode = curNode;
        else nextNode = curNode.children.get(pathArr[curIndex]);

        if (nextNode == null) return null;
        return dfsFind(pathArr, curIndex+1, nextNode);
    }
}
