package Company.Thumbtack;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 6/8/2021 5:00 PM
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

// Start typing here

/*
alive = [
    0 => true,
    1 => true,
    2 => true,
    3 => true,
    4 => false
];

links = [
    0 => [ 1, 2, 3 ],
    1 => [ 3 ],
    2 => [ 4 ],
    3 => [ 1 ],
    4 => [], // irrelevant since alive[4] = false;
]

  0       1,      2              3,    4
output : [ false,   true,      false,     true,      ,false]

// have cycle in the graph
// isloated part of graph
// null input, unmatched boolean[] alive [t, t, t] and List<int[]> links {[0, 2, 3, 4, 5, 6]} // throw exception
// large node in the graph, over 1 billion
// negative number in  List<int[]> links // throw exception
O(n) time and O(n) space

*/

import java.util.*;

public class DeadLine_DFS{
    public static void main(String[] args) throws Exception{
        // boolean[] alive = new boolean[]{true, true, true, true, false};
        boolean[] alive = new boolean[]{true, true, true, true, false};
        List<int[]> links = new ArrayList<>();
        links.add(new int[]{1, 2, 3});
        links.add(new int[]{3});
        links.add(new int[]{4});
        links.add(new int[]{1});
        links.add(new int[]{});


        validParameter(alive, links);
        boolean[] visited = new boolean[alive.length];
        dfs(alive, visited, links, 0);

        for (int i = 0; i < alive.length; i++){
            System.out.println("index of  : " + i  + "   " + alive[i]);
        }
    }

    private static boolean dfs(boolean[] alive, boolean[] visited, List<int[]> links, int index){

        if (visited[index])
            return alive[index];

        visited[index] = true;

        int[] curLink = links.get(index);      // index = 0, [ 1, 2, 3 ]
        boolean curAlive = alive[index];

        for (int next : curLink){
            boolean nextAlive = dfs(alive, visited, links, next);
            if (!nextAlive){
                curAlive = false;
                alive[next] = curAlive;
            }
        }


        alive[index] = curAlive;
        visited[index] = false;

        return curAlive;
    }

    private static void validParameter(boolean[] alive, List<int[]> links) throws  Exception{
        if (alive == null || alive.length == 0 || alive.length != links.size()) {
            throw new Exception("we have invalid input parameter");
        }

        for (int[] nodes : links){
            for (int n : nodes){
                if(n < 0) {
                    throw new Exception("we have invalid input parameter");
                }
            }
        }
    }
}