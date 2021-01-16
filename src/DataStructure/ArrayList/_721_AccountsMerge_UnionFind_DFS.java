package DataStructure.ArrayList;
import java.util.*;
/**
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 *
 * */


/**
 * @Author: Luke(New Man) Zhang
 * @Date: 2021/1/15 21:45
 * Link :
 * Description: https://leetcode.com/problems/accounts-merge/
 * https://leetcode.com/problems/trapping-rain-water/discuss/409175/Java-Detailed-Explanations-and-Illustrations-(divide-and-conquer-DP-two-pointers)
 */
public class _721_AccountsMerge_UnionFind_DFS {

    /**
     * Solution 1 : DFS with stack
     * Time Complexity: O(\sum a_i \log a_i)O(∑a
     * i
     * ​
     *  loga
     * i
     * ​
     *  ), where a_ia
     * i
     * ​
     *   is the length of accounts[i]. Without the log factor, this is the complexity to build the graph and search for each component. The log factor is for sorting each component at the end.
     *
     * Space Complexity: O(\sum a_i)O(∑a
     * i
     * ​
     *  ), the space used by our graph and our search.
     *
     * basic id is build a graph and use dfs to find same person
     * we keep remember the path(email)
     * */


    public List<List<String>> accountsMerge_dfs_stack(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email: graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    /**
     * Solution 1 : DFS
     * */
    public static List<List<String>> accountsMerge_DFS(List<List<String>> accounts) {
        HashMap<String, Set<String>> graph = new HashMap<>();        // email  emails
        HashMap<String, String> name = new HashMap<>();              // email name
        for (List<String> account : accounts){
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);

                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
             }
         }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();

        // DFS
        for (String email : name.keySet()){
            List<String> list = new ArrayList<>();
            if (visited.add(email)){
                dfs(graph,email,visited,list);
                Collections.sort(list);
                list.add(0,name.get(email));
                res.add(list);
            }
        }
        return res;
    }
    public static void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list){
        list.add(email);
        for (String next : graph.get(email)){
            if (visited.add(next)){
                dfs(graph, next, visited,list);
            }
        }
    }
    public static void main(String[] args){
        List<List<String >> in = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("John");
        l.add("johnsmith@mail.com");
        l.add("john00@mail.com");
        List<String> ll = new ArrayList<>();
        ll.add("John");
        ll.add("johnnybravo@mail.com");
        List<String> lll = new ArrayList<>();
        lll.add("John");
        lll.add( "john_newyork@mail.com");
        lll.add("johnsmith@mail.com");
        List<String> llll = new ArrayList<>();
        llll.add("Mary");
        llll.add("mary@mail.com");
        in.add(l);
        in.add(ll);
        in.add(lll);
        in.add(llll);
        accountsMerge_DFS(in);
    }




    int[] id;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts == null || accounts.size() == 0){
            return new ArrayList<>();
        }
        int len = accounts.size();
        List<List<String>> res = new ArrayList<>();
        id = new int[len];
        for(int i = 0; i < len; i++){
            id[i] = i;
        }
        
        Map<String, Set<Integer>> accountMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            List<String> account1 = accounts.get(i);
            for(int j = 1; j < account1.size(); j++){
                String email = account1.get(j);
                if(!accountMap.containsKey(email)){
                    accountMap.put(email, new HashSet<>());
                }
                else{
                    for(int idx : accountMap.get(email)){
                        id[find(idx)] = i;
                        break;
                    }
                }
                accountMap.get(email).add(i);
            }
        }    
        
        Map<Integer, Set<String>> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            List<String> account1 = accounts.get(i);
            int root = find(i);
            if(!map.containsKey(root)){
                map.put(root, new HashSet<>());
            }
            for(int j = 1; j < account1.size(); j++){
                map.get(root).add(account1.get(j));
            }
        }
        
        for(int key : map.keySet()){
            List<String> list = new ArrayList<String>(map.get(key));
            Collections.sort(list, new Comparator<String>(){
               public int compare(String str1, String str2){
                   return str1.compareTo(str2);
               } 
            });
            list.add(0, accounts.get(key).get(0));
            res.add(list);
        }
        
        return res;
    }
    
    public int find(int p){
        while(id[p] != p){
            p = id[p];
            id[p] = id[id[p]];
        }
        
        return p;
    }


    /**
     * 3
     * */


    /*
Logic:
If an email id is already present in some other name, then we need to merge both the names.
In the given ex: (1,3), (2), (4) are the names grouped after the merge is completed.
Assume these names as vertex in graph.
Now the problem reduced to "connected components in a graph".

Connected components in a graph can be found using normal DFS or also using DSU.

Comparison between DFS and DSU:

The task that DSU achieves in this code can be done using DFS as well.
You should to code the same using DFS too.
Though, keep in mind that DFS is not a replacement for DSU. DFS works well in cases when all edges are present in the graph from the beginning.
But, in problems where edges are added during the execution and we need to run connectivity queries in between such additions, DSU is the better option.

An example of this type of situation is the Kruskal's algorithm to find the Minimum Spanning Tree (MST).
In Kruskal's algorithm, before adding an edge to the MST we need to check if the addition of the edge creates a cycle or not. We can use DSU here. If the parents of the two nodes that the edge connects are same, then we know that addition of the edge will create a cycle.
*/

// DSU
    class Solution
    {
        public class Node                       // each user is a node
        {
            Node parent;
            int rank;
            String name;
            List<String> emails;

            public Node(String name)
            {
                this.name = name;
                this.emails = new ArrayList<>();
                this.parent = this;
                this.rank = 1;
            }
        }

        public Node findParent(Node node)       // path compression
        {
            if(node.parent == node) {
                return node.parent;
            }
            return node.parent = findParent(node.parent);
        }

        public void union(Node n1, Node n2)     // union by rank
        {
            if(n1.rank >= n2.rank) {
                n1.rank += n2.rank;
                n2.parent = n1;
            }
            else {
                n2.rank += n1.rank;
                n1.parent = n2;
            }
        }

        public List<List<String>> accountsMerge(List<List<String>> accounts)
        {
            Map<String, Node> emailToNodeMap = new HashMap<>();
            List<Node> allNodeList = new ArrayList<>();
            String name, email;

            for(List<String> account : accounts)
            {
                name = account.get(0);
                Node node = new Node(name);
                allNodeList.add(node);

                for(int i = 1; i < account.size(); i++)
                {
                    email = account.get(i);
                    if(!emailToNodeMap.containsKey(email))     // new email
                    {
                        emailToNodeMap.put(email, node);
                        node.emails.add(email);
                    }
                    else                                       // existing email, so do find-union
                    {
                        Node currentNodeParent = findParent(node);
                        Node existingNodeParent = findParent(emailToNodeMap.get(email));
                        union(currentNodeParent, existingNodeParent);
                    }
                }
            }

            for(Node node : allNodeList)
            {
                if(node.parent != node)
                {
                    Node parentNode = findParent(node);
                    parentNode.emails.addAll(node.emails);      // merge accounts
                }
            }

            List<List<String>> outputList = new ArrayList<>();
            List<String> currList;
            for(Node node : allNodeList)                        // form output
            {
                if(node.parent == node)
                {
                    currList = new ArrayList<>();
                    currList.add(node.name);
                    Collections.sort(node.emails);              // sort the emails
                    currList.addAll(node.emails);
                    outputList.add(currList);
                }
            }
            return outputList;
        }
    }
}