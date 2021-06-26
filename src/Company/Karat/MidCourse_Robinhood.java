package Company.Karat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Luke Zhang
 * @Date 2021-06-21 12:04
 *
 * https://www.1point3acres.com/bbs/thread-739042-1-1.html
 *
 * 一堆课，找出上课顺序里,中间的那门课，只有一种正确的顺序，并且每个课只会对应另外一个prereq
 * 比如
 *
 *     ["Data Structures", "Algorithms"],
 *     ["COBOL", "Networking"],
 *     ["Algorithms", "COBOL"],
 *
 * "Data Structures"->"Algorithms" -> "COBOL"-> "Networking"
 *
 * 返回 “Algorithms"
 */
public class MidCourse_Robinhood {

    // Data Structures -> Algorithms -> COBOL -> Networking -> test
    public static void main(String[] args){
        String[][] input = new String[][]{
            {"Data Structures", "Algorithms"},
            {"COBOL", "Networking"},
            {"Algorithms", "COBOL"},
            {"Networking", "test"},
        };

        String ans = findMidCourse(input);
        System.out.println(ans);
    }

    private static String findMidCourse(String[][] courses){
        if (courses == null || courses.length == 0 || courses[0].length == 1) {
            return null;
        }

        // find head course
        Set<String> cache = new HashSet<>();
        HashMap<String, String> map = new HashMap<>();
        for (String[] course : courses){
            cache.add(course[1]);
            map.put(course[0], course[1]);
        }

        String head = "";
        for (String[] course : courses){
            if (!cache.contains(course[0])) {
                head = course[0];
                break;
            }
        }

        int mid = courses.length / 2;
        for (int i = 0; i < mid; i++){
            head = map.get(head);
        }

        return head;
    }
}
