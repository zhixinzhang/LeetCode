package google;

/**
 * Created by zhang on 2017/11/29.
 */
//给一个integer list in ascending order，把每个数都平方，
// 返回排好序的平方数组。例子：[-2, -1, 0, 2]，返回[0, 1, 4, 4]。
// 也可以用两个powinter 从左和右面 向中间搜索
public class integerListInAscendingOrder {
    public static void main(String[] args ){
        System.out.println("result + ............" + find(new int[]{-2,-1,0,2}));
    }

    public static int[] find(int[] s){
        int[] res = new int[s.length];
        int curPosition= res.length-1;
        int curRight =res.length-1;
        for(int i = 0; i<res.length;){
            // -3 ……   2 , 4
            if(s[i]>=0){
                int curLen = curRight - i +1;
                for (int j = 0; j<curLen;j++){
                    res[j] = s[i]*s[i];
                    i++;
                }
                break;
            }else{
                if(Math.abs(s[i]) > s[curRight]){
                    res[curPosition] = s[i]*s[i];
                    curPosition--;
                    i++;
                }else if (Math.abs(s[i]) < s[curRight]){
                    res[curPosition] = s[curRight]*s[curRight];
                    curRight--;
                    curPosition--;
                }else {
                    res[curPosition] = s[i]*s[i];
                    curPosition--;
                    res[curPosition] = s[i]*s[i];
                    curPosition--;
                    i++;
                    curRight--;

                }

            }

        }

        return res;
    }

}
