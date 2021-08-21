package Company.Karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Luke Zhang
 * @Date 2021-06-21 12:34
 *
 *     ["Logic", "COBOL"],
 *     ["Data Structures", "Algorithms"],
 *     ["Creative Writing", "Data Structures"],
 *     ["Algorithms", "COBOL"],
 *     ["Intro to Computer Science", "Data Structures"],
 *     ["Logic", "Compilers"],
 *     ["Data Structures", "Logic"],
 *     ["Graphics", "Networking"],
 *     ["Networking", "Algorithms"],
 *     ["Creative Writing", "System Administration"],
 *     ["Databases", "System Administration"],
 *     ["Creative Writing", "Databases"],
 *     ["Intro to Computer Science", "Graphics"],
 */

public class MidCourse2_Robinhood {

    static List<String> ans = new ArrayList<>();
    public static void main(String[] args){
        String[][] courses = new String[][]{
            {"Logic", "COBOL"},
            {"Data Structures", "Algorithms"},
            {"Creative Writing", "Data Structures"},
            {"Algorithms", "COBOL"},
            {"Intro to Computer Science", "Data Structures"},
            {"Logic", "Compilers"},
            {"Data Structures", "Logic"},
            {"Graphics", "Networking"},
            {"Networking", "Algorithms"},
            {"Creative Writing", "System Administration"},
            {"Databases", "System Administration"},
            {"Creative Writing", "Databases"},
            {"Intro to Computer Science", "Graphics"}
        };

        findMidCourses(courses);

        for (String course : ans){
            System.out.println(course);
        }
    }

    private static void findMidCourses(String[][] courses){
        HashMap<String, List<String>> map = new HashMap<>();
        Set<String> cache = new HashSet<>();

        for (String[] course : courses){
            cache.add(course[1]);
            map.putIfAbsent(course[0], new ArrayList<>());
            map.get(course[0]).add(course[1]);
        }

        Set<String> heads = new HashSet<>();
        for (String[] course : courses){
            if (!cache.contains(course[0])){
                heads.add(course[0]);
            }
        }

        HashSet<String> visited = new HashSet<>();
        for (String course : heads){
            dfs(course, map, new ArrayList<>(), visited);
        }
    }

    private static void dfs(String course, HashMap<String, List<String>> map, List<String> path, HashSet<String> visited){
        if (course == null || map.get(course) == null || map.get(course).isEmpty()) {
            int idx = path.size() % 2 == 0 ? (path.size() / 2 - 1 ) : path.size() / 2 ;
            ans.add(path.get(idx));
            return;
        }

        visited.add(course);

        List<String> nextLevel = map.get(course);
        for (String cour : nextLevel){
            if (visited.contains(cour))
                continue;
            path.add(cour);
            dfs(cour, map, path, visited);
            path.remove(path.size() - 1);
        }

        visited.remove(course);
    }
}

