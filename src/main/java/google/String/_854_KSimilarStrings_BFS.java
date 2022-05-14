package google.String;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhang on 2018/6/18.
 * Input: A = "abc", B = "bca"
 Output: 2
 Input: A = "abac", B = "baca"  // a - b a - c
 Output: 2
 Input: A = "aabc", B = "abca"  //abc - bca  a-b b-c c-a
 Output: 2
 A 每次两个letter交换 多少次之后得到B 求K最小  BFS
  a b c   ----   b c a
  b a c  ----   b c a
 考虑到 多种character
 acddde - > dcddae


 */
public class _854_KSimilarStrings_BFS {
    public int kSimilarity(String A, String B) {
        if(A.equals(B)) return 0;
        if(A.length() != B.length()) return -1;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(A);
        visited.add(A);
        int res = 0;
        while(!q.isEmpty()){
            res++;
            for(int size = 0; size<q.size(); size++){
                String curS = q.poll();
                // swap
                int index = 0;
                while(curS.charAt(index) == B.charAt(index)) index++;

                for (int j = index + 1;j <curS.length(); j++){
                    char c = B.charAt(index);
//                    if (curS.charAt(j) == B.charAt(j) || curS.charAt(index)!=B.charAt(j) ) continue;
                    if (curS.charAt(j) == c){
                        String temp = swap(curS,index,j);
                        if (temp.equals(B))
                            return res;
                        if (!visited.contains(temp)){
                            visited.add(temp);
                            q.add(temp);
                        }
                    }
                }

            }
        }
    return res;
    }
    public String swap(String s, int i, int j){
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
//        return new String(chars);
    }
}
