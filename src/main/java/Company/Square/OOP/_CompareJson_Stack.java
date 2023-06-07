package Company.Square.OOP;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 和 _JsonCompare_Stack_Map 一样，格式有点区别 但是ok
public class _CompareJson_Stack {
    public static void main(String[] args) {
        String json1 = "{\n"  + 
                        "    employee:\n" + 
                        "    {\n" +
                        "       \"id\": \"12\",\n"  +
                        "       \"fullname\": \"Luke\",\n"  +
                        "       \"age\": \"26\",\n"  +
                        "       \"skills\": [\"JavaB\", \"C++\", \"Python\"],\n" +
                        "       contact:\n" + 
                        "       {\n" +
                        "           \"email\": \"zhangzhixinluke@gmail.com\",\n" + 
                        "           \"phone\": \"123\"\n" + 
                        "       }\n"    +
                        "    }\n"  +
                        "}\n";

        String json2 = "{\n"  + 
                        "    employee:\n" + 
                        "    {\n" +
                        "       \"id\": \"12\",\n"  +
                        "       \"fullname\": \"Luke\",\n"  +
                        "       \"age\": \"26\",\n"  +
                        "       \"skills\": [\"JavaB\", \"C++\", \"Python\"],\n" +
                        "       contact:\n" + 
                        "       {\n" +
                        "           \"email\": \"zhangzhixinluke@gmail.com\",\n" + 
                        "           \"phone\": \"123\"\n" + 
                        "       }\n"    +
                        "    }\n"  +
                        "}\n";                

        System.out.println(json1);
        compareJson(json1, json2);
    }

    private static boolean compareJson(String j1, String j2){
        boolean ans = false;
        Map<String, Object> ans1 = parse(j1);
        System.out.println(ans1);
        Map<String, Object> ans2 = parse(j2);
        System.out.println(ans2);

        if (ans1.equals(ans2)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return ans;
    }

    public static Map<String, Object> parse(final String s) {
        if (s == null || s.isBlank()) {
            return Collections.EMPTY_MAP;
        }
        final Map<String, Object> root = new HashMap<>();
        final Stack<Map<String, Object>> stack = new Stack<>();
        stack.push(root);

        int pre = 0;
        String[] levels = s.split("\n");
        for (String line: levels) {
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
