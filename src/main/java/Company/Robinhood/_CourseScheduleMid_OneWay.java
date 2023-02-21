package Company.Robinhood;
import java.util.*;

// https://www.1point3acres.com/bbs/thread-807470-1-1.html
/**
 *   Write a function that takes a list of (prerequisite, course) pairs, and returns the name  of the course that the student will be taking when they are halfway through their           
 * program. (If a track has an even number of courses, and therefore has two "middle" courses,   you should return the first one.)
 * 
*/
public class _CourseScheduleMid_OneWay {
    public static void main(String[] args) {
        String[][] input = new String[][]{
            {"Foundations of Computer Science", "Operating Systems"}, 
            {"Data Structures", "Algorithms"}, 
            {"Computer Networks", "Computer Architecture"}, 
            {"Algorithms", "Foundations of Computer Science"}, 
            {"Computer Architecture", "Data Structures"}, 
            {"Software Design", "Computer Networks"}
        };

        String[][] input2 = new String[][]{
            {"Data Structures", "Algorithms"}, 
            {"Algorithms", "Foundations of Computer Science"}, 
            {"Foundations of Computer Science", "Logic"}
        };

        findMidCourse(input);
    }
    private static List<String> findMidCourse(String[][] input){
        if (input == null || input.length == 0) {
            return null;
        }
        List<String> ans = new ArrayList<>();
        Map<String, Integer> indegreeMap = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        for (String[] courses : input){
            String dest = courses[1];
            String src = courses[0];
            List<String> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);

            indegreeMap.putIfAbsent(courses[1], 0);
            indegreeMap.putIfAbsent(courses[0], 0);
            int ind = indegreeMap.get(dest) + 1;
            indegreeMap.put(dest, ind);
        }
        
        // find couser that indgree == 0 no prerequest
        Queue<String> queue = new ArrayDeque<>();
        for (String s : indegreeMap.keySet()){
            if (indegreeMap.get(s) == 0) {
                queue.add(s);
            }
        }

        // BFS find all path 
        while(!queue.isEmpty()){
            String courseName = queue.poll();
            ans.add(courseName);

            if (adjList.containsKey(courseName)) {
                for (String nextLevel : adjList.get(courseName)){
                    int ind = indegreeMap.get(nextLevel) - 1;
                    indegreeMap.put(nextLevel, ind);
                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (ind == 0) {
                        queue.add(nextLevel);
                    } 
                }
            } 
        }

        // Check to see if topological sort is possible or not.
        for(String s : ans){
            System.out.println(s);
        }
        int mid = 0;
        if (ans.size() % 2 == 0){
            mid = (ans.size() / 2) - 1;
        } else {
            mid = ans.size() / 2; 
        }
        System.out.print("Mid course is : " + ans.get(mid));
        return ans;
    }
}
