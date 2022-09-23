package Company.Doordash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * We want to implement an in-memory tree key value store for Doordash Restaurant Menus.
 * Definitions:
 *
 * path is a / separate string describing the node. Example /Tres Potrillos/tacos/al_pastor
 * Values are all strings
 * API spec:
 * get(path): String -> returns the value of the node at the given path
 * create(path, value) -> creates a new node and sets it to the given value.
 * Should error out if the node already exists or if the node’s parent does not exist. That is /Sweetgreen/naan_roll cannot be created if /Sweetgreen has not already been created
 * delete(path) -> deletes a node, but ONLY if it has no children
 * */
public class _1166_in_memory_doordash_withdeleteapi_trie {
    static Node root;

    static class Node {
        String key;
        int val;

        Map<String, Node> children;

        Node(String key, int val) {
            this.key = key;
            this.val = val;
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) throws Exception{
        root = new Node("-1", -1);
        createPath("/Sweetgreen/", 1);
        createPath("/Sweetgreen/naan_roll", 18);
        System.out.println(get("/Sweetgreen/naan_roll"));
        delete("/Sweetgreen/naan_roll");
        System.out.println(get("/Sweetgreen"));
    }

    //get(path): String -> returns the value of the node at the given path
    public static int get(String path) throws Exception{
        String[] nodes = path.split("\\/");
        System.out.println(" values : "+ Arrays.asList(nodes).toString());
        String[] nodesValues = new String[nodes.length-1];
        for(int i=1;i<nodes.length;i++){
            nodesValues[i-1] = nodes[i];
        }
        return getValue(root.children, nodesValues, 0);
    }

    public static int getValue(Map<String, Node> nodes, String[] pathNodes, int index) throws Exception{
        if(index == pathNodes.length - 1){
            if(!nodes.containsKey(pathNodes[index])){
                throw new Exception("Does not exists");
            }
            return nodes.get(pathNodes[index]).val;
        }

        if(nodes.containsKey(pathNodes[index])){
            Node node = nodes.get(pathNodes[index]);
            return getValue(node.children, pathNodes, index+1);
        }else{
            throw new Exception("Parent does not exists");
        }
    }

    // create(path, value) -> creates a new node and sets it to the given value. Should error out if the node already exists or if the node’s parent does not exist. That is /Sweetgreen/naan_roll cannot be created if /Sweetgreen has not already been created
    public static void createPath(String path, int value) throws Exception{
        if(path == null || path.isEmpty()){
            return;
        }

        String[] nodes = path.split("\\/");
        String[] nodesValues = new String[nodes.length-1];
        for(int i = 1;i < nodes.length; i++){
            nodesValues[i-1] = nodes[i];
        }
        dfs(root.children, nodesValues , 0, value);
    }

    public static void dfs(Map<String, Node> nodes, String[] pathNodes, int index, int value) throws Exception{
        if(index == pathNodes.length - 1){
            if(nodes.containsKey(pathNodes[index])){
                throw new Exception("Already exists");
            }

            nodes.put(pathNodes[index], new Node(pathNodes[index], value));
            System.out.println("Add Successful!");
            return;
        }

        if(nodes.containsKey(pathNodes[index])){
            Node node = nodes.get(pathNodes[index]);
            dfs(node.children, pathNodes, index+1, value);
        }else{
            throw new Exception("Parent does not exists");
        }
    }

    //delete(path) -> deletes a node, but ONLY if it has no children
    public static void delete(String path) throws Exception{
        if(path == null || path.isEmpty()){
            return;
        }

        String[] nodes = path.split("\\/");
        String[] nodesValues = new String[nodes.length-1];
        for(int i=1;i<nodes.length;i++){
            nodesValues[i-1] = nodes[i];
        }
        deleteNode(root.children, nodesValues, 0);
    }

    public static void deleteNode(Map<String, Node> nodes, String[] pathNodes, int index) throws Exception{
        if(index == pathNodes.length - 1){
            if(nodes.containsKey(pathNodes[index])){
                Node node = nodes.get(pathNodes[index]);
                if(node.children.isEmpty()){
                    nodes.remove(pathNodes[index]);
                    System.out.println("Delete Successful!");
                    return;
                }else{
                    throw new Exception("Has children, cannot be deleted");
                }
            }
        }

        if(nodes.containsKey(pathNodes[index])){
            Node node = nodes.get(pathNodes[index]);
            deleteNode(node.children, pathNodes, index+1);
        }else{
            throw new Exception("Parent does not exists");
        }
    }
}
