package DataStructure.String;

import java.util.HashMap;

/**
 * Created by zhang on 2017/2/5.
 * Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.
 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 https://www.1point3acres.com/bbs/thread-517003-1-1.html
Amazon follow up
 还有一道coding是Given two words as Strings, determine if they are isomorphic。字母需要挨个对应，LC应该有这道题。Followup是如果有3个字符串怎么比较，N个呢？
如果是N个 就 维护hashmap 然后对比
 */
//用两个hashMap 维护字符映射关系
public class isomorphicStrings205 {

    public static boolean isIsomorphic(String s, String t) {
        boolean result  = true;   //abbaacc    fggffee
        if (s.length() != t.length()) return  false;
        HashMap<Character,Character>  mapS = new HashMap<>();
        HashMap<Character,Character> mapT = new HashMap<>();

        for(int i = 0;i<s.length();i++){
            final  char c1 = s.charAt(i);
            final  char c2 = t.charAt(i);

            if(mapS.containsKey(c1)){
                if(mapS.get(c1) != c2) return  false;
            }else {
                mapS.put(c1,c2);
            }

            if(mapT.containsKey(c2)){
                if(mapT.get(c2) != c1) return false;
             }else {
                 mapT.put(c2,c1);
            }
        }

        return  result;
    }
    public static void main(String args[]){
        String s = "abbaacc";
        String t = "fggffee";
        isIsomorphic(s,t);
    }

}
