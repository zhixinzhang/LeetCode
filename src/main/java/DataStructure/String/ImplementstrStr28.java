package DataStructure.String;
//*******
/**这是算法中比较经典的问题，判断一个字符串是否是另一个字符串的子串。这个题目最经典的算法应该是KMP算法，不熟悉的朋友可以参见 Knuth–Morris–Pratt algorithm
 * 。KMP算法是最优的线性算法，复杂度已经达到这个问题的下限。但是KMP算法比较复杂，很难在面试的短时间里面完整正确的实现。所以一般在面试中并不要求实现KMP算法。
 下面我们先说说brute force的算法，假设原串的长度是n，匹配串的长度是m。思路很简单，就是对原串的每一个长度为m的字串都判断是否跟匹配串一致。总共有n-m个子串，所以算法时间复杂度为O((n-m)*m)=O(n*m)，空间复杂度是O(1)。代码如下：
 * */
/**
 * 实现strstr(). 返回needle(关键字)在haystack(字符串)中第一次出现的位置，如果needle不在haystack中，则返回-1。

 * Created by zhang on 2017/2/1.
 */
public class ImplementstrStr28 {
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        final int N = haystack.length() - needle.length()+1;
        for(int i = 0;i<N;i++){
            int j = i;
            int k = 0;
            while (j<haystack.length() && k<needle.length() && haystack.charAt(j) == needle.charAt(k)){
                j++;
                k++;
            }
            if(k== needle.length()) return i;
        }
        return  -1;
    }

}
