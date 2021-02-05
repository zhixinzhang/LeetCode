package Company.PG;
import java.util.*;

// hashset to store string (length = 2)
// apple -- ap pp pl le ---> hashset 
// use hashset element compare to String t () 
public class Length2Duplicate{

	public static void main(String[] args) {
        String a = "apple";
        String b = "app";
        System.out.println(find(a, b));
    }
    public static int find(String s, String t) {
        if (s.length() < 2 || t.length() < 2) return 0;
        HashSet<String> candidate = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            StringBuilder sb = new StringBuilder(s.charAt(i)).append(s.charAt(i + 1));
            candidate.add(sb.toString());
        }
        for (int j = 0; j < t.length() - 1; j++) {
            StringBuilder sb = new StringBuilder(t.charAt(j)).append(s.charAt(j + 1));
            if (candidate.contains(sb.toString())) {
                count++;
//                candidate.remove(sb.toString());
            }
        }
        return count;
    }
}
