package google;

/**
 * Created by zhang on 2018/7/11.
 * https://www.youtube.com/watch?v=kSlZlmuMdgE
 */
public class _418_SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for(int i = 0; i < rows; i++){
            start += cols;
            // 下一行的开头是否是空格，如果是，删去
            int a = start % l;
            if(s.charAt(start % l) == ' '){
                start++;
            } else {
                // 如果开头不是空格，检查上一行最末尾是否是空格
                // 如果不是空格，一个单词被分开到上下两行，不符合题目要求。
                // 在末尾增加空格，把单词完整的移到一下行的开头
                while( start > 0 && s.charAt((start-1)%l) != ' '){
                    start--;
                }
            }
        }
        return start / l;
    }


    public static void main(String[] args){
        wordsTyping(new String[]{"a","bcd","e"},3,6);
    }
}
