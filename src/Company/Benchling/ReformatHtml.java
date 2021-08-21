<<<<<<< Updated upstream
//package Company.Benchling;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Stack;
//
///**
// * @author Luke Zhang
// * @Date 2021-07-07 17:52
// *
// * https://www.1point3acres.com/bbs/thread-488416-1-1.html
// *
// * Write a function that converts encoded HTML into actual HTML. The function will take a string of text, and then a
// * hashmap, mapping html tags to a list of touples, where each touple represents the first and last index of the string that the tags need to encompass.
// *
// *
// * Given text string and different formats with indexes indicated (ie. bold:[0,3], italics[2,4], underline:[2,6])
// * return formatted text with html tags representing start and end of different formats
// */
//public class ReformatHtml {
//
//    public static void main(String[] args){
//        String html = "abcdefg";
//        Map<String, List<int[]>> map = new HashMap<>();
//        map.put("bold", new ArrayList<>());
//        map.get("bold").add(new int[]{0, 3});
//        map.put("italics", new ArrayList<>());
//        map.get("italics").add(new int[]{2, 4});
//        map.put("underline", new ArrayList<>());
//        map.get("underline").add(new int[]{2, 6});
//
//        String ans = encode(html, map);
//    }
//
//    static class Tag {
//        String tag;
//        int index;
//        boolean open;
//
//        public Tag(String tag, int index, boolean open){
//            this.tag = tag;
//            this.index = index;
//            this.open = open;
//        }
//
//    }
//
//    private static String encode(String html, Map<String, List<int[]>> map){
//        List<Tag> lists = new ArrayList<>();
//        if (html == null || html.length() == 0 || map.size() == 0)
//            return html;
//
//        for (Map.Entry<String, List<int[]>> entry : map.entrySet()){
//            String val = entry.getKey();
//            for (int[] indexs : entry.getValue()){
//                Tag tagOpen = new Tag(val, indexs[0], true);
//                Tag tagEnd = new Tag(val, indexs[1], false);
//                lists.add(tagOpen);
//                lists.add(tagEnd);
//            }
//        }
//
//        Collections.sort(lists, new Comparator<Tag>() {
//            @Override
//            public int compare(Tag o1, Tag o2) {
//                if (o1.index != o2.index)
//                    return o1.index - o2.index;
//                else
//                    return o1.open ? -1 : 0;
//            }
//        });
//
//
//        StringBuilder sb = new StringBuilder();
//        int curIndex = 0;
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < lists.size(); i++){
//            Tag tag = lists.get(i);
//        }
//    }
//}
=======
package Company.Benchling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author Luke Zhang
 * @Date 2021-07-07 17:52
 *
 * https://www.1point3acres.com/bbs/thread-488416-1-1.html
 *
 * Write a function that converts encoded HTML into actual HTML. The function will take a string of text, and then a
 * hashmap, mapping html tags to a list of touples, where each touple represents the first and last index of the string that the tags need to encompass.
 *
 *
 * Given text string and different formats with indexes indicated (ie. bold:[0,3], italics[2,4], underline:[2,6])
 * return formatted text with html tags representing start and end of different formats
 */
public class ReformatHtml {

    public static void main(String[] args){
        String html = "abcdefg";
        Map<String, List<int[]>> map = new HashMap<>();
        map.put("bold", new ArrayList<>());
        map.get("bold").add(new int[]{0, 3});
        map.put("italics", new ArrayList<>());
        map.get("italics").add(new int[]{2, 4});
        map.put("underline", new ArrayList<>());
        map.get("underline").add(new int[]{2, 6});

        String ans = encode(html, map);
    }

    static class Tag {
        String tag;
        int index;
        boolean open;

        public Tag(String tag, int index, boolean open){
            this.tag = tag;
            this.index = index;
            this.open = open;
        }

    }

    private static String encode(String html, Map<String, List<int[]>> map){
        List<Tag> lists = new ArrayList<>();
        if (html == null || html.length() == 0 || map.size() == 0)
            return html;

        for (Map.Entry<String, List<int[]>> entry : map.entrySet()){
            String val = entry.getKey();
            for (int[] indexs : entry.getValue()){
                Tag tagOpen = new Tag(val, indexs[0], true);
                Tag tagEnd = new Tag(val, indexs[1], false);
                lists.add(tagOpen);
                lists.add(tagEnd);
            }
        }

        Collections.sort(lists, new Comparator<Tag>() {
            @Override
            public int compare(Tag o1, Tag o2) {
                if (o1.index != o2.index)
                    return o1.index - o2.index;
                else
                    return o1.open ? -1 : 0;
            }
        });


        StringBuilder sb = new StringBuilder();
        int curIndex = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < lists.size(); i++){
            Tag tag = lists.get(i);
            if (tag.open) {
                stack.add(tag.tag);
            } else {
                // find all same end index tag
                int j = i + 1;
                for (; j < lists.size(); j++){
                    if (lists.get(j).open && lists.get(j).index != tag.index) {
                        break;
                    }
                }

                j--;
                int count = j - i;
                int endIndex = tag.index;
                String sub = html.substring(curIndex, endIndex);
                while (count > 0){
                    String tagSb = stack.pop();
                    sub = String.format("<%s>%s</%s>", tagSb, sub, tagSb);
                }
                sb.append(sub);
                curIndex = endIndex + 1;
            }
        }

        return sb.toString();
    }
}
>>>>>>> Stashed changes
