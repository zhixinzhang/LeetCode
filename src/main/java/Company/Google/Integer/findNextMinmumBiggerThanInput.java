package Company.Google.Integer;

/**
 * Created by zhang on 2018/6/7.
 * 1. LC原题，给一个数2134，用这个数的这些字符，排出最小的比它大的数；
 -follow up：如何不用Arrays.sort;
 lc 31
 */
public class findNextMinmumBiggerThanInput {
    public static int solve(int input){
        String curS = String.valueOf(4321);
        char[] tmp = curS.toCharArray();
        if (tmp.length <= 1)    return input;
        int left = curS.length()-2, right = curS.length()-1;
        for (;left>0;left--){
            if (tmp[left] < tmp[right]){
                char c = tmp[right];
                tmp[right] = tmp[left];
                tmp[left] = c;
                break;
            }else if (tmp[left] == tmp[right]){
                right--;
            }
        }
        input = tmp[0]-'0';
        for (int i = 1; i < tmp.length;i++){
            input = input*10 + tmp[i]-'0';
        }
        return input;
    }

    // - 123456   // -12345
    // -12365554   -12345556
    public static void main(String[] args){
        solve(1);
    }
}
