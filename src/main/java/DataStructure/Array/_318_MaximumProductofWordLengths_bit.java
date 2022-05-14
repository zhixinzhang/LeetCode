package DataStructure.Array;

/**
 * Created by zhang on 2018/4/29.
 */
/**
 * 题目的意思是:在一个字符串组成的数组words中，找出max{Length(words[i])*Length(words[j])},其中words[i]和words[j]中没有相同的字母，在这里字符串由小写字母a-z组成的。
 思路:我们把每个字符串数组看成一个26大小的数组，小写字母a-z是26位，“abcd” 的int值为 0000 0000 0000 0000 0000 0000 0000 1111，“wxyz” 的int值为 1111 0000 0000 0000 0000 0000 0000 0000，
 这样两个进行与（&）得到0， 如果有相同的字母则不是0。
 * */
public class _318_MaximumProductofWordLengths_bit {
    public static int maxProduct(String[] words) {
        int len=words.length;
        if (len<=1) return 0;
        int[] mask=new int[len];
        //abcd可以length=4
        //words[i].charAt(0) 0左移0位
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <words[i].length() ; j++) {
                mask[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        int max= 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <len ; j++) {
                if((mask[i] & mask[j]) == 0){
                    max=Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        maxProduct(new String[]{"abcd","bcd","ab"});
    }
}
