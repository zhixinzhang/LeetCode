package google.Integer;

/**
 * Created by zhang on 2018/6/
 * Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 https://www.geeksforgeeks.org/ugly-numbers/
 */
/**  1 * 2   2 * 2   3 * 2  4 * 2  5 * 2
 *   重点是 ugly number是 2 3 5 乘以ugly来的！！！！！
 *
 *
 *
 * */
public class _264_UglyNumber2_DP {
    //DataStructure.DP O(n) O(n)
    public static int nthUglyNumber_DP(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            /**n 2  3   4
             * [1 2 3]
             *f2 4  4   6
             *f3 3  9   9
             *f5 5  5   5
             *i2 1  1   2
             *i3 0  1   1
             *i5 0  0   0
             * **/
            if(factor2 == min)  // 当现在的最小值也就是uglynumber 下一个f2 2 乘以下一个ugly值
                factor2 = 2 * ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }

        // TLE
    public int nthUglyNumber(int n) {
        // 2 3 5

        int i = 1;
        int count = 1;
        while( n > count){
            i++;
            if(isUgly(i) == 1){
                count ++;
            }
        }
        return i;
    }
    public int isUgly(int no){
        no = maxDivid(no,2);
        no = maxDivid(no,3);
        no = maxDivid(no,5);
        return (no == 1) ? 1 : 0;
    }
    public int maxDivid(int no, int d){
        while(no % d == 0){
            no /= d;
        }
        return no;
    }
    public static void main(String[] args){
        nthUglyNumber_DP(10);
    }

}
