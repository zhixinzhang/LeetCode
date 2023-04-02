package Company.Google.Array;

/**
 * Created by zhang on 2018/6/6.
 * 4. 给定两个字符串list A, B，返回第二个list中的每个元素是否是第一个list中某个字符串的subsequence。
 比如['aggressive', 'abc'], ['agr']，返回[True]。
 followup，如果A很大，并且B的字符串长度不超过6，有没有更好的办法？（可以preprocessing）. 1point3acres
 里口伞久尔
 */
//这是 392的follow up
public class _392_findSubSequence {
    public boolean findSub(String[] strings, String sub){
        for (String s : strings){
            if (isSubseq(s,sub))
                return true;
        }
        return false;
    }
    public boolean isSubseq(String s, String t){
        if (s.length() < t.length())  return  false;
        int sIndex = 0, tIndex = 0;
        while (tIndex < t.length()){
            if (sIndex < s.length() && (s.charAt(sIndex) == t.charAt(tIndex))){
                sIndex++;
            }
            tIndex++;
            if (tIndex == t.length())
                return true;
        }
        return false;
    }
}
