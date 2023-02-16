package Company.Square;
import java.util.*;

/**
 *       
 * // iterate line by line
    // Check the leading space count
    // Use a stack to track the list of nodes (parents)
    // if value is empty; current node should be a container; add to stack
 * 
*/

public class _JsonCompare_Stack_Map {

    public static void main(String[] args) {
        String test =   
                        "K1:V1\n" +
                        "K2:V2\n" +
                        "K3:\n" +
                        "  K31:V31\n" +
                        "  K32:\n" +
                        "    K321:V321\n" +
                        "     K322:V322\n" +
                        "    K333:V333\n" +
                        "K4:\n" +
                        "  K41:V41\n" +
                        "  K42:V42";

        String test2 =   
                        "K1:V1\n" +
                        "K2:V2\n" +
                        "K3:\n" +
                        "  K31:V31\n" +
                        "  K32:\n" +
                        "    K321:V321\n" +
                        "     K322:V322\n" +
                        "    K333:V333\n" +
                        "K4:\n" +
                        "  K41:V41\n" +
                        "  K42:V423";        

        Map<String, Object> ans = parse(test);
        System.out.println(ans);
        Map<String, Object> ans2 = parse(test2);
        System.out.println(ans2);
        if (ans.equals(ans2)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static Map<String, Object> parse(final String s) {
        if (s == null || s.isBlank()) {
            return Collections.EMPTY_MAP;
        }
        final Map<String, Object> root = new HashMap<>();
        final Stack<Map<String, Object>> stack = new Stack<>();
        stack.push(root);

        int pre = 0;
        for (String line: s.split("\n")) {
            final int spaceCount = line.lastIndexOf(" ") + 1;
            if (pre - spaceCount >= 2) {
                stack.pop();
            }
            final String[] parts = line.trim().split(":");
            if (parts.length > 1) {
                stack.peek().put(parts[0], parts[1]);
            } else {
                final Map<String, Object> map = new HashMap<>();
                stack.peek().put(parts[0], map);
                stack.push(map);
            }

            pre = spaceCount;
        }

        return root;
    }
}
