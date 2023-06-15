package Company.PayPal.OA;

import java.util.Arrays;

/**
 * 1）仓库柜子问题：基本上就是给一个数组，你来rank每个数字的大小。最小的数字的rank为1，第二小的数字rank为2，以此类推
 * 
*/
public class RankWarehouse {
    public static void main(String[] args) {
        rankWare(new int[]{1, 3, 7, 5, 4});
    }

    private static void rankWare(int[] arr){
        int maxRan = arr.length;
        Arrays.sort(arr);
        int[][] ans = new int[arr.length][2];
        for (int i = 1; i <= maxRan; i++){
            int index = i - 1;
            ans[index][0] = i;
            ans[index][1] = arr[index];
        }

        System.out.printf(" ", ans);
    }
    
}
