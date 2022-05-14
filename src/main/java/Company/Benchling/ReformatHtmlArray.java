package Company.Benchling;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 7/8/2021 12:49 AM
 * <p>
 * Source Link:
 * <p>
 * Description:
 * <p>
 * <p>
 * Time and Space Complexity:
 * <p>
 *     text = 'ABCDEFGHIJ'
 * format = {
 * 	'bold': [(0,4)],
 * 	'italics': [(2,6)]
 * }
 *
 * output = '<b>AB<i>CD</i></b><i>EF</i>GHIJ'
 *
 * <b>AB<i>CD</i></b>EF</b></i>GHIJ
 * <p>
 * Data structure
 */

public class ReformatHtmlArray {
    public static void main(String[] args){
        String html = "ABCDEFGHIJ";
        Map<String, List<int[]>> map = new HashMap<>();

        map.put("bold", new ArrayList<>());
        map.get("bold").add(new int[]{0, 4});
        map.put("italics", new ArrayList<>());
        map.get("italics").add(new int[]{2, 6});
//        map.put("bold", new ArrayList<>());
//        map.get("bold").add(new int[]{0, 3});
//        map.put("italics", new ArrayList<>());
//        map.get("italics").add(new int[]{2, 4});
//        map.put("underline", new ArrayList<>());
//        map.get("underline").add(new int[]{2, 6});


        Map<String, String> tagsMap = new HashMap<>();
        tagsMap.put("bold", "<b>");
        tagsMap.put("<b>", "</b>");

        tagsMap.put("italics", "<i>");
        tagsMap.put("<i>", "</i>");

        tagsMap.put("underline", "<u>");
        tagsMap.put("<u>", "</u>");

        String ans = encode(html, map, tagsMap);

        System.out.println(ans);
    }

    private static String encode(String html, Map<String, List<int[]>> map, Map<String, String> tagsMap) {
        if (html == null || html.length() == 0 || map.size() == 0)
            return html;

        List<List<String>> tags = new ArrayList<>();
        for (int i = 0; i < html.length(); i++){
            tags.add(new ArrayList<>());
        }

        for (Map.Entry<String, List<int[]>> entry : map.entrySet()) {
            String val = entry.getKey();
            for (int[] indexs : entry.getValue()) {
                tags.get(indexs[0]).add(tagsMap.get(val));
                tags.get(indexs[1]).add(0, tagsMap.get(tagsMap.get(val)));
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < html.length(); i++){
            if (tags.get(i) == null || tags.get(i).isEmpty()) {
                sb.append(html.charAt(i));
            } else {
                boolean flag = false;
                List<String> lists = tags.get(i);
                for (String s : lists){
                    if (!s.contains("/")) {
                        sb.append(s);
                        stack.add(s);
                    } else {
                        String t = stack.peek();
                        while (t != null && !tagsMap.get(t).equals(s)) {
                            sb.append(tagsMap.get(t));

                            stack.pop();
                            if (stack.isEmpty())
                                break;
                            t = stack.peek();
                            int a = 0;
                        }
                        sb.append(s);
                    }
                }

                if (!flag) {
                    sb.append(html.charAt(i));
                }
            }
        }

        return sb.toString();
    }
}
