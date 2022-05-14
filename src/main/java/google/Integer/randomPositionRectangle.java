package google.Integer;

import java.util.Random;

/**
 * Created by zhang on 2018/6/25.
 * follow up  根据面积大小来计算概率
 * https://www.jiuzhang.com/qa/6650/
 *
 * 有重叠的话 我说了两种做法。第一种是找一个最小的大框 把重叠的 矩形都包含住。然后在大框被 随机选点。如果选的点不被包含在任何一个已有的矩阵里面的话 就再次随机选点 知道选中为止。
 * 第二种是对重叠的矩形进行分割 转换到 没有重叠的情况。面试官对这两种做法表示很满意
 *
 */
public class randomPositionRectangle {
    public static int[] solution(int m, int n){
        if (m == 0 || n == 0) return new int[2];
        int[] position = new int[2];
        int total = m * n;  // 3 * 4 = 12
        Random random = new Random();
        int p = 0;
        for (int i = 0; i<100; i++){
            p = random.nextInt(total);
            System.out.println("Times      + " + p);
        }
        //
        int i = 0;
        while (p > m){
            p /= m;
            i++;
        }
        position[0] = i;
        position[1] = p-1;
        return position;
    }

    //{3,4},{2,2},{4,3}
    public static int[] solution_followUp(int[][] retangle ){
        int[] position = new int[2];

        // 12 4 12  3 : 1 : 3
        // 12 16 28
        int[] sum = new int[retangle.length];
        sum[0] = retangle[0][0] * retangle[0][1];
        for (int i = 1; i < retangle.length; i++){
            sum[i] = retangle[i][0] * retangle[i][1] + sum[i-1];
        }
        Random random = new Random();
        int p = random.nextInt(sum[sum.length-1]);
        int rec = 0;
        for (int i = 0; i<sum.length; i++){
            if (p <= sum[i]){
                rec = i;
                break;
            }
        }
        int pos = random.nextInt(retangle[rec][0] * retangle[rec][1]);
        int i = 0;
        int n = retangle[rec][1];
        while (pos > n){
            pos /= n;
            i++;
        }
        position[0] = i;
        position[1] = pos -1;
        return position;
    }

    public static int[] solution_followUp_OverLap(int[][] retangle ){
        int[] pos = new int[2];
        return pos;
    }

    public static void main(String[] args){
        /**  x x x x
         *   x x x x
         *   x x x x
         * */
//        solution(3,4);
        //多个 rectangle 不重叠
        solution_followUp(new int[][]{{3,4},{2,2},{4,3}});

        // 多个rectangle 重叠

        solution_followUp_OverLap(new int[][]{{3,4},{2,2},{4,3}});


    }
}
