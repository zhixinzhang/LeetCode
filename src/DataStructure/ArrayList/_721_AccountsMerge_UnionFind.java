package DataStructure.ArrayList;
import java.util.*;
/**
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 *
 * */

public class _721_AccountsMerge_UnionFind{
    // basic id is build a graph and use dfs to find same person
    // we keep remember the path(email)
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
}