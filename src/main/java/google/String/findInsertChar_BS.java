package google.String;

/**
 * Created by zhang on 2018/6/26.
 * 第三轮：跟另一个面试的人，房间冲突，面试过程中还有两三轮敲门，然后更没想到的是第三轮的面试官，估计是一欧洲大叔？他一开口我就知道跪了，听不懂说话，还好第一问说是 warmup question很简单，就是两个本来相同String，有一个插入了一个字符，找出它，O(n) 解法很简单，然后followup是要你效率高一点，我说二分法吧，还没想到怎么做，后来想说可以在每一步二分的时候，向左向右匹配，然后他给我举了个例子：aaaaaaaaaa，插入的也是a，我就...，然后只有继续想，最奔溃的是，最后大叔估计也急了，给我了提示，结果说的就是我上面那个方法，我说这个办法不是不好么？他说极端情况下是不好啊，但是遇到正常的英语单词就会快不少，不是？然后最后9分钟，硬着头皮开始写，还在揪二分的细节的时候，时间到了。可能当初他给我举那个例子只
 * 是想确认我有没有考虑到，然而我以为是否认了这个方法，交流听不懂，这个教训有点
 */
public class findInsertChar_BS {
    public static char solution(String s1, String s2){
        char res = ' ';
        int i = 0;
        while(i < s1.length()){
            if (i < s2.length() && s1.charAt(i) == s2.charAt(i))
                i++;
            else
                return res = s1.length()>s2.length()?s1.charAt(i):s2.charAt(i);
        }
        return res = s1.length()>s2.length()?s1.charAt(s1.length()-1):s2.charAt(s2.length()-1);
    }

    public static char solution_BS(String s1, String s2){
        char res = ' ';
        // s1 longest
        if (s1.charAt(0) != s2.charAt(0)) return s1.charAt(0);
        if (s1.charAt(s1.length()-1) != s2.charAt(s2.length()-1)) return s1.charAt(s1.length()-1);
        int l = 0, r = s2.length()-1;
        while (l < r){
            int mid = l + (r - l) / 2;
            String curS1 = s2.substring(0,mid+1);
            String curS2 = s1.substring(0,mid+1);
            if (curS1.equals(curS2))
                l = mid+1;
            else
                r = mid-1;
        }
        return s1.charAt(l);
    }


    public static void main(String[] args){
//        char s = solution("abcde","abcdef");
        solution_BS("aabcde","abcde");
        int a = 0;
    }
}
